package io.github.kryptn36.exampleagent;

import io.github.kryptn36.exampleagent.facades.HumanFacade;
import io.github.kryptn36.exampleagent.mixins.HumanMixin;
import io.github.kryptn36.hookagent.extension.Extension;
import io.github.kryptn36.hookagent.extension.ExtensionManager;

public class ExampleExtension extends Extension {

  public void init(ExtensionManager extensionManager) {
    System.out.println("ExampleExtension has been loaded!");
    //extensionManager.addFacade(HumanFacade.class);
    //extensionManager.addMixin(HumanMixin.class);
  }

}
