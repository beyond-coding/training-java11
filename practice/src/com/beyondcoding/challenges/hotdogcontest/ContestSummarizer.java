package com.beyondcoding.challenges.hotdogcontest;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ContestSummarizer {

  private List<Contestant> contestants = Contestants.asList();

  public String getWinner() {
    return contestants.stream()
                      .sorted(comparing(Contestant::getConsumed).reversed())
                      .limit(1)
                      .map(e -> e.getName() + " with " + e.getConsumed())
                      .findFirst()
                      .orElse("There was no winner");
  }

  public List<String> getTop3() {
    return contestants.stream()
                      .sorted(comparing(Contestant::getConsumed).reversed())
                      .limit(3)
                      .map(e -> e.getName() + " with " + e.getConsumed())
                      .collect(toList());
  }

  public long getNumberOfContestants() {
    return contestants.size();
  }

  public long getNumberOfMen() {
    return contestants.stream()
                      .filter(e -> e.getGender().equalsIgnoreCase("male"))
                      .count();
  }

  public long getNumberOfWomen() {
    return contestants.stream()
                      .filter(e -> e.getGender().equalsIgnoreCase("female"))
                      .count();
  }

  public long getNumberOfTotalHotDogsEaten() {
    return contestants.stream()
                      .map(Contestant::getConsumed)
                      .reduce(0, Integer::sum);
  }

  public String getNamesOfMenWhoAte60OrMore() {
    return contestants.stream()
                      .filter(e -> e.getGender().equalsIgnoreCase("male"))
                      .filter(e -> e.getConsumed() >= 60)
                      .sorted(comparing(Contestant::getName))
                      .map(Contestant::getName)
                      .collect(joining(", "));
  }

  public String getNamesOfWomenWhoAte60OrMore() {
    return contestants.stream()
                      .filter(e -> e.getGender().equalsIgnoreCase("female"))
                      .filter(e -> e.getConsumed() >= 60)
                      .sorted(comparing(Contestant::getName))
                      .map(Contestant::getName)
                      .collect(joining(", "));
  }

}
