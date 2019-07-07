package com.beyondcoding.java11.newinterfacemethods.defaultmethods.diamondproblem;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.Villain;
import com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero.Superman;

public interface SuperAquaman extends Superman, Aquaman {

  @Override
  default String saveTheCityFrom(Villain villain) {
    return Aquaman.super.saveTheCityFrom(villain);
  }
}
