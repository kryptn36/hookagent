package io.github.krpytn36.hookagent.javassist.steps;

import io.github.kryptn36.hookagent.transformer.ClassTransformerStep;
import javassist.CtClass;

class MethodMixinTransformerStep implements ClassTransformerStep<CtClass, CtClass> {

  @Override
  public CtClass transform(CtClass ctClass) throws Exception {
    return ctClass;
  }

}
