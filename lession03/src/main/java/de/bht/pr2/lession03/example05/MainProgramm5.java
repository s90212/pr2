package de.bht.pr2.lession03.example05;

import java.util.ArrayList;
import java.util.List;

public class MainProgramm5 {

  // Integer, Double - Liste von Zahlen

  public static void main(String[] args) {
    List<Integer> listeVonIntegers = new ArrayList<Integer>();
    listeVonIntegers.add(1);
    listeVonIntegers.add(2);
    listeVonIntegers.add(3);
    System.out.println(listeVonIntegers);

    List<Double> listeVonDoubles = new ArrayList<Double>();
    listeVonDoubles.add(1.11);
    listeVonDoubles.add(2.22);
    listeVonDoubles.add(3.33);
    System.out.println(listeVonDoubles);
  }
}
