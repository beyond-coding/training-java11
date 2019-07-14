package com.beyondcoding.java11.functionalinterfaces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {

  Predicate<String> isLongerThan5Characters = new Predicate<String>() {
    @Override
    public boolean test(String text) {
      if (text == null) {
        return false;
      }
      return text.length() > 5;
    }
  };

  @ParameterizedTest
  @CsvSource({
      "false,",
      "false, ''",
      "false, 1",
      "false, 12",
      "false, 123",
      "false, 1234",
      "false, 12345",
      "true, 123456"
  })
  void test(boolean expected, String text) {
    boolean actual = isLongerThan5Characters.test(text);
    
    assertEquals(expected, actual);
  }

}
