package com.beyondcoding.challenges.pokemon;

public class PokemonApp {

  public static void main(String[] args) {
    PokemonSummarizer summarizer = new PokemonSummarizer();

    System.out.println("Total number of pokemons: " + summarizer.getNumberOfPokemons());
    System.out.println("Fastest non-legendary pokemon: " + summarizer.getNonLegendaryPokemonNameWithHighestSpeed());
    System.out.println("Non-legendary pokemon with highest attack: " + summarizer.getNonLegendaryPokemonNameWithHighestAttack());
    System.out.println("Non-legendary pokemon with highest spell attack: " + summarizer.getNonLegendaryPokemonNameWithHighestAttack());
    System.out.println("Type 1 names sorted alphabetically: " + summarizer.getNamesOfType1SortedAlphabetically());
    System.out.println("Top 5 type 2 names and appearances sorted by appearances desc: " + summarizer.getTop5NamesAndAppearancesOfType2SortedByAppearancesDesc());
    System.out.println("Type 1 and name of pokemon with highest hp: " + summarizer.getType1AndNameOfHighestHpOfCertainType1s());
    System.out.println("Type 2 and name of pokemon with lowest attack: " + summarizer.getWeakestPokemonNamesOfCertainType2s());
  }
}
