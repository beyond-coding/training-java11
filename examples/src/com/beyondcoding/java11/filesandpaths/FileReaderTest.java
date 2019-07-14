package com.beyondcoding.java11.filesandpaths;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

  FileReader reader = new FileReader();

  String path = "com/beyondcoding/java11/filesandpaths/lorem-ipsum.txt";

  @Test
  void testAsLines() {
    List<String> lines = reader.asLines(path);

    assertEquals(4, lines.size());
    assertTrue(lines.get(0).startsWith("Lorem"));
    assertTrue(lines.get(1).startsWith("Ut"));
    assertTrue(lines.get(2).startsWith("Duis"));
    assertTrue(lines.get(3).startsWith("Excepteur"));
  }

  @Test
  void testAsStream() {
    Stream<String> stream = reader.asStream(path);

    assertNotNull(stream);

    String loremIpsumDolor = stream.limit(1)
                                   .map(line -> line.split(" "))
                                   .flatMap(words -> Stream.of(words))
                                   .limit(3)
                                   .collect(Collectors.joining(", "));
    assertEquals("Lorem, ipsum, dolor", loremIpsumDolor);
  }

  @Test
  void testAsString() {
    String text = reader.asString(path);
    
    assertTrue(text.contains("Lorem"));
    assertTrue(text.contains("ipsum"));
    assertTrue(text.contains("dolor"));
  }

}
