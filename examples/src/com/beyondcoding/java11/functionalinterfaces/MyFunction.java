package com.beyondcoding.java11.functionalinterfaces;

@FunctionalInterface
public interface MyFunction {

  String doSomething();
  
  //String doSomethingElse(); // error: can only have one abstract method

}
