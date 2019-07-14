package com.beyondcoding.java11.intstream;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntStreamTest {

  @Test
  void testAdditionalOperations() {
    int sum = IntStream.of(1, 2, 3, 4)
                       .sum();
    assertEquals(10, sum);

    OptionalDouble average = IntStream.of(1, 2, 3, 4)
                                      .average();
    assertTrue(average.isPresent());
    assertEquals(2.5, average.getAsDouble());

    IntSummaryStatistics statistics = IntStream.of(1, 2, 3, 4)
                                               .summaryStatistics();
    assertEquals(2.5, statistics.getAverage());
    assertEquals(4, statistics.getCount());
    assertEquals(4, statistics.getMax());
    assertEquals(1, statistics.getMin());
    assertEquals(10, statistics.getSum());

    List<Integer> numbers = IntStream.of(1, 2, 3, 4)
                                     .boxed()
                                     .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), numbers);

    List<String> numbersAsString = IntStream.of(1, 2, 3, 4)
                                            .mapToObj(e -> String.valueOf(e))
                                            .collect(Collectors.toList());
    assertEquals(List.of("1", "2", "3", "4"), numbersAsString);
  }

  @Test
  void testBeginnings() {
    List<Integer> numbers = IntStream.of(1, 2, 3, 4)
                                     .boxed()
                                     .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), numbers);

    List<Integer> range = IntStream.range(1, 4)
                                   .boxed()
                                   .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3), range);

    List<Integer> rangeClosed = IntStream.rangeClosed(1, 4)
                                         .boxed()
                                         .collect(Collectors.toList());
    assertEquals(List.of(1, 2, 3, 4), rangeClosed);

    List<Integer> iterate = IntStream.iterate(0, n -> n + 1)
                                     .limit(4)
                                     // if limit is not provided, the IntStream will be infinite
                                     .boxed()
                                     .collect(Collectors.toList());
    assertEquals(List.of(0, 1, 2, 3), iterate);

    List<Integer> generate = IntStream.generate(() -> 1)
                                      .limit(4)
                                      .boxed()
                                      .collect(Collectors.toList());
    assertEquals(List.of(1, 1, 1, 1), generate);
  }

}
