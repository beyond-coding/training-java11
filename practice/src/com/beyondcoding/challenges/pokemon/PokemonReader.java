package com.beyondcoding.challenges.pokemon;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class PokemonReader {

  private FileReader reader = new FileReader();
  private String path = "com/beyondcoding/challenges/pokemon/pokemon.csv";

  public List<Pokemon> asList() {
    return reader.asStream(path)
                 .skip(1)
                 .map(line -> line.split(";"))
                 .map(toPokemon())
                 .collect(toList());

  }

  private Function<String[], Pokemon> toPokemon() {
    return columns -> new Pokemon(
        columns[1],
        columns[2],
        columns[3],
        Integer.valueOf(columns[4]),
        Integer.valueOf(columns[5]),
        Integer.valueOf(columns[6]),
        Integer.valueOf(columns[7]),
        Integer.valueOf(columns[8]),
        Integer.valueOf(columns[9]),
        Integer.valueOf(columns[10]),
        Integer.valueOf(columns[11]),
        Boolean.valueOf(columns[12])
    );
  }

}
