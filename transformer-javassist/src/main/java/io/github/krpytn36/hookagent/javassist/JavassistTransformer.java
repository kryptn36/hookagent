package io.github.krpytn36.hookagent.javassist;

import static io.github.krpytn36.hookagent.javassist.steps.JavassistSteps.facadeStep;
import static io.github.krpytn36.hookagent.javassist.steps.JavassistSteps.fieldMixinStep;

import io.github.kryptn36.hookagent.transformer.ClassTransformer;
import io.github.kryptn36.hookagent.transformer.ClassTransformerStep;
import java.util.ArrayList;
import java.util.List;

public class JavassistTransformer implements ClassTransformer {

  private List<ClassTransformerStep> classTransformerSteps = new ArrayList<>();

  public JavassistTransformer() {
    classTransformerSteps.add(facadeStep());
    classTransformerSteps.add(fieldMixinStep());
  }

  @Override
  public byte[] transform(String className, byte[] classBytes) {
    return new byte[0];
  }

  @Override
  public List<ClassTransformerStep> getClassTransformerSteps() {
    return classTransformerSteps;
  }

}