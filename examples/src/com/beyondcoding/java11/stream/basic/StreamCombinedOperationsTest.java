package com.beyondcoding.java11.stream.basic;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamCombinedOperationsTest {

  @Test
  void test1() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> query = numbers.stream()
                                 .skip(1)
                                 .limit(4)
                                 .map(e -> e * 2)
                                 .filter(e -> e < 10)
                                 .collect(Collectors.toList());
    assertEquals(List.of(4, 6, 8), query);
  }

  @Test
  void test2() {
    List<String> names = List.of("Peter", "Sarah", "Robert", "Paul", "Lisa", "Sophia");
    Optional<String> person = names.stream()
                                   .filter(e -> e.length() > 4)
                                   .takeWhile(e -> e.contains("r"))
                                   .skip(1)
                                   .map(String::toUpperCase)
                                   .findFirst();
    assertTrue(person.isPresent());
    assertEquals("SARAH", person.get());
  }

  @Test
  void test3() {
    List<String> words = List.of("hat", "umbrella", "bottle", "bag", "shelf", "wardrobe");
    String selected = words.stream()
                           .sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1)
                           .skip(1)
                           .filter(e -> !e.contains("o"))
                           .limit(2)
                           .collect(Collectors.joining(", "));
    assertEquals("shelf, hat", selected);
  }

}
