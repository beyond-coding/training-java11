package com.beyondcoding.challenges.lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerLevelScouterTest {

  PowerLevelScouter scouter = new PowerLevelScouter();

  @Test
  void testScout() {
    var name = "Susana";

    var actual = scouter.scout(name);

    var expected = 619;
    assertEquals(expected, actual);
  }

  @Test
  void testScoutEnhanced() {
    var name = "Susana";

    var actual = scouter.scoutEnhanced(name);

    var expected = 651;
    assertEquals(expected, actual);
  }


}