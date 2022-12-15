package de.bht.pr2.lession06.example04;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Navi implements Serializable {

  //------------------------------
  // Attribute
  @Serial
  private static final long serialVersionUID = 3111992515588084795L;
  String model = "unbekannt";
  String voice = "weiblich"; // maennlich oder weiblich

  //------------------------------
  // Konstruktor
  public Navi(String model, String voice) {
    this.model = model;
    this.voice = voice;
  }

  //------------------------------
  // Methode
  public void leiten(String address) {
    System.out.println("Die Route nach " + address + " wird gesucht...");
    System.out.println("Die Route ist gefunden.");
    System.out.println("Bitte in 300 Metern links abbiegen.");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Navi navi = (Navi) o;
    return Objects.equals(model, navi.model) && Objects.equals(voice, navi.voice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, voice);
  }

  @Override
  public String toString() {
    return "Navi [" +
        "model='" + model +
        ", voice='" + voice +
        ']';
  }
}
