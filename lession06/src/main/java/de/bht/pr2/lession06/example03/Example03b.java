package de.bht.pr2.lession06.example03;

import de.bht.pr2.lession06.Cat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Example03b {

  // static-Attribute werden nicht serialisiert

  private static List<Cat> cats = new ArrayList<Cat>();

  private static void deserialisieren() {
    for (int i = 0; i < 20; i++) {
      try {
        FileInputStream fis = new FileInputStream(
            "lession06/src/main/resources/Katze" + i + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        cats.add((Cat) ois.readObject());
        ois.close();
        fis.close();
      } catch (IOException | ClassNotFoundException e) { // HHH
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    deserialisieren();
    System.out.println("Anzahl von Katzen: " + cats.get(10).getNumberOfCats());
    System.out.println("Lieblingsessen von der Klasse: " + Cat.FAVORITE_FOOD);
  }
}
