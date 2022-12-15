package de.bht.pr2.lession05.example03_comparator;

import java.util.Comparator;

public class SchiffComparator implements Comparator<Schiff> {

  public int compare(Schiff a, Schiff b) {
    // Ziel:
    // - return -1 wenn this <  b
    // - return  0 wenn this == b
    // - return  1 wenn this >  b

    // 1. Kriterium: name
    // 2. Kriterium: laenge
    // 3. Kriterium: breite

    final int i = a.getName().compareTo(b.getName());
    if (i != 0) {
      return i;
    }

    final int j = Integer.compare(a.getLaenge(), b.getLaenge());
    if (j != 0) {
      return j;
    }

    return Integer.compare(a.getBreite(), b.getBreite());
  }
}

	