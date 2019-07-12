package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConsonantTest {

  Rule rule = new Consonant() {};

  @Test
  void isApplicable() {
    var applicable = "bcdfghjklmnpqrstvwxyz".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
    var nonApplicable = "aeiou1234567890 !@#$%^&*()_+".split("");
    for (String letter : nonApplicable) {
      assertFalse(rule.isApplicable(letter));
    }
  }

  @ParameterizedTest
  @CsvSource({
      "'', ''",
      "b, b",
      "B, b"
  })
  void encode(String letter, String expected) {
    var actual = rule.encode(letter);

    assertEquals(expected, actual);
  }
}