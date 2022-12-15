package de.bht.pr2.lession06;

import de.bht.pr2.lession06.example04.Car;
import java.io.Serial;
import java.io.Serializable;

public class Cat implements Serializable {

  //------------------------------
  // Attribute
  @Serial
  private static final long serialVersionUID = 1L;

  private String emoji = "";
  private transient boolean sleeps = true;
  private transient final int transientInt = 10;
  private transient final String transientString = "ein String";
  private transient final Car transientAuto = new Car("Anna", "VW", "gelb", "Berlin", 10000);
  private static int numberOfCats = 0;
  public static final String FAVORITE_FOOD = "fisch";

  //------------------------------
  // Konstruktor
  public Cat(String emoji) {
    this.emoji = emoji;
    numberOfCats++;
  }

  //------------------------------
  // Methoden
  public int getNumberOfCats() {
    return numberOfCats;
  }

  public String getEmoji() {
    return emoji;
  }

  public Car getTransientAuto() {
    return transientAuto;
  }

  public int getTransientInt() {
    return transientInt;
  }

  public String getTransientString() {
    return transientString;
  }

  public boolean getSleeps() {
    return sleeps;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }

  public void setSleeps(boolean sleeps) {
    this.sleeps = sleeps;
  }

  @Override
  public String toString() {
    return "Cat [" +
        "emoji='" + emoji +
        ", sleeps=" + sleeps +
        ", transientInt=" + transientInt +
        ", transientString='" + transientString +
        ", transientAuto=" + transientAuto +
        ']';
  }
}
