package io.github.kryptn36.hookagent.extension;

import io.github.kryptn36.hookagent.annotations.ClassFacade;
import io.github.kryptn36.hookagent.annotations.ClassMixin;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtensionManager {

  private static final Logger log = LogManager.getLogger(ExtensionManager.class.getSimpleName());

  private List<Extension> extensions = new ArrayList<>();

  public ExtensionManager(Path path) {
    Validate.notNull(path, "The path can not be null.");

    try {
      ExtensionClassLoader extensionClassLoader = new ExtensionClassLoader(this, path);
      extensionClassLoader.loadExtensions();
    } catch (Exception e) {
      log.error(e);
    }
  }

  public void addFacade(Class<?> facade) {
    Validate.notNull(facade, "The facade can not be null.");

    if (!facade.isAnnotationPresent(ClassFacade.class)) {
      log.error(facade.getName() + " has no ClassFacade annotation.");
      return;
    }


  }

  public void addMixin(Class<?> mixin) {
    Validate.notNull(mixin, "The mixin can not be null.");

    if (!mixin.isAnnotationPresent(ClassMixin.class)) {
      log.error(mixin.getName() + " has no ClassFacade annotation.");
      return;
    }


  }

  public List<Extension> getExtensions() {
    return extensions;
  }

}
