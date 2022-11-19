package de.bht.pr2.lession03.example09;

import java.util.ArrayList;
import java.util.List;

public class MainProgramm9 {

  // Autoboxing und Unboxing - ArrayList

  public static void main(String[] args) {
    List<Integer> listeVonIntegers = new ArrayList<>();

    listeVonIntegers.add(1); // Autoboxing
    listeVonIntegers.add(2); // Autoboxing
    listeVonIntegers.add(3); // Autoboxing

    int a = listeVonIntegers.get(0); // Unboxing
    int b = listeVonIntegers.get(1); // Unboxing
    int c = listeVonIntegers.get(2); // Unboxing
  }
}
