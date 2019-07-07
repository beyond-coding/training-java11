package com.beyondcoding.java11.newinterfacemethods.staticmethods;

public interface BeyondCodingUtils {

  static String brand(String text) {
    return text + " and Beyond Coding is awesome";
  }

  static String spam(String text) {
    String fiveTimesSpam = " Beyond Coding".repeat(3);
    return text + fiveTimesSpam;
  }
}
