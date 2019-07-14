package com.beyondcoding.challenges.hotdogcontest;

public class ContestApp {

  public static void main(String[] args) {
    ContestSummarizer summarizer = new ContestSummarizer();

    System.out.println("Winner: " + summarizer.getWinner());
    System.out.println("Top 3: " + summarizer.getTop3());
    System.out.println("Number of contestants: " + summarizer.getNumberOfContestants());
    System.out.println("Number of men: " + summarizer.getNumberOfMen());
    System.out.println("Number of women: " + summarizer.getNumberOfWomen());
    System.out.println("Number of hot dogs eaten in total: " + summarizer.getNumberOfTotalHotDogsEaten());
    System.out.println("Men who ate 60 or more hot dogs: " + summarizer.getNamesOfMenWhoAte60OrMore());
    System.out.println("Women who ate 60 or more hot dogs: " + summarizer.getNamesOfWomenWhoAte60OrMore());
  }
}
