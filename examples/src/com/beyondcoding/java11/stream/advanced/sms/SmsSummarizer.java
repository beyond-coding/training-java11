package com.beyondcoding.java11.stream.advanced.sms;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmsSummarizer {

  private SmsReader reader = new SmsReader();
  private List<Sms> sms = reader.getSms();

  public String getHamSpamRatio() {
    return sms.stream()
              .collect(Collectors.groupingBy(e -> e.getLabel(), Collectors.counting()))
              .entrySet().stream()
              .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
              .map(e -> e.getKey() + " " + (e.getValue() * 100) / sms.size() + "%")
              .collect(Collectors.joining(" "));
  }

  public Optional<String> getMostUsedHamWord() {
    return getAllSmsWords("ham").stream()
                                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                                .entrySet().stream()
                                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                .map(e -> e.getKey())
                                .findFirst();
  }

  private List<String> getAllSmsWords(String label) {
    return sms.stream()
              .filter(e -> e.getLabel().equals(label))
              .map(e -> e.getText())
              .map(e -> e.split(" "))
              .flatMap(e -> Stream.of(e))
              .collect(Collectors.toList());
  }

  public Optional<String> getMostUsedHamLetter() {
    return getAllSmsWords("ham").stream()
                                .map(e -> e.split(""))
                                .flatMap(e -> Stream.of(e))
                                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                                .entrySet().stream()
                                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                .map(e -> e.getKey())
                                .findFirst();
  }

  public int getLengthOfLongestSpamMessage() {
    return sms.stream()
              .filter(e -> e.getLabel().equals("spam"))
              .map(e -> e.getText())
              .map(e -> e.length())
              .reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2);
  }

}
