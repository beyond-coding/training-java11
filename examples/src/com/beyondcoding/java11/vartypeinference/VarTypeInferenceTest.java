package com.beyondcoding.java11.vartypeinference;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Available only for local variables with the initializer
 * It cannot be used for member variables, method parameters, return types, etc
 */
class VarTypeInferenceTest {

  //var number = 6; // error: 'var' is not allowed as non-local variable 

  @Test
  void testVar() {
    var actual = "Java 11";
    String expected = "Java 11";

    assertEquals(expected, actual);
    assertTrue(actual instanceof String);
  }

  @Test
  void testVarChangeType() {
    var text = "Java 11";

    text = text + 9;
    assertEquals("Java 119", text);

    text = text + true;
    assertEquals("Java 119true", text);

    //text = 7; // causes a compilation error
    var num = 9;
    //num. -- no Integer method appears because the primitive type int is chosen
    
    var num2 = Integer.valueOf(9);
    num2.toString(); // Integer is inferred
    
    var letter = 'a'; // char is inferred
    //letter.
    
    var letter2 = "a";
    letter2.isBlank(); // String is inferred
  }

  @Test
  void testVarReducesBoilerplateCode() {
    Map<Integer, String> map1 = new HashMap<>();

    var map2 = new HashMap<Integer, String>();
    map2.put(1, "1");
    //map2.put("1", 1); // error: types do not match
    assertEquals("1", map2.get(1));

    var map3 = new HashMap<>();
    map3.put(1, 1);
    map3.put("1", "7");
    assertEquals(1, map3.get(1));
    assertEquals("7", map3.get("1"));

    Object dynamicTypeWasConsideredObject = map3.get(1);
    assertEquals(1, dynamicTypeWasConsideredObject);

    var names = List.of("John", "Sarah", "Peter", "Lisa");
    assertEquals(4, names.size());
    assertEquals("Sarah", names.get(1));
  }

  void testIllegalUseOfVar() {
    //var word; // error: cannot use 'var' on variable without initializer
    //var number = null; // error: variable initializer is 'null'
    //var array = {1, 2, 3}; // error: array initializer needs an explicit target-type
  }

}