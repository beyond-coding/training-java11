package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

  Rule rule = new Number() {};

  @Test
  void isApplicable() {
    var applicable = "0123456789".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
    var nonApplicable = "abcdefghijklmnopqrstuvwxyz !@#$%^&*()_+".split("");
    for (String letter : nonApplicable) {
      assertFalse(rule.isApplicable(letter));
    }
  }

  @ParameterizedTest
  @CsvSource({
      "0, ''",
      "1, 1",
      "2, 22",
      "3, 333",
      "4, 4444",
      "5, 55555",
      "6, 666666",
      "7, 7777777",
      "8, 88888888",
      "9, 999999999"
  })
  void encode(String letter, String expected) {
    var actual = rule.encode(letter);

    assertEquals(expected, actual);
  }
}