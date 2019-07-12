package com.beyondcoding.challenges.encoder.rule;

public interface Vowel extends Rule {

  String vowels = "aeiou";

  @Override
  default boolean isApplicable(String letter) {
    var lowercase = letter.toLowerCase();
    return vowels.contains(lowercase);
  }

  default String encode(String letter) {
    return letter.toUpperCase();
  }
}
