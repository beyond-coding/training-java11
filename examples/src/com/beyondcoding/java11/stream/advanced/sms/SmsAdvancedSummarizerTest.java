package com.beyondcoding.java11.stream.advanced.sms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmsAdvancedSummarizerTest {

  SmsAdvancedSummarizer summarizer = new SmsAdvancedSummarizer();

  @Test
  void getMaxLengthsOfHamAndSpamMessages() {
    String maxLengths = summarizer.getMaxLengthsOfHamAndSpamMessages();

    assertEquals("ham: 910, spam: 224", maxLengths);
  }

  @Test
  void getLongestHamMessageNotContainingTheLetterE() {
    String longest = summarizer.getLongestHamMessageNotContainingTheLetterE();

    String expected = "Dont know supports ass and srt i thnk. I think ps3 can play through usb too";
    assertEquals(expected, longest);
  }

  @Test
  void getShortestMessagesNotContainingLettersEandO() {
    List<String> shortest = summarizer.getShortestMessagesNotContainingLettersEandO();

    List<String> expected = List.of("ham: Yup", "spam: 2/2 146tf150p");
    assertEquals(expected, shortest);
  }
}