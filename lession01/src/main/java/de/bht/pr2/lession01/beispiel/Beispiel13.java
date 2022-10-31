package de.bht.pr2.lession01.beispiel;

public class Beispiel13 {

  // Stack-Trace

  /**
   * Eine Methode darf mehrere Ausnahmen werfen.
   *
   * @param zaehler
   * @throws ArithmeticException
   * @throws NumberFormatException
   */
  public static void divisionBerechnen(int zaehler) throws ArithmeticException, NumberFormatException {
    int nenner = ((7 * 21) - 56) % 13; // Resultat von komplizierter Berechnung
    if (nenner == 0) {
      ArithmeticException e = new ArithmeticException("Nenner ist null");
      throw e;
    }
    System.out.println("lol");
    int division = zaehler / nenner;
  }

  /**
   * Die Methode, die die Ausnahme bekommt, kann die Ausnahme fangen oder weiter werfen.
   */
  public static void lassUnsFangen() {
    try {
      divisionBerechnen(100);
    } catch (ArithmeticException e) { // Fangen
      System.out.println("Uh oh, falsche Mathe");
      System.out.println(e);
    }
  }

  public static void lassUnsWerfen() {
    try {
      divisionBerechnen(100);
    } catch (ArithmeticException e) { // Fangen und weiter werfen
      throw e;
    }
  }

  public static void main(String[] args) {
    try {
      //lassUnsWerfen();
      /* TODO: Probiere statt 'lassUnsWerfen' auch mit 'lassUnsFangen' */
      lassUnsFangen();
    } catch (ArithmeticException e) {
      e.printStackTrace();

      /* TODO: Versuch es auch mal mit System.out. Was ist der Unterschied? */
      e.printStackTrace(System.out);
    }
  }
}
