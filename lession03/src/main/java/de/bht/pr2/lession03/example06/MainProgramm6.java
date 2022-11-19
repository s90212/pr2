package de.bht.pr2.lession03.example06;

import java.util.ArrayList;
import java.util.List;

public class MainProgramm6 {

  // Referenztyp angeben

  public static void main(String[] args) {
    // TODO: Kommentar in der nächsten Zeile entfernen
    // List<> liste1 = new ArrayList<>(); // Nein, nein, nein!!

    List<Integer> liste2 = new ArrayList<Integer>(); // OK

    List<Integer> liste3 = new ArrayList<>(); // OK ... sogar besser
  }

}
