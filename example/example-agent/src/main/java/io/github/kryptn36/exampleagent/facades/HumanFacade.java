package io.github.kryptn36.exampleagent.facades;

import io.github.kryptn36.hookagent.annotations.ClassFacade;
import io.github.kryptn36.hookagent.annotations.Getter;
import io.github.kryptn36.hookagent.annotations.Method;
import io.github.kryptn36.hookagent.annotations.Setter;

@ClassFacade("de.kryptn36.example.Human")
public interface HumanFacade {

  @Getter("name")
  String getName();

  @Setter("name")
  void setName(String name);

  @Getter("age")
  int getAge();

  @Setter("age")
  void setAge(int age);

  @Method(value = "talk", signature = "()V")
  void talk();

}
