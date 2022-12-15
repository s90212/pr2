package de.bht.pr2.lession07.serde.impl;

import de.bht.pr2.lession07.Car;
import de.bht.pr2.lession07.Navi;
import de.bht.pr2.lession07.serde.CarSerde;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlSerdeDom4j implements CarSerde {

  @Override
  public void serialize(List<Car> cars, String path) {
    final Document document = buildXml(cars);

    // Mit dom4j-Funktionalitaeten speichern
    try {
      FileOutputStream fos = new FileOutputStream(path);

      OutputFormat format = OutputFormat.createPrettyPrint(); // Schoen formatiert
      //OutputFormat format = OutputFormat.createCompactFormat(); // Keine Baum-Struktur
      format.setEncoding("UTF-8");

      XMLWriter writer = new XMLWriter(fos, format);
      writer.write(document);

      fos.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Car> deserialize(String path) {
    // Mit dom4j-Funktionalitaeten einlesen
    try {
      // XML-Datei einlesen
      SAXReader reader = new SAXReader();
      reader.setEncoding("UTF-8");

      File file = new File(path);
      final Document read = reader.read(file);

      return processXml(read);
    } catch (DocumentException e) {
      throw new RuntimeException(e);
    }
  }

  private Document buildXml(List<Car> cars) {
    // Neues XML-Document erstellen
    Document document = DocumentHelper.createDocument();

    // 1. Ebene: Autos
    Element autosElement = document.addElement("Autos");

    // Auto fuer Auto durchlaufen
    for (Car car : cars) {

      // 2. Ebene: Auto
      Element autoElement = autosElement.addElement("Auto");

      // 3. Ebene: Attribute im Auto
      autoElement.addElement("Besitzer").addText(car.getOwner());
      autoElement.addElement("Marke").addText(car.getModel());
      autoElement.addElement("Farbe").addText(car.getColor());
      autoElement.addElement("Standort").addText(car.getPosition());
      autoElement.addElement("KmStand")
          .addText("" + car.getKmStatus()); // Wert muss ein String sein

      Navi navi = car.getNavi();
      Element naviElement = autoElement.addElement("Navi")
          .addAttribute("Eingebaut", "" + navi.isBuiltIn()); // Wert muss ein String sein

      // 4. Ebene: Attribute im Navi
      naviElement.addElement("Marke").addText(navi.getModel());
      naviElement.addElement("Stimme").addText(navi.getVoice());
    } // fuer jedes Auto

    return document;
  }

  private List<Car> processXml(Document document) {
    // List initialisieren
    List<Car> cars = new ArrayList<>();

    // 1. Ebene: Autos
    Element autosElement = document.getRootElement();

    // 2. Ebene: Auto
    // Auto fuer Auto durchlaufen
    List<Element> autoElemente = autosElement.elements();
    for (Element autoElement : autoElemente) {

      // 3. Ebene: Attribute im Auto
      String besitzer = autoElement.elementText("Besitzer");
      String marke = autoElement.elementText("Marke");
      String farbe = autoElement.elementText("Farbe");
      String standort = autoElement.elementText("Standort");
      int kmStand = Integer.parseInt(autoElement.elementText("KmStand"));

      // 4. Ebene: Attribute im Navi
      Element naviElement = autoElement.element("Navi");
      String naviMarke = naviElement.elementText("Marke");
      String naviStimme = naviElement.elementText("Stimme");
      boolean naviEingebaut = Boolean.parseBoolean(
          naviElement.attributeValue("Eingebaut"));

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
