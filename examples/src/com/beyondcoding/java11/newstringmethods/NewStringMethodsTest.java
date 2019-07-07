package com.beyondcoding.java11.newstringmethods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * New Java 11 String methods:
 * - repeat, isBlank, lines, strip, stripLeading, stripTrailing
 */
class NewStringMethodsTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 5, 10, 100})
  void testRepeat(int numberOfRepetitions) {
    String text = "Java 11";

    String actual = text.repeat(numberOfRepetitions);

    String expected = "";
    for (int i = 0; i < numberOfRepetitions; i++) {
      expected += text;
    }

    assertEquals(expected, actual);
  }

  @Test
  void testRepeatThrowsException() {
    String text = "Java 11";

    int numberOfRepetitions = -1;

    assertThrows(IllegalArgumentException.class, () -> text.repeat(numberOfRepetitions));
  }

  @ParameterizedTest
  @CsvSource({
      "true,''",
      "true,' '",
      "true,'     '",
      "true,'\t'",
      "true,'\n'",
      "false,'a'",
      "false,' a'",
      "false,'a '",
      "false,' a '"
  })
  void testIsBlank(boolean expected, String text) {
    boolean actual = text.isBlank();

    assertEquals(expected, actual);
  }

  @Test
  void testIsBlankThrowsException() {
    String text = null;

    assertThrows(NullPointerException.class, () -> text.isBlank());
  }

  @ParameterizedTest
  @CsvSource({
      "0, ''",
      "1, ' '",
      "1, 'a'",
      "1, '\n'",
      "1, '\r'",
      "1, 'a\n'",
      "1, 'a\r'",
      "2, '\na'",
      "2, '\ra'",
      "2, 'a\na'",
      "2, 'a\ra'",
      "2, '\n\n'",
      "2, '\r\r'",
      "3, 'a\na\na'",
      "3, 'a\ra\ra'",
  })
  void testLines(int expectedNumberOfLines, String text) {
    long actualNumberOfLines = text.lines().count();

    assertEquals(expectedNumberOfLines, actualNumberOfLines);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "Java 11", " Java 11", "Java 11 ", " Java 11 ",
      "\tJava 11", "Java 11\t", "\tJava 11\t",
      " \tJava 11", "Java 11\t ", " \t Java 11 \t "
  })
  void testStrip(String text) {
    String actual = text.strip();

    String expected = "Java 11";
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "Java 11 ", " Java 11 ", "\tJava 11 ", " \tJava 11 ", " \t Java 11 "
  })
  void testStripLeading(String text) {
    String actual = text.stripLeading();

    String expected = "Java 11 ";
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      " Java 11", " Java 11 ", " Java 11\t", " Java 11\t ", " Java 11 \t "
  })
  void testStripTrailing(String text) {
    String actual = text.stripTrailing();

    String expected = " Java 11";
    assertEquals(expected, actual);
  }
}