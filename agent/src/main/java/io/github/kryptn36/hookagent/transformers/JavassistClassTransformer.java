package io.github.kryptn36.hookagent.transformers;

import io.github.kryptn36.hookagent.transformers.ClassTransformer;
import io.github.kryptn36.hookagent.transformers.javassist.ClassTransformerStep;
import io.github.kryptn36.hookagent.transformers.javassist.step.FacadeTransformerStep;
import io.github.kryptn36.hookagent.transformers.javassist.step.GetterTransformerStep;
import java.util.ArrayList;
import java.util.List;

public class JavassistClassTransformer implements ClassTransformer {

  private List<ClassTransformerStep> classTransformerSteps = new ArrayList<>();

  public JavassistClassTransformer() {
    classTransformerSteps.add(new FacadeTransformerStep());
    classTransformerSteps.add(new GetterTransformerStep());
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
