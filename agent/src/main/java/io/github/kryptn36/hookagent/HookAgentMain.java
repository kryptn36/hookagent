package io.github.kryptn36.hookagent;

import io.github.kryptn36.hookagent.extension.ExtensionManager;
import io.github.kryptn36.hookagent.transformers.JavassistTransformer;
import java.lang.instrument.Instrumentation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HookAgentMain {

  private static Logger log = LogManager.getLogger(HookAgentMain.class.getSimpleName());

  public static void premain(String args, Instrumentation instrumentation) {
    ExtensionManager extensionManager = new ExtensionManager();

    try {
      CodeSource codeSource = HookAgentMain.class.getProtectionDomain().getCodeSource();
      Path path = Paths.get(codeSource.getLocation().toURI());
      extensionManager.loadExtensions(Paths.get(path.getParent().toString(), "extensions"));
    } catch (Exception e) {
      log.error(e);
    }

    instrumentation.addTransformer(new JavassistTransformer());
  }

}
