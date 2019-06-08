package io.github.kryptn36.hookagent.extensions;

import io.github.kryptn36.hookagent.annotations.ClassFacade;
import io.github.kryptn36.hookagent.annotations.ClassMixin;
import io.github.kryptn36.hookagent.transformer.ClassTransformer;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ExtensionPipeline {

  private static final Logger log = LogManager.getLogger(ExtensionPipeline.class.getSimpleName());

  private final MultiValuedMap<String, Class<?>> facades = new ArrayListValuedHashMap<>();
  private final MultiValuedMap<String, Class<?>> mixins = new ArrayListValuedHashMap<>();

  private final ClassTransformer classTransformer;

  public ExtensionPipeline(ClassTransformer classTransformer) {
    this.classTransformer = classTransformer;
  }

  public void addFacade(Class<?> facade) {
    if (!facade.isAnnotationPresent(ClassFacade.class)) {
      log.error(facade.getName() + " has no ClassFacade annotation.");
      return;
    }

    ClassFacade classFacade = facade.getAnnotation(ClassFacade.class);
    facades.put(classFacade.value(), facade);
  }

  public void addMixin(Class<?> mixin) {
    if (!mixin.isAnnotationPresent(ClassMixin.class)) {
      log.error(mixin.getName() + " has no ClassFacade annotation.");
      return;
    }

    ClassMixin classMixin = mixin.getAnnotation(ClassMixin.class);
    mixins.put(classMixin.value(), mixin);
  }

  public byte[] transform(String className, byte[] classBytes) {
    return classTransformer.transform(className, classBytes);
  }

}
