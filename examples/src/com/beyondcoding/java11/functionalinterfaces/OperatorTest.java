package com.beyondcoding.java11.functionalinterfaces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

  UnaryOperator<String> toUpperCase = new UnaryOperator<String>() {
    @Override
    public String apply(String text) {
      return text.toUpperCase();
    }
  };

  @ParameterizedTest
  @CsvSource({
      "'', ''",
      "A, a",
      "A, A",
      "AB, ab",
      "AB, Ab",
      "AB, aB",
      "AB, aB",
      "AB, AB",
      "ABC, aBc"
  })
  void testIsLongerThan5Characters(String expected, String text) {
    String actual = toUpperCase.apply(text);

    assertEquals(expected, actual);
  }

}
