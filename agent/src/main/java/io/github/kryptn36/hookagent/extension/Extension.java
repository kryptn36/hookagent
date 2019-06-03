package io.github.kryptn36.hookagent.extension;

public abstract class Extension {

  private ExtensionPipeline extensionPipeline = new ExtensionPipeline();

  public abstract void init(ExtensionManager extensionManager);


}
