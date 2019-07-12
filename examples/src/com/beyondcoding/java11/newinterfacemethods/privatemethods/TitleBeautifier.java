package com.beyondcoding.java11.newinterfacemethods.privatemethods;

public interface TitleBeautifier {

  default String beautifyWithStar(String text) {
    return beautify(text, "*");
  }

  default String beautifyWithDash(String text) {
    return beautify(text, "-");
  }

  private String beautify(String text, String symbol) {
    text = text.strip();
    text = text.toUpperCase();
    String part = symbol.repeat(2);
    return part + " " + text + " " + part;
  }

}
