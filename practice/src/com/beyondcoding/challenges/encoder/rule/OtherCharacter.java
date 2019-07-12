package com.beyondcoding.challenges.encoder.rule;

public interface OtherCharacter extends Rule {

  @Override
  default boolean isApplicable(String letter) {
    return true;
  }

  default String encode(String letter) {
    return letter;
  }
}
