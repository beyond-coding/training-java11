package com.beyondcoding.java11.newinterfacemethods.defaultmethods;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.diamondproblem.FailureMadLabExperiment;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.diamondproblem.SuccessfulMadLabExperiment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceDiamondProblemTest {

  Villain joker = new Villain("Joker");

  @Test
  void testNoDiamondProblem() {
    SuccessfulMadLabExperiment experiment = new SuccessfulMadLabExperiment();
    String actual = experiment.saveTheCityFrom(joker);

    String expected = "Destroy the city before Joker does";
    assertEquals(expected, actual);
  }

  @Test
  void testDiamondProblemIsResolvedInCompilationTime() {
    FailureMadLabExperiment experiment = new FailureMadLabExperiment();
    String actual = experiment.saveTheCityFrom(joker);

    String expected = "Jump into an ocean and ask a whale for help to fight Joker";
    assertEquals(expected, actual);
  }

}
