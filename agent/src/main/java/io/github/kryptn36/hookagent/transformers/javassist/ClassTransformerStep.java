package io.github.kryptn36.hookagent.transformers.javassist;

public interface ClassTransformerStep<T> {

  byte[] transform(T t);

}
