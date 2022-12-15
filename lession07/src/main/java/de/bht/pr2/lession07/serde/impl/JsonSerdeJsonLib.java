package de.bht.pr2.lession07.serde.impl;

import de.bht.pr2.lession07.Car;
import de.bht.pr2.lession07.Navi;
import de.bht.pr2.lession07.serde.CarSerde;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonSerdeJsonLib implements CarSerde {


  @Override
  public void serialize(List<Car> cars, String path) {
    // Als "ganz normale" Text-Datei mit java.io speichern
    try {
      FileOutputStream fos = new FileOutputStream(path);
      OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
      BufferedWriter bw = new BufferedWriter(osw);

      final JSONObject jsonObject = buildJson(cars);

      bw.write(jsonObject.toString(2)); // Schoen formatiert
      //bw.write(hauptJSONObject.toString()); // Keine Baum-Struktur
      bw.newLine();

      // Aufraeumen
      bw.close();
      osw.close();
      fos.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Car> deserialize(String path) {
    // Als "ganz normale" Text-Datei mit java.io einlesen
    try {
      // JSON-Datei einlesen
      FileInputStream fis = new FileInputStream(path);
      InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
      BufferedReader br = new BufferedReader(isr);

      StringBuilder gesamterInhalt = new StringBuilder();

      String line = "";
      while ((line = br.readLine()) != null) {
        gesamterInhalt.append(line);
      }

      // Aufraeumen
      br.close();
      isr.close();
      fis.close();

      // JSON-Objekt erzeugen
      JSONObject hauptJSONObject = new JSONObject(gesamterInhalt.toString());
      return processJson(hauptJSONObject);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  private static JSONObject buildJson(List<Car> cars) {
    // Neues Haupt-JSON-Objekt erstellen
    JSONObject hauptJSONObject = new JSONObject();

    // 1. Ebene: Autos
    JSONArray autosJSONArray = new JSONArray();
    hauptJSONObject.put("Autos", autosJSONArray);

    // Auto fuer Auto durchlaufen
    for (Car car : cars) {

      // 2. Ebene: Auto
      JSONObject autoJSONObject = new JSONObject();
      autosJSONArray.put(autoJSONObject);

      // 3. Ebene: Attribute im Auto
      autoJSONObject.put("Besitzer", car.getOwner());
      autoJSONObject.put("Marke", car.getModel());
      autoJSONObject.put("Farbe", car.getColor());
      autoJSONObject.put("Standort", car.getPosition());
      autoJSONObject.put("KmStand", car.getKmStatus()); // Wert ist int, also kein String

      // 4. Ebene: Attribute im Navi
      Navi navi = car.getNavi();

      JSONObject naviJSONObject = new JSONObject();
      naviJSONObject.put("Marke", navi.getModel());
      naviJSONObject.put("Stimme", navi.getVoice());
      naviJSONObject.put("Eingebaut", navi.isBuiltIn()); // Wert ist boolean, also kein String

      // Navi-JSON-Objekt an Auto-JSON-Objekt anhaengen
      autoJSONObject.put("Navi", naviJSONObject);
    } // fuer jedes Auto

    return hauptJSONObject;
  }


  private List<Car> processJson(JSONObject hauptJSONObject) {
    // List initialisieren
    List<Car> cars = new ArrayList<Car>();

    // 1. Ebene: Autos
    JSONArray autosJSONArray = hauptJSONObject.getJSONArray("Autos");

    // 2. Ebene: Auto
    // Auto fuer Auto durchlaufen
    for (int i = 0; i < autosJSONArray.length(); i++) {

      // 3. Ebene: Attribute im Auto
      JSONObject attributeJSONObject = autosJSONArray.getJSONObject(i);

      String besitzer = attributeJSONObject.getString("Besitzer");
      String marke = attributeJSONObject.getString("Marke");
      String farbe = attributeJSONObject.getString("Farbe");
      String standort = attributeJSONObject.getString("Standort");
      int kmStand = attributeJSONObject.getInt("KmStand"); // Wert ist int, also kein String

      // 4. Ebene: Attribute im Navi
      JSONObject naviJSONObject = attributeJSONObject.getJSONObject("Navi");
      String naviMarke = naviJSONObject.getString("Marke");
      String naviStimme = naviJSONObject.getString("Stimme");
      boolean naviEingebaut = naviJSONObject.getBoolean(
          "Eingebaut"); // Wert ist boolean, also kein String

      // Bis dahin sind alle Attribute des Navis empfangen
      // Dann neues Navi-Objekt erzeugen
      Navi navi = new Navi(naviMarke, naviStimme, naviEingebaut);

      // Bis dahin sind alle Attribute des Autos empfangen
      // Dann neues Auto-Objekt erzeugen, in die List einfuegen
      Car auto = new Car(besitzer, marke, farbe, standort, kmStand);
      auto.setNavi(navi);
      cars.add(auto);
    } // fuer jedes Auto

    return cars;
  }

}
