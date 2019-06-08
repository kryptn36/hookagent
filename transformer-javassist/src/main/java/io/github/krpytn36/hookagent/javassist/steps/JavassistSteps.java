package io.github.krpytn36.hookagent.javassist.steps;

public class JavassistSteps {

  private JavassistSteps() {
  }

  public static FacadeTransformerStep facadeStep() {
    return new FacadeTransformerStep();
  }

  public static FieldMixinTransformerStep fieldMixinStep() {
    return new FieldMixinTransformerStep();
  }

  public static GetterTransformerStep getterStep() {
    return new GetterTransformerStep();
  }

  public static MethodInjectionTransformerStep methodInjectionStep() {
    return new MethodInjectionTransformerStep();
  }

  public static MethodMixinTransformerStep methodMixinStep() {
    return new MethodMixinTransformerStep();
  }

  public static SetterTransformerStep setterStep() {
    return new SetterTransformerStep();
  }

}
