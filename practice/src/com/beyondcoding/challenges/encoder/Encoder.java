package com.beyondcoding.challenges.encoder;


import com.beyondcoding.challenges.encoder.rule.Number;
import com.beyondcoding.challenges.encoder.rule.*;

import java.util.List;

public interface Encoder {

  List<Rule> rules = List.of(
      new LetterA() {}, new LetterE() {},
      new Vowel() {}, new Consonant() {}, new Number() {},
      new OtherCharacter() {}
  );

  static String encode(String plaintext) {
    if (plaintext.isBlank()) {
      return "";
    }
    plaintext = plaintext.strip();
    var letters = getLetters(plaintext);
    var encoded = "";
    for (String letter : letters) {
      var rule = getRule(letter);
      encoded += rule.encode(letter);
    }
    return encoded;
  }

  static List<String> getLetters(String plaintext) {
    var letters = plaintext.split("");
    return List.of(letters);
  }

  static Rule getRule(String letter) {
    for (var rule : rules) {
      if (rule.isApplicable(letter)) {
        return rule;
      }
    }
    throw new IllegalArgumentException("Could not find rule for letter: " + letter);
  }
}
