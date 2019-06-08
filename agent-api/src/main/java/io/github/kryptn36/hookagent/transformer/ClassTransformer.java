package io.github.kryptn36.hookagent.transformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.List;

public interface ClassTransformer extends ClassFileTransformer {

  @Override
  default byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
    throws IllegalClassFormatException {

    return transform(className, classfileBuffer);
  }

  byte[] transform(String className, byte[] classBytes);

  List<ClassTransformerStep> getClassTransformerSteps();

}
