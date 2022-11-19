package de.bht.pr2.lession03.example03.schiff.freizeit;

import de.bht.pr2.lession03.example03.schiff.Schiff;

public class Kreuzfahrtschiff extends Schiff {

  // Attribute
  protected int schwimmbadLaenge = 0;
  protected int schwimmbadBreite = 0;
  protected int schwimmbadTiefe = 0;
  protected boolean klimaanlageAn = false;

  // Konstruktoren
  public Kreuzfahrtschiff(String name, int laenge, int breite) {
    this(name, laenge, breite,
        20, 7, 2); // Default-Schwimmbad-Groesse
  }

  public Kreuzfahrtschiff(String name, int laenge, int breite,
      int schwimmbadLaenge, int schwimmbadBreite, int schwimmbadTiefe) {
    super(name, laenge, breite); // Konstruktor in der
    // Schiff-Klasse aufrufen
    this.schwimmbadLaenge = schwimmbadLaenge;
    this.schwimmbadBreite = schwimmbadBreite;
    this.schwimmbadTiefe = schwimmbadTiefe;
  }

  // Methoden
  public int getSchwimmbadBreite() {
    return schwimmbadBreite;
  }

  public int getSchwimmbadLaenge() {
    return schwimmbadLaenge;
  }

  public int getSchwimmbadTiefe() {
    return schwimmbadTiefe;
  }

  public void setSchwimmbadBreite(int schwimmbadBreite) {
    this.schwimmbadBreite = schwimmbadBreite;
  }

  public void setSchwimmbadLaenge(int schwimmbadLaenge) {
    this.schwimmbadLaenge = schwimmbadLaenge;
  }

  public void setSchwimmbadTiefe(int schwimmbadTiefe) {
    this.schwimmbadTiefe = schwimmbadTiefe;
  }

  public void klimaanlageEinschlten() {
    klimaanlageAn = true;
  }

  public void klimaanlageAusschalten() {
    klimaanlageAn = false;
  }

  public void schwimmbadBlubbern() {
    System.out.println("Das Schwimmbad blubbert ..ooOOOooOO");
  }

  public void steuern(int winkel, String linksOderRechts) {
    System.out.println("Liebe Fahrgaeste, wir aendern die Richtung gleich!");
    super.steuern(winkel, linksOderRechts);
  }

  public String toString() {
    String returnString = "Kreuzfahrtschiff / "
        + super.toString()
        + " mit Schwimbad ("
        + schwimmbadLaenge + "m x " + schwimmbadBreite + "m x "
        + schwimmbadTiefe + "m)";
    return returnString;
  }
}

	