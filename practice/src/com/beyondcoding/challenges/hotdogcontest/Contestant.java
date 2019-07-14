package com.beyondcoding.challenges.hotdogcontest;

public class Contestant {
  
  private String name;
  private String gender;
  private int consumed;

  public Contestant(String name, String gender, int consumed) {
    this.name = name;
    this.gender = gender;
    this.consumed = consumed;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public int getConsumed() {
    return consumed;
  }
}
