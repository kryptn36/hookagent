package io.github.kryptn36.hookagent.extensions;

import org.apache.commons.lang3.Validate;

public abstract class Extension {

  private ExtensionPipeline extensionPipeline = null;

  public abstract void init(ExtensionManager extensionManager);

  public void addFacade(Class<?> facade) {
    Validate.notNull(facade, "The facade must not be null.");

    extensionPipeline.addFacade(facade);
  }

  public void addMixin(Class<?> mixin) {
    Validate.notNull(mixin, "The mixin must not be null.");

    extensionPipeline.addMixin(mixin);
  }

}
