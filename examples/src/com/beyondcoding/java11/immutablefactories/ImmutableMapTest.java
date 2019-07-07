package com.beyondcoding.java11.immutablefactories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ImmutableMapTest {

  static Stream<Arguments> dataset() {
    return Stream.of(
        of(0, Map.of()),
        of(1, Map.of(1, "1")),
        of(2, Map.of(1, "1", 2, "2")),
        of(3, Map.of(1, "1", 2, "2", 3, "3")),
        of(4, Map.of(1, "1", 2, "2", 3, "3", 4, "4")),
        of(5, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5")),
        of(6, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5",
            6, "6")),
        of(7, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5",
            6, "6", 7, "7")),
        of(8, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5",
            6, "6", 7, "7", 8, "8")),
        of(9, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5",
            6, "6", 7, "7", 8, "8", 9, "9")),
        of(10, Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5",
            6, "6", 7, "7", 8, "8", 9, "9", 10, "10")) // no dynamic arguments after 10
    );
  }

  @ParameterizedTest
  @MethodSource("dataset")
  void testMapOf(int expectedSize, Map<Integer, String> map) {
    assertEquals(expectedSize, map.size());
  }

  @Test
  void testMapOfIsImmutable() {
    Map<Integer, String> map = Map.of(1, "1");

    assertEquals(1, map.size());
    assertEquals("1", map.get(1));

    assertThrows(UnsupportedOperationException.class, () -> map.put(2, "2"));
    assertThrows(UnsupportedOperationException.class, () -> map.remove(1));
  }

  @Test
  void testMapOfDoesNotAllowRepeatedElementsViaArguments() {
    assertThrows(IllegalArgumentException.class, () -> Map.of(1, "1", 1, "1"));
    assertThrows(IllegalArgumentException.class, () -> Map.of(1, "1", 1, "2"));
    assertThrows(IllegalArgumentException.class, () -> Map.of("1", "1", "1", "1"));
    assertThrows(IllegalArgumentException.class, () -> Map.of("1", "1", "1", "2"));
  }

}
