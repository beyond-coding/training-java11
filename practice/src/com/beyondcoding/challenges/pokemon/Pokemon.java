package com.beyondcoding.challenges.pokemon;

public class Pokemon {

  private String name;
  private String type1;
  private String type2;
  private int total;
  private int hp;
  private int attack;
  private int defense;
  private int spellAttack;
  private int spellDefense;
  private int speed;
  private int generation;
  private boolean legendary;

  public Pokemon(String name, String type1, String type2, int total, int hp, int attack, int defense, int spellAttack, int spellDefense, int speed, int generation, boolean legendary) {
    this.name = name;
    this.type1 = type1;
    this.type2 = type2;
    this.total = total;
    this.hp = hp;
    this.attack = attack;
    this.defense = defense;
    this.spellAttack = spellAttack;
    this.spellDefense = spellDefense;
    this.speed = speed;
    this.generation = generation;
    this.legendary = legendary;
  }

  public String getName() {
    return name;
  }

  public String getType1() {
    return type1;
  }

  public String getType2() {
    return type2;
  }

  public int getTotal() {
    return total;
  }

  public int getHp() {
    return hp;
  }

  public int getAttack() {
    return attack;
  }

  public int getDefense() {
    return defense;
  }

  public int getSpellAttack() {
    return spellAttack;
  }

  public int getSpellDefense() {
    return spellDefense;
  }

  public int getSpeed() {
    return speed;
  }

  public int getGeneration() {
    return generation;
  }

  public boolean isLegendary() {
    return legendary;
  }
}
