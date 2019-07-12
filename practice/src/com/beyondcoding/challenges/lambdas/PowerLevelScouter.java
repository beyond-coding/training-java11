package com.beyondcoding.challenges.lambdas;

import java.util.function.Function;

public class PowerLevelScouter {

  private static final Function<Character, Integer> FORMULA = character -> (int) character.charValue();

  public int scout(String name) {
    return scout(name, FORMULA);
  }

  public int scoutEnhanced(String name) {
    var lowercase = name.toLowerCase();
    return scout(lowercase, FORMULA);
  }

  private int scout(String name, Function<Character, Integer> function) {
    var powerLevel = 0;
    var characters = name.toCharArray();
    for (char character : characters) {
      powerLevel += function.apply(character);
    }
    return powerLevel;
  }
}
