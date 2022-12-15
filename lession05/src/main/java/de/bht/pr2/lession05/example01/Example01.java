package de.bht.pr2.lession05.example01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example01 {

  // Collections.shuffle()
  // Collections.sort()

  public static void main(String[] args) {
    List<Integer> listeVonIntegers = new ArrayList<>();
    listeVonIntegers.add(3);
    listeVonIntegers.add(-1);
    listeVonIntegers.add(2);
    listeVonIntegers.add(-4);
    listeVonIntegers.add(0);

    Collections.shuffle(listeVonIntegers);
    System.out.println("----- Vorher -----");
    System.out.println(listeVonIntegers);

    Collections.sort(listeVonIntegers);
    System.out.println("----- Nachher -----");
    System.out.println(listeVonIntegers);
  }
}
