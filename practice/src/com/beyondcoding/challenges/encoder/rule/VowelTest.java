package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class VowelTest {

  Rule rule = new Vowel() {};

  @Test
  void isApplicable() {
    var applicable = "aeiouAEIOU".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
    var nonApplicable = "bcdfghjklmnpqrstvwxyz !@#$%^&*()_+".split("");
    for (String letter : nonApplicable) {
      assertFalse(rule.isApplicable(letter));
    }
  }

  @ParameterizedTest
  @CsvSource({
      "'', ''",
      "a, A",
      "e, E",
      "i, I",
      "o, O",
      "u, U",
      "A, A",
      "E, E",
      "I, I",
      "O, O",
      "U, U"
  })
  void encode(String letter, String expected) {
    var actual = rule.encode(letter);

    assertEquals(expected, actual);
  }
}