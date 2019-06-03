package io.github.kryptn36.hookagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Arrays;

public class HookAgentClassFileTransformer implements ClassFileTransformer {

  @Override
  public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
    throws IllegalClassFormatException {

    System.out.println("----------CLASS----------");
    System.out.println("Name: " + className);
    System.out.println("Redefined name: " + classBeingRedefined);
    System.out.println("Buffer: " + Arrays.toString(classfileBuffer));
    System.out.println("-------------------------");

    return new byte[0];
  }

}
