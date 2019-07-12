package com.beyondcoding.challenges.encoder.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OtherCharacterTest {

  Rule rule = new OtherCharacter() {};

  @Test
  void isApplicable() {
    var applicable = "0123456789abcdefghijklmnopqrstuvwxyz !@#$%^&*()_+".split("");
    for (String letter : applicable) {
      assertTrue(rule.isApplicable(letter));
    }
  }

  @Test
  void encode() {
    var letters = "0123456789abcdefghijklmnopqrstuvwxyz !@#$%^&*()_+".split("");
    for (String expected : letters) {
      var actual = rule.encode(expected);
      assertEquals(expected, actual);
    }
  }
}