package com.beyondcoding.java11.immutablefactories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ImmutableListTest {

  static Stream<Arguments> dataset() {
    return Stream.of(
        of(0, List.of()),
        of(1, List.of(1)),
        of(2, List.of(1, 2)),
        of(3, List.of(1, 2, 3)),
        of(4, List.of(1, 2, 3, 4)),
        of(5, List.of(1, 2, 3, 4, 5)),
        of(6, List.of(1, 2, 3, 4, 5, 6)),
        of(7, List.of(1, 2, 3, 4, 5, 6, 7)),
        of(8, List.of(1, 2, 3, 4, 5, 6, 7, 8)),
        of(9, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
        of(10, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
        of(11, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)), // dynamic arguments after 10
        of(2, List.of(1, 1)) // allows repeated elements
    );
  }

  @ParameterizedTest
  @MethodSource("dataset")
  void testListOf(int expectedSize, List<Integer> list) {
    assertEquals(expectedSize, list.size());
  }

  @Test
  void testListOfIsImmutable() {
    List<Integer> list = List.of(1);

    assertEquals(1, list.size());
    assertEquals(Integer.valueOf(1), list.get(0));

    assertThrows(UnsupportedOperationException.class, () -> list.add(2));
    assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
  }

}
