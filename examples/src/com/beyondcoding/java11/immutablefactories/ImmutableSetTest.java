package com.beyondcoding.java11.immutablefactories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ImmutableSetTest {

  static Stream<Arguments> dataset() {
    return Stream.of(
        of(0, Set.of()),
        of(1, Set.of(1)),
        of(2, Set.of(1, 2)),
        of(3, Set.of(1, 2, 3)),
        of(4, Set.of(1, 2, 3, 4)),
        of(5, Set.of(1, 2, 3, 4, 5)),
        of(6, Set.of(1, 2, 3, 4, 5, 6)),
        of(7, Set.of(1, 2, 3, 4, 5, 6, 7)),
        of(8, Set.of(1, 2, 3, 4, 5, 6, 7, 8)),
        of(9, Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
        of(10, Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
        of(11, Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)) // dynamic arguments after 10
    );
  }

  @ParameterizedTest
  @MethodSource("dataset")
  void testSetOf(int expectedSize, Set<Integer> set) {
    assertEquals(expectedSize, set.size());
  }

  @Test
  void testSetOfIsImmutable() {
    Set<Integer> set = Set.of(1);

    assertEquals(1, set.size());
    assertTrue(set.contains(1));

    assertThrows(UnsupportedOperationException.class, () -> set.add(2));
    assertThrows(UnsupportedOperationException.class, () -> set.remove(0));
  }

  @Test
  void testSetOfDoesNotAllowRepeatedElementsViaArguments() {
    assertThrows(IllegalArgumentException.class, () -> Set.of(1, 1));
    assertThrows(IllegalArgumentException.class, () -> Set.of("a", "a"));
    assertThrows(IllegalArgumentException.class, () -> Set.of(true, true));
  }

}
