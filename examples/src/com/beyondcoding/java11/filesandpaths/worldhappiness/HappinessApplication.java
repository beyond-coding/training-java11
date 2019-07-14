package com.beyondcoding.java11.filesandpaths.worldhappiness;

import com.beyondcoding.java11.filesandpaths.FileReader;

import java.util.Comparator;

public class HappinessApplication {

  public static void main(String[] args) {
    new FileReader().asStream("com/beyondcoding/java11/filesandpaths/worldhappiness/world-happiness-2017.csv")
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(columns -> new HappinessRecord(columns[0], Integer.valueOf(columns[1]), Double.valueOf(columns[2])))
                    .sorted(Comparator.comparing(HappinessRecord::getRank))
                    .limit(5)
                    .map(e -> "Rank: " + e.getRank() + " | Country: " + e.getCountry() + " | Score: " + e.getScore())
                    .forEach(System.out::println);
  }

}
