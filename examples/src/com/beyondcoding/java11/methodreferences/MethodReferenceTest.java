package com.beyondcoding.java11.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodReferenceTest {

  @Test
  void testMethodReferences() {
    UnaryOperator<String> toLowerCase = text -> text.toLowerCase();
    assertEquals("hello", toLowerCase.apply("HELLO"));

    toLowerCase = String::toLowerCase;
    assertEquals("hello", toLowerCase.apply("HELLO"));

    SecretFormula formula = new SecretFormula();

    Function<Integer, Double> applySecretFormula = number -> formula.calculate(number);
    assertEquals(Double.valueOf(2.0), applySecretFormula.apply(4));
    applySecretFormula = formula::calculate;
    assertEquals(Double.valueOf(2.0), applySecretFormula.apply(4));

    //applySecretFormula = SecretFormula::calculate; // error: the method is not static
  }
}
