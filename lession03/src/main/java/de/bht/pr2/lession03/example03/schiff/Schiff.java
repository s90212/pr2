package de.bht.pr2.lession03.example03.schiff;

public class Schiff {

  // Attribute
  protected String name = "";
  protected int laenge = 0;
  protected int breite = 0;

  // Konstruktor
  public Schiff(String name, int laenge, int breite) {
    this.name = name;
    this.laenge = laenge;
    this.breite = breite;
  }

  public int getBreite() {
    return breite;
  }

  public int getLaenge() {
    return laenge;
  }

  public String getName() {
    return name;
  }

  public void setBreite(int breite) {
    this.breite = breite;
  }

  public void setLaenge(int laenge) {
    this.laenge = laenge;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void steuern(int winkel, String linksOderRechts) {
    System.out.println("Schiff biegt " + winkel
        + " Grad " + linksOderRechts + " ab.");
  }

  @Override
  public String toString() {
    return "Schiff [" +
        "name='" + name +
        ", laenge=" + laenge +
        ", breite=" + breite +
        ']';
  }
}

	