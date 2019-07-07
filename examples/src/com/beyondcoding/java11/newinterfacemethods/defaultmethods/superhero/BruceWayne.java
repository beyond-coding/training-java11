package com.beyondcoding.java11.newinterfacemethods.defaultmethods.superhero;

import com.beyondcoding.java11.newinterfacemethods.defaultmethods.Villain;

public class BruceWayne implements Batman {

  @Override
  public String saveTheCityFrom(Villain villain) {
    return "Create a master plan that stops " + villain.getName() + " and that kind of saves the city";
  }
}
