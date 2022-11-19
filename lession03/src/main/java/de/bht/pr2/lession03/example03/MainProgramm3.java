package de.bht.pr2.lession03.example03;

import de.bht.pr2.lession03.example03.schiff.Schiff;
import de.bht.pr2.lession03.example03.schiff.freizeit.Kreuzfahrtschiff;
import de.bht.pr2.lession03.example03.schiff.freizeit.Luxuskreuzfahrtschiff;
import java.util.ArrayList;
import java.util.List;

public class MainProgramm3 {

  // Up- und Downcasting - Wann nuetzlich?

  public static void main(String[] args) {
    //-----------------------------
    // Objekte erzeugen
    Schiff schiff = new Schiff("S-Schiff", 5, 3);

    Kreuzfahrtschiff kreuz =
        new Kreuzfahrtschiff("K-Schiff",
            40, 20,
            20, 10, 4);

    Luxuskreuzfahrtschiff luxus =
        new Luxuskreuzfahrtschiff("L-Schiff",
            40, 20,
            20, 10, 4,
            5);

    //-----------------------------
    // Liste von Schiffe erstellen
    List<Schiff> listeVonSchiffen = new ArrayList<Schiff>();
    listeVonSchiffen.add(schiff);
    listeVonSchiffen.add(kreuz); // Upcasting hier
    listeVonSchiffen.add(luxus); // Upcasting hier

    //-----------------------------
    // Schiff fuer Schiff in der Liste bearbeiten
    for (Schiff s : listeVonSchiffen) {
      if (s instanceof Luxuskreuzfahrtschiff) {
        Luxuskreuzfahrtschiff l = (Luxuskreuzfahrtschiff) s; // Downcasting
        l.masseurAbrufen();
      } else if (s instanceof Kreuzfahrtschiff) {
        Kreuzfahrtschiff k = (Kreuzfahrtschiff) s; // Downcasting
        k.schwimmbadBlubbern();
      } else { // Kein Downcasting noetig
        s.steuern(30, "links");
      }
    }
  }
}
