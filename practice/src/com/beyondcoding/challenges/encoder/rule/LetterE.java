package com.beyondcoding.challenges.encoder.rule;

public interface LetterE extends Rule {

  @Override
  default boolean isApplicable(String letter) {
    var lowercase = letter.toLowerCase();
    return "e".contains(lowercase);
  }

  default String encode(String letter) {
    return "3";
  }
}
