package com.beyondcoding.java11.optional;

import java.util.Optional;
import java.util.Set;

public class TrustworthyPizzaDelivery {

  private Set<Pizza> available = Set.of(
      new Pizza("Margarita"), new Pizza("Four Seasons"),
      new Pizza("Toscana"), new Pizza("Hawaii")
  );

  public Optional<Pizza> deliver(String name) {
    for (Pizza pizza : available) {
      if (pizza.getName().equalsIgnoreCase(name)) {
        return Optional.of(pizza);
      }
    }
    return Optional.empty();
  }
}
