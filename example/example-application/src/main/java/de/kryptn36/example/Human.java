package de.kryptn36.example;

public class Human {

  private String name;
  private int age;

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void talk() {
    System.out.println("Hey! My name is " + name);
  }

}
