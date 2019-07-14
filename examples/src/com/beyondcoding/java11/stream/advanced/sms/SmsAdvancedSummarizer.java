package com.beyondcoding.java11.stream.advanced.sms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmsAdvancedSummarizer {

  private List<Sms> sms = new SmsReader().getSms();


  public String getMaxLengthsOfHamAndSpamMessages() {
    return sms.stream()
              .collect(Collectors.groupingBy(Sms::getLabel,
                  Collectors.mapping(Sms::getText,
                      Collectors.mapping(String::length,
                          Collectors.maxBy(Comparator.naturalOrder())))))
              .entrySet().stream()
              .filter(e -> e.getValue().isPresent())
              .sorted((e1, e2) -> e2.getValue().get().compareTo(e1.getValue().get()))
              .map(e -> e.getKey() + ": " + e.getValue().get())
              .collect(Collectors.joining(", "));
  }

  public String getLongestHamMessageNotContainingTheLetterE() {
    return sms.stream()
              .collect(Collectors.filtering(e -> e.getLabel().equals("ham"),
                  Collectors.mapping(Sms::getText,
                      Collectors.filtering(e -> !e.contains("e") && !e.contains("E"),
                          Collectors.toList()))))
              .stream()
              .sorted(Comparator.comparing(String::length).reversed())
              .findFirst()
              .orElse("There were no sms");
  }

  public List<String> getShortestMessagesNotContainingLettersEandO() {
    return sms.stream()
              .collect(Collectors.groupingBy(Sms::getLabel,
                  Collectors.filtering(e -> !e.getText().contains("e"),
                      Collectors.filtering(e -> !e.getText().contains("E"),
                          Collectors.filtering(e -> !e.getText().contains("o"),
                              Collectors.filtering(e -> !e.getText().contains("O"),
                                  Collectors.mapping(Sms::getText,
                                      Collectors.minBy(Comparator.comparing(String::length)
                                      )))))))).entrySet().stream()
              .filter(e -> e.getValue().isPresent())
              .sorted(Comparator.comparing(e -> e.getValue().get().length()))
              .map(e -> e.getKey() + ": " + e.getValue().get())
              .collect(Collectors.toList());

  }

}
