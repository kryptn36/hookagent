package de.kryptn36.hookagent.annotations;

public @interface Method {

  String value();

  String signature() default "";

}
