package com.beyondcoding.java11.newinterfacemethods.defaultmethods.diamondproblem;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.Villain;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.Superhero;

public interface Aquaman extends Superhero {

  @Override
  default String saveTheCityFrom(Villain villain) {
    return "Jump into an ocean and ask a whale for help to fight " + villain.getName();
  }
}
