package de.bht.pr2.lession03.example01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainProgramm1 {

  // ArrayList erzeugen

  public static void main(String[] args) {
    //----------------------------
    // Eingabe: nichts
    List<Integer> liste1 = new ArrayList<Integer>();

    //----------------------------
    // Eingabe: eine Collection
    liste1.add(10);
    liste1.add(20);
    liste1.add(30);
    List<Integer> liste2 = new ArrayList<Integer>(liste1);

    //----------------------------
    // Mit einem Array
    Integer[] array = {1, 2, 3, 4, 5};
    List<Integer> liste3 = Arrays.asList(array);
    // Achtung:
    // liste3 hat eine feste Groesse!
    liste3.add(6); // Fehler - Runtime-Error!
  }
}
