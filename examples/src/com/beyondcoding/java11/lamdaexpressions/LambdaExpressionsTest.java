package com.beyondcoding.java11.lamdaexpressions;

import com.beyondcoding.java11.lamdaexpressions.util.LetterCounter;
import com.beyondcoding.java11.lamdaexpressions.util.Person;
import com.beyondcoding.java11.lamdaexpressions.util.ThorHammerDeterminer;
import com.beyondcoding.java11.lamdaexpressions.util.WorthyPotion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class LambdaExpressionsTest {

  @Test
  void testPredicate() {
    Predicate<String> isLongEnough = text -> text.length() > 3;
    assertFalse(isLongEnough.test("123"));
    assertTrue(isLongEnough.test("1234"));

    isLongEnough = text -> text.length() > 5;
    assertFalse(isLongEnough.test("1234"));
    assertFalse(isLongEnough.test("12345"));
    assertTrue(isLongEnough.test("123456"));
  }

  @ParameterizedTest
  @CsvSource({
      "Number -1, -1",
      "Number 0, 0",
      "Number 1, 1",
  })
  void testFunction(String expected, int value) {
    Function<Integer, String> toFlavouredText = number -> "Number " + number;

    String actual = toFlavouredText.apply(value);

    assertEquals(expected, actual);
  }

  @Test
  void testThorHammerDeterminer() {
    Person peter = new Person("Peter");
    Person sarah = new Person("Sarah");

    ThorHammerDeterminer determiner = person -> person.getName().contains("a");
    assertFalse(determiner.isWorthy(peter));
    assertTrue(determiner.isWorthy(sarah));

    WorthyPotion potion = person -> new Person(person.getName() + "a");

    Person worthyPeter = potion.makeWorthy(peter);
    Person worthySarah = potion.makeWorthy(sarah);

    assertEquals("Petera", worthyPeter.getName());
    assertEquals("Saraha", worthySarah.getName());
    assertTrue(determiner.isWorthy(worthyPeter));
    assertTrue(determiner.isWorthy(worthySarah));
  }

  @ParameterizedTest
  @CsvSource({
      "0, batman, p",
      "1, batman, b",
      "2, batman, a"
  })
  void testLetterCounter(int expected, String givenText, char givenLetter) {
    LetterCounter counter = (word, letter) -> {
      int count = 0;
      char[] characters = word.toCharArray();
      for (char character : characters) {
        if (character == letter) {
          count++;
        }
      }
      return count;
    };

    int actual = counter.count(givenText, givenLetter);

    assertEquals(expected, actual);
  }

  @Test
  void testLambdaExpressionsWithExistingAPIs() {
    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
    assertEquals(List.of(1, 2, 3, 4), numbers);

    numbers.removeIf(number -> number % 2 == 0);
    assertEquals(List.of(1, 3), numbers);

    numbers.replaceAll(number -> number * 2);
    assertEquals(List.of(2, 6), numbers);

    numbers.forEach(number -> "Do nothing with ".concat(number.toString()));
    assertEquals(List.of(2, 6), numbers);
  }
}