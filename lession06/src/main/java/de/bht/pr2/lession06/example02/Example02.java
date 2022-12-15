package de.bht.pr2.lession06.example02;

import de.bht.pr2.lession06.Cat;
import de.bht.pr2.lession06.example01.Example01;

public class Example02 {

  // transient-Attribute werden nicht serialisiert

  public static void main(String[] args) {
    final String path = "lession06/src/main/resources/Katze.ser";

    Cat grumpyCat = new Cat(">:[");
    grumpyCat.setSleeps(true);

    Example01.serialize(grumpyCat, path);
    final Cat deserializedCat = Example01.deserialize(path);

    System.out.println(grumpyCat);
    System.out.println(deserializedCat);

    System.out.println(grumpyCat.getSleeps());
    System.out.println(grumpyCat.getTransientInt());
    System.out.println(grumpyCat.getTransientString());
    System.out.println(grumpyCat.getTransientAuto());
  }
}
