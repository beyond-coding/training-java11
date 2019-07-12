package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LetterATest {

  Rule rule = new LetterA() {};

  @Test
  void isApplicable() {
    var applicable = "aA".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
    var nonApplicable = "eiou1234567890 !@#$%^&*()_+".split("");
    for (String letter : nonApplicable) {
      assertFalse(rule.isApplicable(letter));
    }
  }

  @ParameterizedTest
  @CsvSource({
      "'', 4",
      "a, 4",
      "A, 4"
  })
  void encode(String letter, String expected) {
    var actual = rule.encode(letter);

    assertEquals(expected, actual);
  }
}