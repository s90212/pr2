package de.bht.pr2.lession06.example03;

import de.bht.pr2.lession06.Cat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Example03a {

  // static-Attribute werden nicht serialisiert

  private static List<Cat> cats = new ArrayList<>();

  private static void serialize() {
    for (int i = 0; i < 20; i++) {
      try {
        FileOutputStream fos = new FileOutputStream(
            "lession06/src/main/resources/Katze" + i + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cats.get(i));
        oos.close();
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void zwanzigKatzenErzeugen() {
    for (int i = 0; i < 20; i++) {
      cats.add(new Cat(">:["));
    }
  }

  public static void main(String[] args) {
    zwanzigKatzenErzeugen();
    System.out.println("Anzahl von Katzen: " + cats.get(0).getNumberOfCats());
    serialize();
  }
}
