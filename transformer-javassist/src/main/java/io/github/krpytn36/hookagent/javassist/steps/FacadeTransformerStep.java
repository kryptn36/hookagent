package io.github.krpytn36.hookagent.javassist.steps;

import io.github.kryptn36.hookagent.annotations.ClassFacade;
import io.github.kryptn36.hookagent.transformer.ClassTransformerStep;
import javassist.CtClass;

class FacadeTransformerStep implements ClassTransformerStep<CtClass, CtClass> {

  @Override
  public CtClass transform(CtClass ctClass) throws Exception {
    if (!ctClass.hasAnnotation(ClassFacade.class)) {
      return ctClass;
    }

    ClassFacade classFacade = (ClassFacade) ctClass.getAnnotation(ClassFacade.class);

    return ctClass;
  }

}
