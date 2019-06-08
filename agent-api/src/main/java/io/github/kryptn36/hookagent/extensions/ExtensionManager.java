package io.github.kryptn36.hookagent.extensions;

import java.nio.file.Path;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtensionManager {

  private static final Logger log = LogManager.getLogger(ExtensionManager.class.getSimpleName());

  public ExtensionManager(Path path) {
    Validate.notNull(path, "The path can not be null.");

    try {
      ExtensionLoader extensionClassLoader = new ExtensionLoader(this, path);
      extensionClassLoader.loadExtensions();
    } catch (Exception e) {
      log.error(e);
    }
  }

}
