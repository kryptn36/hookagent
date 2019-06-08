package io.github.kryptn36.hookagent.extensions;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceLoader;

class ExtensionLoader {

  private ExtensionManager extensionManager;
  private Path extensionsPath;

  public ExtensionLoader(ExtensionManager extensionManager, Path extensionsPath) {
    this.extensionManager = extensionManager;
    this.extensionsPath = extensionsPath;
  }

  public void loadExtensions() throws IOException {
    Collection<URL> urlList = new ArrayList<>();

    try (DirectoryStream<Path> jars = Files.newDirectoryStream(extensionsPath, "*.jar")) {
      for (Path jar : jars) {
        urlList.add(jar.toUri().toURL());
      }
    }

    ClassLoader pluginClassLoader = new URLClassLoader(urlList.toArray(new URL[0]), Extension.class.getClassLoader());

    ServiceLoader<Extension> plugins = ServiceLoader.load(Extension.class, pluginClassLoader);

    for (Extension plugin : plugins) {
      plugin.init(extensionManager);
    }
  }

}
