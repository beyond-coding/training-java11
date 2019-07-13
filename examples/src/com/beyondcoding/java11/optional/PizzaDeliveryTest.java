package com.beyondcoding.java11.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PizzaDeliveryTest {

  PizzaDelivery pizzaDelivery = new PizzaDelivery();

  @ParameterizedTest
  @ValueSource(strings = {"margarita", "four seasons", "toscana", "hawaii"})
  void testDeliver(String name) {
    Pizza actual = pizzaDelivery.deliver(name);

    assertNotNull(actual);
  }

  @Test
  void testDeliverFindsNoPizza() {
    Pizza actual = pizzaDelivery.deliver("Some other name");

    assertNull(actual);
    // The promise of returning an actual Pizza was broken
  }
}