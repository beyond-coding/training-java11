package com.beyondcoding.java11.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrustworthyPizzaDeliveryTest {

  TrustworthyPizzaDelivery pizzaDelivery = new TrustworthyPizzaDelivery();

  @ParameterizedTest
  @ValueSource(strings = {"margarita", "four seasons", "toscana", "hawaii"})
  void testDeliver(String name) {
    Optional<Pizza> actual = pizzaDelivery.deliver(name);

    assertNotNull(actual);
    assertTrue(actual.isPresent());
  }

  @Test
  void testDeliverFindsNoPizza() {
    Optional<Pizza> actual = pizzaDelivery.deliver("Some other name");

    assertNotNull(actual);
    assertTrue(actual.isEmpty());
    assertFalse(actual.isPresent());
    // The promise of returning a Pizza SOMETIMES was NOT broken
  }

}