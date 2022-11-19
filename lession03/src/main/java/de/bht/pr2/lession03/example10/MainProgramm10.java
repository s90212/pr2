package de.bht.pr2.lession03.example10;

import java.util.ArrayList;
import java.util.List;

public class MainProgramm10 {

  // Programming to an Interface

  public static void main(String[] args) {
    // Zu vermeiden: ArrayList ist eine Klasse
    ArrayList<Integer> liste1 = new ArrayList<>();

    // Besser: List ist ein Interface
    List<Integer> liste2 = new ArrayList<>();

    // Fehler: man darf ein Interface nicht als Objekt erzeugen
    // TODO: Kommentar in der nächsten Zeile entfernen
    //List<Integer> liste3 = new List<>();
  }
}
