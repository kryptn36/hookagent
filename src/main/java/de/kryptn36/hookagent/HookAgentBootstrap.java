package de.kryptn36.hookagent;

import java.lang.instrument.Instrumentation;

public class HookAgentBootstrap {

  public static void premain(String args, Instrumentation instrumentation) {
    instrumentation.addTransformer(new JavassistTransformer());
  }

}
