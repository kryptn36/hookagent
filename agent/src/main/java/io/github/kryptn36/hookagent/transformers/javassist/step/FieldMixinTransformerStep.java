package io.github.kryptn36.hookagent.transformers.javassist.step;

import io.github.kryptn36.hookagent.transformers.javassist.ClassTransformerStep;
import javassist.CtClass;

public class FieldMixinTransformerStep implements ClassTransformerStep<CtClass> {

  @Override
  public byte[] transform(CtClass ctClass) {
    return new byte[0];
  }

}