package io.github.kryptn36.hookagent.transformer;

@FunctionalInterface
public interface ClassTransformerStep<T, R> {

  R transform(T t) throws Exception;

}
