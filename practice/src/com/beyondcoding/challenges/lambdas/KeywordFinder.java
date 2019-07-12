package com.beyondcoding.challenges.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class KeywordFinder {

  public List<String> findElegant(String text) {
    return find(text, word -> word.startsWith("ele"));
  }

  public List<String> findPlayful(String text) {
    return find(text, word -> word.endsWith("ful"));
  }

  private List<String> find(String text, Predicate<String> predicate) {
    var words = text.split(" ");
    var found = new ArrayList<String>();
    for (String word : words) {
      if (predicate.test(word)) {
        found.add(word);
      }
    }
    return found;
  }

}
