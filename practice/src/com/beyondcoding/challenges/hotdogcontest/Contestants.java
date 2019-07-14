package com.beyondcoding.challenges.hotdogcontest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Contestants {

  private static final String data = "Rene,male,56;Jacob,male,37;Abby,female,74;Madison,female,68;Joey,male,71;Dakota,female,61;Damian,male,59;Denise,female,43;Tamara,female,39;Nelson,male,49;Nadia,female,60;Mano,male,64;Pamela,female,46;";

  public static List<Contestant> asList() {
    return Stream.of(data)
                 .map(data -> data.split(";"))
                 .flatMap(Stream::of)
                 .map(contestant -> contestant.split(","))
                 .map(toContestant())
                 .collect(toList());
  }

  private static Function<String[], Contestant> toContestant() {
    return contestant -> new Contestant(contestant[0], contestant[1], Integer.valueOf(contestant[2]));
  }

}
