package de.bht.pr2.lession03.example04;

import de.bht.pr2.lession03.example04.auto.Auto;
import de.bht.pr2.lession03.example04.auto.AutoMarke;
import java.util.ArrayList;
import java.util.List;

public class MainProgramm4 {

  // ArrayList durchlaufen

  public static void main(String[] args) {
    // ArrayList erzeugen
    List<Auto> listeVonAutos = new ArrayList<Auto>();

    // Objekte einfuegen
    Auto annasAuto = new Auto("rot", 4, true, AutoMarke.AUDI);
    Auto bobsAuto = new Auto("blau", 2, true, AutoMarke.BMW);
    Auto cassiesAuto = new Auto("gelb", 4, false, AutoMarke.VOLKSWAGEN);

    listeVonAutos.add(annasAuto);
    listeVonAutos.add(bobsAuto);
    listeVonAutos.add(cassiesAuto);

    // Groesse der ArrayList nachfragen
    int groesse = listeVonAutos.size(); // 3
    System.out.println("Liste hat " + groesse + " Autos");

    // Objekte zugreifen
    for (int i = 0; i < groesse; i++) {
      System.out.println("klassische for-Schleife, i = "
          + i + ": " + listeVonAutos.get(i));
    }

    for (Auto auto : listeVonAutos) {
      System.out.println("for-each for-Schleife: " + auto);
      auto.bremsen();
    }
  }
}
