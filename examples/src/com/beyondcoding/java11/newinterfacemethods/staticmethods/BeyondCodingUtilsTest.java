package com.beyondcoding.java11.newinterfacemethods.staticmethods;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeyondCodingUtilsTest {

  @ParameterizedTest
  @CsvSource({
      "Java 11, Java 11 and Beyond Coding is awesome",
      "You're learning fast, You're learning fast and Beyond Coding is awesome",
      "Lunch break is soon, Lunch break is soon and Beyond Coding is awesome",
  })
  void brand(String text, String expected) {
    String actual = BeyondCodingUtils.brand(text);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"Java 11", "You're learning fast", "Lunch break is soon"})
  void spam(String text) {
    String actual = BeyondCodingUtils.spam(text);

    String expected = text + " Beyond Coding Beyond Coding Beyond Coding";
    assertEquals(expected, actual);
  }
}