package com.beyondcoding.java11.stream.basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamIntermediateOperationsTest {

  List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

  @Test
  void testSkip() {
    List<Integer> skipped = numbers.stream()
                                   .skip(2)
                                   .collect(Collectors.toList());
    assertEquals(List.of(3, 4, 5, 6), skipped);
  }

  @Test
  void testLimit() {
    List<Integer> limited = numbers.stream()
                                   .limit(2)
                                   .collect(Collectors.toList());
    assertEquals(List.of(1, 2), limited);
  }

  @Test
  void testMap() {
    List<Integer> multiplied = numbers.stream()
                                      .map(number -> number * 2)
                                      .collect(Collectors.toList());
    assertEquals(List.of(2, 4, 6, 8, 10, 12), multiplied);
  }

  @Test
  void testFlatMap() {
    List<List<Integer>> listOfListsOfNumbers = List.of(List.of(1, 2), List.of(3, 4));
    List<Integer> listOfNumbers = listOfListsOfNumbers.stream()
                                                      .flatMap(list -> list.stream())
                                                      .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), listOfNumbers);
  }

  @Test
  void testPeek() {
    List<Integer> other = new ArrayList<>();
    List<Integer> unchanged = numbers.stream()
                                     .peek(number -> other.add(number * 2))
                                     .collect(Collectors.toList());
    assertEquals(List.of(2, 4, 6, 8, 10, 12), other);
    assertEquals(List.of(1, 2, 3, 4, 5, 6), unchanged);
  }

  @Test
  void testFilter() {
    List<Integer> even = numbers.stream()
                                .filter(e -> e % 2 == 0)
                                .collect(Collectors.toList());
    assertEquals(List.of(2, 4, 6), even);
  }

  @Test
  void testDistinct() {
    List<Integer> repeated = List.of(1, 1, 2, 2);
    List<Integer> unique = repeated.stream()
                                   .distinct()
                                   .collect(Collectors.toList());
    assertEquals(List.of(1, 2), unique);
  }

  @Test
  void testSorted() {
    List<Integer> unsorted = List.of(2, 1, 3, 4);
    List<Integer> sorted = unsorted.stream()
                                   .sorted()
                                   .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), sorted);

    List<Integer> reversed = unsorted.stream()
                                     .sorted(Comparator.reverseOrder())
                                     .collect(Collectors.toList());
    assertEquals(List.of(4, 3, 2, 1), reversed);

    List<Integer> evenFirst = unsorted.stream()
                                      .sorted((e1, e2) -> e1 % 2 == 0 ? -1 : 1)
                                      .collect(Collectors.toList());
    assertEquals(List.of(4, 2, 1, 3), evenFirst);
  }

  @Test
  void testTakeWhile() {
    List<Integer> smallerThan3 = numbers.stream()
                                        .takeWhile(number -> number < 3)
                                        .collect(Collectors.toList());
    assertEquals(List.of(1, 2), smallerThan3);

    List<Integer> differentThan3 = numbers.stream()
                                          .takeWhile(number -> number != 3)
                                          .collect(Collectors.toList());
    assertEquals(List.of(1, 2), differentThan3);
    // the flow stops after the first time that the condition is not met
    // when the number 3 is dropped, the stream stops leaving behind the 4, the 5 and the 6
  }

  @Test
  void testDropWhile() {
    List<Integer> biggerOrEqualThan3 = numbers.stream()
                                              .dropWhile(number -> number < 3)
                                              .collect(Collectors.toList());
    assertEquals(List.of(3, 4, 5, 6), biggerOrEqualThan3);

    List<Integer> isNot3 = numbers.stream()
                                  .dropWhile(number -> number != 3)
                                  .collect(Collectors.toList());
    assertEquals(List.of(3, 4, 5, 6), isNot3);
    // the flow starts after the first time that the condition is not met
    // when the number 3 is accepted, the stream starts
  }
}
