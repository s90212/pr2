package de.bht.pr2.lession03.example03.schiff.freizeit;

public class Luxuskreuzfahrtschiff extends Kreuzfahrtschiff {

  // Attribut
  protected int anzahlVonMasseuren = 0;

  // Konstruktor
  public Luxuskreuzfahrtschiff(String name, int laenge, int breite,
      int schwimmbadLaenge, int schwimmbadBreite, int schwimmbadTiefe,
      int anzahlVonMasseuren) {
    super(name, laenge, breite,
        schwimmbadLaenge, schwimmbadBreite, schwimmbadBreite);
    this.anzahlVonMasseuren = anzahlVonMasseuren;
  }

  // Methoden
  public int getAnzahlVonMasseuren() {
    return anzahlVonMasseuren;
  }

  public void masseurAbrufen() {
    System.out.println("Ein Masseur kommt sofort zu Ihnen");
  }

  public void setAnzahlVonMasseuren(int anzahlVonMasseuren) {
    this.anzahlVonMasseuren = anzahlVonMasseuren;
  }

  public void schwimmbadBlubbern(int sekunden) {
    System.out.println("Das Schwimmbad blubbert ..ooOOOooOO fuer "
        + sekunden + " Sekunden");
  }

  public String toString() {
    String returnString = "Luxuskreuzfahrtschiff / "
        + super.toString()
        + " & mit " + anzahlVonMasseuren + " Masseure";
    return returnString;
  }
}
	