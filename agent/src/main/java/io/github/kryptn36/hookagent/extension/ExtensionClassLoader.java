package io.github.kryptn36.hookagent.extension;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ExtensionClassLoader extends URLClassLoader {

  private static final Logger log = LogManager.getLogger(ExtensionClassLoader.class.getSimpleName());

  private final ExtensionManager extensionManager;

  private final Path extensionsPath;

  public ExtensionClassLoader(ExtensionManager extensionManager, Path extensionsPath) throws MalformedURLException {
    super(new URL[]{new URL("jar:file:" + extensionsPath.toString() + "!/")});
    this.extensionManager = extensionManager;
    this.extensionsPath = extensionsPath;
  }

  public List<Extension> loadExtensions() throws Exception {
    List<Extension> loadedExtensions = new ArrayList<>();
    if (!Files.isDirectory(extensionsPath)) {
      return Collections.emptyList();
    }
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(extensionsPath, entry -> entry.toString().endsWith(".jar"))) {
      for (Path path : directoryStream) {
        loadedExtensions.addAll(loadJarFile(path));
      }
    }

    return loadedExtensions;
  }

  private List<Extension> loadJarFile(Path path) throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
    List<Extension> loadedExtensions = new ArrayList<>();

    JarFile jarFile = new JarFile(path.toFile());

    Enumeration<JarEntry> entryEnumeration = jarFile.entries();
    while (entryEnumeration.hasMoreElements()) {
      JarEntry jarEntry = entryEnumeration.nextElement();
      if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
        continue;
      }

      String className = jarEntry.getName().substring(0, jarEntry.getName().length() - ".class".length()).replace('/', '.');
      Class<?> loadedClass = loadClass(className);
      if (Extension.class.isAssignableFrom(loadedClass)) {
        Extension extension = (Extension) loadedClass.newInstance();
        loadedExtensions.add(extension);
      }
    }

    return loadedExtensions;
  }

}
