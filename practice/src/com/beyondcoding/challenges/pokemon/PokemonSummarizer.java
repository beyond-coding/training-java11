package com.beyondcoding.challenges.pokemon;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PokemonSummarizer {

  private List<Pokemon> pokemons = new PokemonReader().asList();

  public int getNumberOfPokemons() {
    return pokemons.size();
  }

  public String getNonLegendaryPokemonNameWithHighestSpeed() {
    return pokemons.stream()
                   .filter(e -> !e.isLegendary())
                   .sorted(comparing(Pokemon::getSpeed).reversed())
                   .map(Pokemon::getName)
                   .findFirst()
                   .orElse("There are no pokemons");
  }

  public String getNonLegendaryPokemonNameWithHighestAttack() {
    return pokemons.stream()
                   .filter(e -> !e.isLegendary())
                   .sorted(comparing(Pokemon::getAttack).reversed())
                   .map(Pokemon::getName)
                   .findFirst()
                   .orElse("There are no pokemons");
  }

  public String getNonLegendaryPokemonNameWithHighestSpellAttack() {
    return pokemons.stream()
                   .filter(e -> !e.isLegendary())
                   .sorted(comparing(Pokemon::getSpellAttack).reversed())
                   .map(Pokemon::getName)
                   .findFirst()
                   .orElse("There are no pokemons");
  }

  public List<String> getNamesOfType1SortedAlphabetically() {
    return pokemons.stream()
                   .collect(groupingBy(Pokemon::getType1, counting()))
                   .entrySet().stream()
                   .map(Map.Entry::getKey)
                   .sorted()
                   .collect(toList());

  }

  public List<String> getTop5NamesAndAppearancesOfType2SortedByAppearancesDesc() {
    return pokemons.stream()
                   .filter(e -> !e.getType2().isBlank())
                   .collect(groupingBy(Pokemon::getType2, counting()))
                   .entrySet().stream()
                   .sorted(comparing(Map.Entry<String, Long>::getValue).reversed())
                   .limit(5)
                   .map(e -> e.getKey() + " with " + e.getValue())
                   .collect(toList());
  }

  public List<String> getType1AndNameOfHighestHpOfCertainType1s() {
    return pokemons.stream()
                   .filter(e -> e.getType1().equals("Fire") || e.getType1().equals("Water") || e.getType1().equals("Dragon"))
                   .collect(groupingBy(Pokemon::getType1, maxBy(comparing(Pokemon::getHp))))
                   .entrySet().stream()
                   .filter(e -> e.getValue().isPresent())
                   .map(e -> e.getKey() + ": " + e.getValue().get().getName())
                   .collect(toList());
  }

  public String getWeakestPokemonNamesOfCertainType2s() {
    return pokemons.stream()
                   .filter(e -> e.getType2().equals("Flying") || e.getType2().equals("Poison") || e.getType2().equals("Psychic"))
                   .collect(groupingBy(Pokemon::getType2, minBy(comparing(Pokemon::getAttack))))
                   .entrySet().stream()
                   .filter(e -> e.getValue().isPresent())
                   .map(e -> e.getKey() + ": " + e.getValue().get().getName())
                   .collect(joining(", "));
  }
}
