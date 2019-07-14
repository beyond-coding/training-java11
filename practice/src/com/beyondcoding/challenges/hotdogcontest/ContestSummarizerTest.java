package com.beyondcoding.challenges.hotdogcontest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContestSummarizerTest {

  private ContestSummarizer summarizer = new ContestSummarizer();

  @Test
  void getWinner() {
    String winner = summarizer.getWinner();

    assertEquals("Abby with 74", winner);
  }

  @Test
  void getTop3() {
    List<String> top3 = summarizer.getTop3();

    List<String> expected = List.of("Abby with 74", "Joey with 71", "Madison with 68");
    assertEquals(expected, top3);
  }

  @Test
  void getNumberOfContestants() {
    long numberOfContestants = summarizer.getNumberOfContestants();

    assertEquals(13, numberOfContestants);
  }

  @Test
  void getNumberOfMen() {
    long numberOfMen = summarizer.getNumberOfMen();

    assertEquals(6, numberOfMen);
  }

  @Test
  void getNumberOfWomen() {
    long numberOfWomen = summarizer.getNumberOfWomen();

    assertEquals(7, numberOfWomen);
  }

  @Test
  void getNumberOfTotalHotDogsEaten() {
    long numberOfTotalHotDogsEaten = summarizer.getNumberOfTotalHotDogsEaten();

    assertEquals(727, numberOfTotalHotDogsEaten);
  }

  @Test
  void getNamesOfMenWhoAte60OrMore() {
    String men = summarizer.getNamesOfMenWhoAte60OrMore();

    assertEquals("Joey, Mano", men);
  }

  @Test
  void getNamesOfWomenWhoAte60OrMore() {
    String women = summarizer.getNamesOfWomenWhoAte60OrMore();

    assertEquals("Abby, Dakota, Madison, Nadia", women);
  }
}