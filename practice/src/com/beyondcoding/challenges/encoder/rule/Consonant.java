package com.beyondcoding.challenges.encoder.rule;

public interface Consonant extends Rule {

  String consonants = "bcdfghjklmnpqrstvwxyz";

  @Override
  default boolean isApplicable(String letter) {
    var lowercase = letter.toLowerCase();
    return consonants.contains(lowercase);
  }

  default String encode(String letter) {
    return letter.toLowerCase();
  }
}
