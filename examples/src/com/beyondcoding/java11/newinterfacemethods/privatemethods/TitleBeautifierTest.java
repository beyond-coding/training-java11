package com.beyondcoding.java11.newinterfacemethods.privatemethods;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleBeautifierTest {

  TitleBeautifier titleBeautifier = new TitleBeautifier() {};

  @ParameterizedTest
  @CsvSource({
      "lama, ** LAMA **",
      " gun, ** GUN **",
      "Elephant , ** ELEPHANT **",
      " mountain , ** MOUNTAIN **"
  })
  void testBeautifyWithStar(String text, String expected) {
    String actual = titleBeautifier.beautifyWithStar(text);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
      "lama, -- LAMA --",
      " gun, -- GUN --",
      "Elephant , -- ELEPHANT --",
      " mountain , -- MOUNTAIN --"
  })
  void testBeautifyWithDash(String text, String expected) {
    String actual = titleBeautifier.beautifyWithDash(text);

    assertEquals(expected, actual);
  }

}
