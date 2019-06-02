import io.github.kryptn36.hookagent.extension.Extension;
import io.github.kryptn36.hookagent.extension.ExtensionManager;

public class ExampleExtension implements Extension {

  public void init(ExtensionManager extensionManager) {
    System.out.println("ExampleExtension has been loaded!");
  }

}
