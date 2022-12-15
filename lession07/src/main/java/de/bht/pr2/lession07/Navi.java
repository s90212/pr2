package de.bht.pr2.lession07;

import java.util.Objects;

public class Navi {

  private String model = "unbekannt";
  private String voice = "weiblich"; // maennlich oder weiblich

  private boolean builtIn;

  //------------------------------
  // Konstruktor
  public Navi() {

  }

  public Navi(String model, String voice, boolean builtIn) {
    this.model = model;
    this.voice = voice;
    this.builtIn = builtIn;
  }

  //------------------------------
  // Methode
  public void route(String address) {
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

  public String getModel() {
    return model;
  }

  public String getVoice() {
    return voice;
  }

  public boolean isBuiltIn() {
    return builtIn;
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
        ", builtIn='" + builtIn +
        ']';
  }
}
