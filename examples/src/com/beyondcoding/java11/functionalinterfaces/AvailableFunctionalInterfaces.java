package com.beyondcoding.java11.functionalinterfaces;

import java.util.function.*;

public class AvailableFunctionalInterfaces {

  void coveredFunctionalInterfaces() {
    Predicate<String> predicate;
    Function<Integer, String> function;
    UnaryOperator<String> operator;
    Supplier<String> supplier;
    Consumer<String> consumer;
  }

  void initFunctionalInterfaceWithMethod() {
    MyFunction myFunction = getMyFunction();
  }

  private MyFunction getMyFunction() {
    return new MyFunction() {
      @Override
      public String doSomething() {
        return "This method does something";
      }
    };
  }
}
