package de.bht.pr2.lession06.example01;

import de.bht.pr2.lession06.Cat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Example01 {

  // Das erste Beispiel - Serialisierung und Deserialisierung

  public static void main(String[] args) {
    final String path = "lession06/src/main/resources/Katze.ser";

    Cat grumpyCat = new Cat(">:[");
    serialize(grumpyCat, path);
    final Cat deserializedCat = deserialize(path);

    System.out.println(grumpyCat);
    System.out.println(deserializedCat);
  }

  public static Cat deserialize(String path) {
    try {
      // Eingabe-Datei einrichten - EEE
      FileInputStream fis = new FileInputStream(path);
      ObjectInputStream ois = new ObjectInputStream(fis);

      // Katze-Objekt ausgeben - FFF
      Cat grumpyCat = (Cat) ois.readObject();

      // Aufraeumen - GGG
      ois.close();
      fis.close();

      return grumpyCat;
    } catch (IOException | ClassNotFoundException e) { // HHH
      e.printStackTrace();
    }
    return null;
  }

  public static void serialize(Cat cat, String path) {
    try {
      // Katze-Objekt erzeugen

      // Ausgabe-Datei einrichten - AAA
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      // Katze-Objekt ausgeben - BBB
      oos.writeObject(cat);

      // Aufraeumen - CCC
      oos.close();
      fos.close();
    } catch (IOException e) { // DDD
      e.printStackTrace();
    }
  }
}
