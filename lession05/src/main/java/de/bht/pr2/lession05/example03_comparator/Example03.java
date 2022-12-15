package de.bht.pr2.lession05.example03_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example03 {

  // Comparator

  public static void main(String[] args) {
    //-----------------------------
    // Objekte in einer Liste einfuegen
    List<Schiff> listeVonSchiffen = new ArrayList<>();
    listeVonSchiffen.add(new Schiff("M", 50, 20));
    listeVonSchiffen.add(new Schiff("N", 30, 20));
    listeVonSchiffen.add(new Schiff("N", 40, 20));
    listeVonSchiffen.add(new Schiff("N", 40, 30));

    Collections.shuffle(listeVonSchiffen);
    System.out.println("----- Vorher -----");
    System.out.println(listeVonSchiffen);

    SchiffComparator schiffComparator = new SchiffComparator();

    Collections.sort(listeVonSchiffen, schiffComparator);

    System.out.println("----- Nach Collections.sort -----");
    System.out.println(listeVonSchiffen);
  }
}
