package com.beyondcoding.challenges.encoder.rule;

public interface Number extends Rule {

  String numbers = "1234567890";

  @Override
  default boolean isApplicable(String letter) {
    return numbers.contains(letter);
  }

  default String encode(String letter) {
    var times = Integer.valueOf(letter);
    return letter.repeat(times);
  }
}
