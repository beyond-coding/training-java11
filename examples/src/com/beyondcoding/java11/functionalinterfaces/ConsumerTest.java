package com.beyondcoding.java11.functionalinterfaces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

  AtomicInteger number = new AtomicInteger();

  Consumer<Integer> consumer = new Consumer<Integer>() {
    @Override
    public void accept(Integer other) {
      number.setPlain(other);
    }
  };

  @ParameterizedTest
  @ValueSource(ints = {-1000, -1, 0, 1, 1000})
  void test(int expected) {
    consumer.accept(expected);

    int actual = number.get();
    assertEquals(expected, actual);
  }

}
