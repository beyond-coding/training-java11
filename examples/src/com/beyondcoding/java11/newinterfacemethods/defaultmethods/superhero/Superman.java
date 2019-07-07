package com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.Villain;

public interface Superman extends Superhero {

  @Override
  default String saveTheCityFrom(Villain villain) {
    return "Destroy the city before " + villain.getName() + " does";
  }
}
