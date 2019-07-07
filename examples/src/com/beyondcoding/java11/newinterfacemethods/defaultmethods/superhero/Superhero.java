package com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.Villain;

public interface Superhero {

  default String saveTheCityFrom(Villain villain) {
    return "Save the city from " + villain.getName();
  }

}
