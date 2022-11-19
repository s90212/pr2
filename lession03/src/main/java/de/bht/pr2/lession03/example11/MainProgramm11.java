package de.bht.pr2.lession03.example11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainProgramm11 {

  // Iterator

  public static void main(String[] args) {
    List<String> liste = new ArrayList<>();
    liste.add("a");
    liste.add("b");
    liste.add("c");
    liste.add("d");
    liste.add("e");

    Iterator<String> it = liste.iterator();
    while (it.hasNext()) {
      String s = it.next();
      System.out.println(s);
    }

    System.out.println("---------------");

    // IMMER mit hasNext() pruefen bevor Sie mit next() zugreifen
    it = liste.iterator();
    while (it.hasNext()) {
      String s1 = it.next();
      String s2 = it.next(); // Gefaehrlich, Runtime-Error!
      System.out.println(s1 + " :: " + s2);
    }
  }
}
