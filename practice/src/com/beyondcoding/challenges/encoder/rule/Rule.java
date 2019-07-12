package com.beyondcoding.challenges.encoder.rule;

public interface Rule {

  boolean isApplicable(String letter);

  String encode(String letter);

}
