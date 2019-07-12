package com.beyondcoding.challenges.lambdas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeywordFinderTest {

  KeywordFinder finder = new KeywordFinder();

  @Test
  void findElegant() {
    var text = "The elephant is lifted eleven floors easily with the help of an electricity elevator";

    var actual = finder.findElegant(text);

    var expected = List.of("elephant", "eleven", "electricity", "elevator");
    assertEquals(expected, actual);
  }

  @Test
  void findPlayful() {
    var text = "The rightful heir of the powerful king had an awful accident playing with a colorful bear";

    var actual = finder.findPlayful(text);

    var expected = List.of("rightful", "powerful", "awful", "colorful");
    assertEquals(expected, actual);
  }
}