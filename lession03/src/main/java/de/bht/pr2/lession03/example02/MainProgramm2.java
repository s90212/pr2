package de.bht.pr2.lession03.example02;

import java.util.ArrayList;
import java.util.List;

public class MainProgramm2 {

  // ArrayList - Methoden

  public static void main(String[] args) {
    System.out.println("------ Am Anfang ------");
    List<String> liste = new ArrayList<String>();
    System.out.println(liste);

    System.out.println("------ add(\"a\") ------");
    liste.add("a");
    System.out.println(liste);

    System.out.println("------ addAll(liste2) ------");
    List<String> liste2 = new ArrayList<String>();
    liste2.add("b");
    liste2.add("c");
    liste2.add("d");
    liste2.add("e");
    liste.addAll(liste2);

    System.out.println("liste2: " + liste2);
    System.out.println("liste:  " + liste);

    System.out.println("------ subList() ------");
    List<String> subListe = liste.subList(2, 4);
    System.out.println("Sub-Liste: " + subListe);
    System.out.println("Originelle Liste: " + liste);

    System.out.println("------ get(2) ------");
    String s2 = liste.get(2);
    System.out.println("s2: " + s2);

    System.out.println("------ set(2, \"x\") ------");
    liste.set(2, "x");
    System.out.println(liste);

    System.out.println("------ remove(3) ------");
    liste.remove(3);
    System.out.println(liste);

    System.out.println("------ size() ------");
    int groesse = liste.size();
    System.out.println(groesse + " :: " + liste);

    System.out.println("------ isEmpty() ------");
    boolean leer = liste.isEmpty();
    System.out.println(leer + " :: " + liste);

    System.out.println("------ clear() ------");
    liste.clear();
    System.out.println(liste);

    System.out.println("------ isEmpty() ------");
    leer = liste.isEmpty();
    System.out.println(leer + " :: " + liste);
  }
}
