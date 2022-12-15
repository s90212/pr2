package de.bht.pr2.lession05.example02_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example02 {

  // Comparable

  public static void main(String[] args) {
    // Objekte in einer Liste einfuegen
    List<ComparableSchiff> listeVonSchiffen = new ArrayList<>();
    listeVonSchiffen.add(new ComparableSchiff("M", 50, 20));
    listeVonSchiffen.add(new ComparableSchiff("N", 30, 20));
    listeVonSchiffen.add(new ComparableSchiff("N", 40, 20));
    listeVonSchiffen.add(new ComparableSchiff("N", 40, 30));

    Collections.shuffle(listeVonSchiffen);
    System.out.println("----- Vorher -----");
    System.out.println(listeVonSchiffen);

    Collections.sort(listeVonSchiffen);
    System.out.println("----- Nachher -----");
    System.out.println(listeVonSchiffen);
  }
}
