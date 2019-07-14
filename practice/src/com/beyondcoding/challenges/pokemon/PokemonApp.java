package com.beyondcoding.challenges.pokemon;

public class PokemonApp {

  public static void main(String[] args) {
    PokemonSummarizer summarizer = new PokemonSummarizer();

    System.out.println("Total number of pokemons: " + summarizer.getNumberOfPokemons());
    System.out.println("Fastest pokemon: " + summarizer.getNonLegendaryPokemonNameWithHighestSpeed());
    System.out.println("Pokemon with highest attack: " + summarizer.getNonLegendaryPokemonNameWithHighestAttack());
    System.out.println("Pokemon with highest spell attack: " + summarizer.getNonLegendaryPokemonNameWithHighestSpellAttack());
    System.out.println("\nType 1 names sorted alphabetically: \n" + summarizer.getNamesOfType1SortedAlphabetically());
    System.out.println("\nTop 5 type 2 names and appearances sorted by appearances desc: \n" + summarizer.getTop5NamesAndAppearancesOfType2SortedByAppearancesDesc());
    System.out.println("\nType 1 and name of pokemon with highest hp: \n" + summarizer.getType1AndNameOfHighestHpOfCertainType1s());
    System.out.println("\nType 2 and name of pokemon with lowest attack: \n" + summarizer.getWeakestPokemonNamesOfCertainType2s());
  }
}
