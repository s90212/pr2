package de.bht.pr2.lession07;

import java.util.ArrayList;
import java.util.List;

public class CarUtil {
  // Hilfe-Klasse

  public static void drucken(List<Car> autos) {
    for (Car auto : autos) {
      System.out.println(auto);
    }
  }

  public static List<Car> createCars() {
    List<Car> returnList = new ArrayList<>();

    Car annasAuto = new Car("Anna", "Audi", "gelb", "Berlin", 10000);
    Car bobsAuto = new Car("Bob", "BMW", "rot", "Potsdam", 20000);
    Car carlasAuto = new Car("Carla", "Porsche", "silber", "Cottbus", 30000);
    Car danielsAuto = new Car("Daniel", "VW", "blau", "Leipzig", 40000);

    bobsAuto.setNavi(new Navi("TomTom", "weiblich", true));
    carlasAuto.setNavi(new Navi("Garmin", "maennlich", false));
    danielsAuto.setNavi(new Navi("Garmin", "weiblich", false));

    returnList.add(annasAuto);
    returnList.add(bobsAuto);
    returnList.add(carlasAuto);
    returnList.add(danielsAuto);

    return returnList;
  }
}
