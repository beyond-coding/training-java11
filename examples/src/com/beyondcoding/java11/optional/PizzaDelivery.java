package com.beyondcoding.java11.optional;

import java.util.Set;

public class PizzaDelivery {

  private Set<Pizza> available = Set.of(
      new Pizza("Margarita"), new Pizza("Four Seasons"),
      new Pizza("Toscana"), new Pizza("Hawaii")
  );

  public Pizza deliver(String name) {
    for (Pizza pizza : available) {
      if (pizza.getName().equalsIgnoreCase(name)) {
        return pizza;
      }
    }
    return null;
  }

}
