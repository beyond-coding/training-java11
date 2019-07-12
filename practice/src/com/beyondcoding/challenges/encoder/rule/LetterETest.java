package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LetterETest {

  Rule rule = new LetterE() {};

  @Test
  void isApplicable() {
    var applicable = "eE".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
    var nonApplicable = "aiou1234567890 !@#$%^&*()_+".split("");
    for (String letter : nonApplicable) {
      assertFalse(rule.isApplicable(letter));
    }
  }

  @ParameterizedTest
  @CsvSource({
      "'', 3",
      "a, 3",
      "A, 3"
  })
  void encode(String letter, String expected) {
    var actual = rule.encode(letter);

    assertEquals(expected, actual);
  }
}