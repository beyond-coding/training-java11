package com.beyondcoding.challenges.encoder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncoderTest {

  @ParameterizedTest
  @CsvSource({
      "'', ''",
      "' ', ''",
      "'   ', ''",
      "aeiou, 43IOU",
      "bcdfghjklmnpqrstvwxyz, bcdfghjklmnpqrstvwxyz",
      "BCDFGHJKLMNPQRSTVWXYZ, bcdfghjklmnpqrstvwxyz",
      "0123456789, 122333444455555666666777777788888888999999999",
      "'Computer hackers are 4 unauthorized users who break into 3 computer systems in order to steal, change or destroy 0 information. Their 2 clever tactics help them access the 1 information you don’t want them to have.'," +
          "'cOmpUt3r h4ck3rs 4r3 4444 Un4UthOrIz3d Us3rs whO br34k IntO 333 cOmpUt3r syst3ms In Ord3r tO st34l, ch4ng3 Or d3strOy  InfOrm4tIOn. th3Ir 22 cl3v3r t4ctIcs h3lp th3m 4cc3ss th3 1 InfOrm4tIOn yOU dOn’t w4nt th3m tO h4v3.'"
  })
  void testEncode(String plaintext, String expected) {
    String actual = Encoder.encode(plaintext);

    assertEquals(expected, actual);
  }

}