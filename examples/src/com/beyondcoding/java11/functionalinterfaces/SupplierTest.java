package com.beyondcoding.java11.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

  Supplier<String> supplier = new Supplier<String>() {
    @Override
    public String get() {
      return "something";
    }
  };

  @Test
  void test() {
    String actual = supplier.get();

    String expected = "something";
    assertEquals(expected, actual);
  }

}
