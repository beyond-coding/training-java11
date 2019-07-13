package com.beyondcoding.java11.stream.basic;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamTerminalOperationsTest {

  @Test
  void testCount() {
    List<Integer> numbers = List.of(1, 2);
    long count = numbers.stream()
                        .count();
    assertEquals(2, count);
  }

  @Test
  void testForEach() {
    List<Integer> numbers = List.of(1, 2);
    List<Integer> other = new ArrayList<>();

    numbers.stream()
           .forEach(number -> other.add(number));

    assertEquals(numbers, other);
  }

  @Test
  void testFindFirst() {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    Optional<Integer> first = numbers.stream()
                                     .findFirst();
    assertTrue(first.isPresent());
    assertEquals(Integer.valueOf(1), first.get());

    numbers = List.of();
    first = numbers.stream()
                   .findFirst();
    assertTrue(first.isEmpty());
  }

  @Test
  void testFindAny() {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    Optional<Integer> any = numbers.stream()
                                   .findAny();
    assertTrue(any.isPresent());
    assertEquals(Integer.valueOf(1), any.get());

    numbers = List.of();
    any = numbers.stream()
                 .findAny();
    assertTrue(any.isEmpty());
  }

  @Test
  void testMatch() {
    List<Integer> numbers = List.of(1, 2, 3, 4);

    boolean match = numbers.stream()
                           .anyMatch(number -> number.equals(2));
    assertTrue(match);

    match = numbers.stream()
                   .noneMatch(number -> number > 5);
    assertTrue(match);

    match = numbers.stream()
                   .allMatch(number -> number < 5);
    assertTrue(match);
  }

  @Test
  void testCollect() {
    // collect to a List
    List<Integer> numbers = Stream.of(1, 2, 3, 4)
                                  .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), numbers);

    // collect to a Set
    numbers = List.of(1, 1, 2, 2);
    Set<Integer> unique = numbers.stream()
                                 .collect(Collectors.toSet());
    assertEquals(Set.of(1, 2), unique);

    // collect to a different collection like a Queue
    Queue<Integer> queue = numbers.stream()
                                  .collect(Collectors.toCollection(LinkedList::new));
    assertEquals(Integer.valueOf(1), queue.poll());
    assertEquals(Integer.valueOf(1), queue.poll());
    assertEquals(Integer.valueOf(2), queue.poll());
    assertEquals(Integer.valueOf(2), queue.poll());

    // collect to one single String
    List<String> letters = List.of("S", "t", "r", "e", "a", "m", "s");
    String word = letters.stream()
                         .collect(Collectors.joining());
    assertEquals("Streams", word);

    String another = letters.stream()
                            .collect(Collectors.joining(" ", "*", "!"));
    assertEquals("*S t r e a m s!", another);
  }

  @Test
  void testReduce() {
    List<String> things = List.of("painting", "laptop", "cellphone");
    Optional<String> shortest = things.stream()
                                      .reduce((e1, e2) -> e1.length() < e2.length() ? e1 : e2);
    assertTrue(shortest.isPresent());
    assertEquals("laptop", shortest.get());
  }

  @Test
  void testMax() {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    Optional<Integer> max = numbers.stream()
                                   .max(Comparator.naturalOrder());
    assertTrue(max.isPresent());
    assertEquals(Integer.valueOf(4), max.get());

    List<String> transportations = List.of("airplane", "car", "bicycle");
    Optional<String> longest = transportations.stream()
                                              .max((e1, e2) -> e1.length() > e2.length() ? 0 : 1);
    assertTrue(longest.isPresent());
    assertEquals("airplane", longest.get());
  }

  @Test
  void testMin() {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    Optional<Integer> min = numbers.stream()
                                   .min(Comparator.naturalOrder());
    assertTrue(min.isPresent());
    assertEquals(Integer.valueOf(1), min.get());

    List<String> transportations = List.of("airplane", "car", "bicycle");
    Optional<String> shortest = transportations.stream()
                                               .min((e1, e2) -> e1.length() > e2.length() ? 0 : 1);
    assertTrue(shortest.isPresent());
    assertEquals("airplane", shortest.get());
  }


}
