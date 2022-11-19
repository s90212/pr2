package de.bht.pr2.lession03.example14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainProgramm14 {

  // HashSet - Objekte durchlaufen

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("b");
    set.add("c");
    set.add("d");
    set.add("e");
    set.add("f");

    // Mit for-Schleife
    System.out.println("----- for-Schleife -----");
    for (String s : set) {
      System.out.print(s + " :: ");
    }
    System.out.println();

    // Mit Iterator
    System.out.println("----- Iterator -----");
    Iterator<String> it = set.iterator();
    while (it.hasNext()) {
      String s = it.next();
      System.out.print(s + " :: ");
    }
    System.out.println();

    // Mit ArrayList
    System.out.println("----- ArrayList -----");
    List<String> list = new ArrayList<>(set);
    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      System.out.println(i + " :: " + s);
    }
  }
}
