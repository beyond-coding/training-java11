package com.beyondcoding.java11.newinterfacemethods.defaultmethods;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.BruceWayne;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.ClarkKen;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.PeterParker;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.Superhero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceDefaultMethodsTest {

  Villain joker = new Villain("Joker");

  @Test
  void testSpiderman() {
    PeterParker peterParker = new PeterParker();
    String actual = peterParker.saveTheCityFrom(joker);

    String expected = "Save the city from Joker";
    assertEquals(expected, actual);

    Superhero spiderman = peterParker;
    actual = spiderman.saveTheCityFrom(joker);

    assertEquals(expected, actual);
  }

  @Test
  void testSuperman() {
    ClarkKen clarkKen = new ClarkKen();
    String actual = clarkKen.saveTheCityFrom(joker);

    String expected = "Destroy the city before Joker does";
    assertEquals(expected, actual);

    Superhero superman = clarkKen;
    actual = superman.saveTheCityFrom(joker);

    assertEquals(expected, actual);
  }

  @Test
  void testBatman() {
    BruceWayne bruceWayne = new BruceWayne();
    String actual = bruceWayne.saveTheCityFrom(joker);

    String expected = "Create a master plan that stops Joker and that kind of saves the city";
    assertEquals(expected, actual);

    Superhero batman = bruceWayne;
    actual = batman.saveTheCityFrom(joker);

    assertEquals(expected, actual);
  }
}
