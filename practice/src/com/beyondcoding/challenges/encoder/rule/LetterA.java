package com.beyondcoding.challenges.encoder.rule;

public interface LetterA extends Vowel {

  @Override
  default boolean isApplicable(String letter) {
    var lowercase = letter.toLowerCase();
    return "a".contains(lowercase);
  }

  default String encode(String letter) {
    return "4";
  }
}
