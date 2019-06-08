import io.github.kryptn36.hookagent.extensions.Extension;
import io.github.kryptn36.hookagent.extensions.ExtensionManager;

public class ExampleExtension extends Extension {

  @Override
  public void init(ExtensionManager extensionManager) {
    System.out.println("ExampleExtension has been loaded!");
  }

}
