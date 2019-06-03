package io.github.kryptn36.hookagent;

import io.github.kryptn36.hookagent.extension.ExtensionManager;
import java.lang.instrument.Instrumentation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HookAgentMain {

  private static Logger log = LogManager.getLogger(HookAgentMain.class.getSimpleName());

  public static void premain(String args, Instrumentation instrumentation) {
    try {
      CodeSource codeSource = HookAgentMain.class.getProtectionDomain().getCodeSource();
      Path path = Paths.get(codeSource.getLocation().toURI());
      ExtensionManager extensionManager = new ExtensionManager(Paths.get(path.getParent().toString(), "extensions"));
    } catch (Exception e) {
      log.error(e);
    }

    instrumentation.addTransformer(new HookAgentClassFileTransformer());
  }

}
