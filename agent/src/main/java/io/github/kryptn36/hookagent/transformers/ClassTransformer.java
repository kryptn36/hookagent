package io.github.kryptn36.hookagent.transformers;

import io.github.kryptn36.hookagent.transformers.javassist.ClassTransformerStep;
import java.util.List;

public interface ClassTransformer {

  byte[] transform(String className, byte[] classBytes);

  List<ClassTransformerStep> getClassTransformerSteps();

}
