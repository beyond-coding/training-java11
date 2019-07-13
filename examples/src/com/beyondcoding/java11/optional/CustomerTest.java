package com.beyondcoding.java11.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

  Customer customer = new Customer();
  TrustworthyPizzaDelivery pizzaDelivery = new TrustworthyPizzaDelivery();

  @ParameterizedTest
  @CsvSource({
      ", 0",
      "'', 0",
      "unknown, 0",
      "margarita, 9",
      "four seasons, 12",
      "toscana, 7",
      "hawaii, 6"
  })
  void pay(String pizzaName, int expected) {
    Optional<Pizza> pizza = pizzaDelivery.deliver(pizzaName);

    int actual = customer.pay(pizza);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "margarita, 5",
      "four seasons, 5",
      "toscana, 5",
      "hawaii, 9"
  })
  void rate(String pizzaName, int expected) {
    Optional<Pizza> pizza = pizzaDelivery.deliver(pizzaName);

    int actual = customer.rate(pizza);

    assertEquals(expected, actual);
  }

  @Test
  void rateReceivesNoPizza() {
    Optional<Pizza> pizza = Optional.empty();
    assertThrows(IllegalArgumentException.class, () -> customer.rate(pizza));
  }
}