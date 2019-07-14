package com.beyondcoding.challenges.pokemon;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonSummarizerTest {

  PokemonSummarizer summarizer = new PokemonSummarizer();

  @Test
  void getNumberOfPokemons() {
    int numberOfPokemons = summarizer.getNumberOfPokemons();

    assertEquals(800, numberOfPokemons);
  }

  @Test
  void getNonLegendaryPokemonNameWithHighestSpeed() {
    String fastest = summarizer.getNonLegendaryPokemonNameWithHighestSpeed();

    assertEquals("Ninjask", fastest);
  }

  @Test
  void getNonLegendaryPokemonNameWithHighestAttack() {
    String strongest = summarizer.getNonLegendaryPokemonNameWithHighestAttack();

    assertEquals("HeracrossMega Heracross", strongest);
  }

  @Test
  void getNonLegendaryPokemonNameWithHighestSpellAttack() {
    String withHighestSpellAttack = summarizer.getNonLegendaryPokemonNameWithHighestSpellAttack();

    assertEquals("AlakazamMega Alakazam", withHighestSpellAttack);
  }

  @Test
  void getNamesOfType1SortedAlphabetically() {
    List<String> types1 = summarizer.getNamesOfType1SortedAlphabetically();

    List<String> expected = List.of("Bug", "Dark", "Dragon", "Electric",
        "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground",
        "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water");

    assertEquals(expected, types1);
  }

  @Test
  void getTop5NamesAndAppearancesOfType2SortedByAppearancesDesc() {
    List<String> types2 = summarizer.getTop5NamesAndAppearancesOfType2SortedByAppearancesDesc();

    List<String> expected = List.of("Flying with 97", "Ground with 35", "Poison with 34", "Psychic with 33", "Fighting with 26");
    assertEquals(expected, types2);
  }

  @Test
  void getType1AndNameOfHighestHpOfCertainType1s() {
    List<String> highestHps = summarizer.getType1AndNameOfHighestHpOfCertainType1s();

    List<String> expected = List.of("Water: Wailord", "Fire: Entei", "Dragon: Kyurem");
    assertEquals(expected, highestHps);
  }

  @Test
  void getTop3WeakestPokemonNamesOfCertainType2s() {
    String weakest = summarizer.getWeakestPokemonNamesOfCertainType2s();

    String expected = "Psychic: Bronzor, Flying: Ledyba, Poison: Kakuna";
    assertEquals(expected, weakest);
  }
}