package io.github.kryptn36.hookagent.extension;

import io.github.kryptn36.hookagent.annotations.ClassFacade;
import io.github.kryptn36.hookagent.annotations.ClassMixin;
import io.github.kryptn36.hookagent.transformers.ClassTransformer;
import io.github.kryptn36.hookagent.transformers.JavassistClassTransformer;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtensionPipeline {

  private static final Logger log = LogManager.getLogger(ExtensionPipeline.class.getSimpleName());

  private MultiValuedMap<String, Class<?>> facades = new ArrayListValuedHashMap<>();
  private MultiValuedMap<String, Class<?>> mixins = new ArrayListValuedHashMap<>();

  private ClassTransformer classTransformer = new JavassistClassTransformer();

  public void addFacade(Class<?> facade) {
    Validate.notNull(facade, "The facade can not be null.");

    if (!facade.isAnnotationPresent(ClassFacade.class)) {
      log.error(facade.getName() + " has no ClassFacade annotation.");
      return;
    }

    ClassFacade classFacade = facade.getAnnotation(ClassFacade.class);
    facades.put(classFacade.value(), facade);
  }

  public void addMixin(Class<?> mixin) {
    Validate.notNull(mixin, "The mixin can not be null.");

    if (!mixin.isAnnotationPresent(ClassMixin.class)) {
      log.error(mixin.getName() + " has no ClassFacade annotation.");
      return;
    }

    ClassMixin classMixin = mixin.getAnnotation(ClassMixin.class);
    mixins.put(classMixin.value(), mixin);
  }

  public byte[] transform(byte[] classBytes) {
    return classTransformer.transform(classBytes);
  }

}
