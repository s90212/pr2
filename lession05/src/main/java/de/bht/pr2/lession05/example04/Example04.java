package de.bht.pr2.lession05.example04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example04 {
  // Schluessel in einer Map anordnen

  public static void main(String[] args) {
    //----------------------------------
    // Objekte erzeugen
    Person anna = new Person("Anna Alt");
    Person bob = new Person("Bob Berg");
    Person carla = new Person("Carla Carsten");
    Person daniel = new Person("Daniel Dorf");

    Schiff schiffAnna = new Schiff("Annas Schiff", 10, 20, "Anna Alt");
    Schiff schiffBob = new Schiff("Bobs Schiff", 10, 30, "Bob Berg");
    Schiff schiffCarla = new Schiff("Carlas Schiff", 10, 20, "Carla Carsten");
    Schiff schiffDaniel = new Schiff("Daniels Schiff", 10, 30, "Daniel Dorf");

    Map<Person, Schiff> personenZuSchiffen = new HashMap<>();
    personenZuSchiffen.put(anna, schiffAnna);
    personenZuSchiffen.put(bob, schiffBob);
    personenZuSchiffen.put(carla, schiffCarla);
    personenZuSchiffen.put(daniel, schiffDaniel);

    System.out.println("------ Map -----");
    System.out.println(personenZuSchiffen);

    //----------------------------------
    // Die Map-Schluessel zu einer List machen
    List<Person> personen = new ArrayList<>(personenZuSchiffen.keySet());

    //----------------------------------
    // Die List anordnen
    Collections.sort(personen);
    System.out.println("------ Personen-Keys sortiert -----");
    System.out.println(personen);

    //----------------------------------
    // Person fuer Person nach Anordnung durchgehen,
    // das entsprechende Schiff-Objekt zugreifen
    System.out.println("------ Sortierte Values -----");
    for (Person person : personen) {
      Schiff schiff = personenZuSchiffen.get(person);
      System.out.println(person + " --> " + schiff);
    }
  }
}
