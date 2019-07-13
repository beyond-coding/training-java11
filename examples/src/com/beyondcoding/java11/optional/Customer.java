package com.beyondcoding.java11.optional;

import java.util.Optional;

public class Customer {

  public int pay(Optional<Pizza> pizza) {
    if (pizza.isEmpty()) {
      return 0;
    }
    Pizza thePizza = pizza.get();
    int length = thePizza.getName().length();
    return length;
  }

  public int rate(Optional<Pizza> pizza) {
    Pizza thePizza = pizza.orElseThrow(() -> new IllegalArgumentException("Where is my pizza?"));
    if (thePizza.getName().equalsIgnoreCase("hawaii")) {
      return 9;
    }
    return 5;
  }

}
