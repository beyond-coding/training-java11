package com.beyondcoding.java11.functionalinterfaces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

  Function<Integer, String> toFlavouredText = new Function<Integer, String>() {
    @Override
    public String apply(Integer number) {
      return "Number " + number;
    }
  };

  @ParameterizedTest
  @CsvSource({
      "Number null,",
      "Number 1, 1",
      "Number -1, -1",
  })
  void testIsLongerThan5Characters(String expected, Integer number) {
    String actual = toFlavouredText.apply(number);

    assertEquals(expected, actual);
  }

}
