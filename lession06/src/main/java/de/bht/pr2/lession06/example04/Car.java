package de.bht.pr2.lession06.example04;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {

  //------------------------------
  // Attribute
  @Serial
  private static final long serialVersionUID = -4410311189408169242L;
  private String owner = "";
  private String model = "";
  private String color = "";
  private String position = "";
  private int kmStatus = 0;
  private int speed = 0;
  private transient Navi navi = null;

  //------------------------------
  // Konstruktor
  public Car(String zeile) {
    String[] tokens = zeile.split(",");
    this.owner = tokens[0];
    this.model = tokens[1];
    this.color = tokens[2];
    this.position = tokens[3];
    this.kmStatus = Integer.parseInt(tokens[4]);

    navi = new Navi("TomTom", "maennlich");
  }

  public Car(String owner, String model, String color, String standort, int kmStatus) {
    this.owner = owner;
    this.model = model;
    this.color = color;
    this.position = standort;
    this.kmStatus = kmStatus;

    navi = new Navi("TomTom", "maennlich");
  }

  //------------------------------
  // Methoden
  public void bremsen() {
    while (speed > 0) {
      speed--;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(model, car.model) && Objects.equals(color, car.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, color);
  }

  public void drive(String destination, int distance) {
    System.out.println("Das Auto faehrt von " + position + " nach " + destination
        + " (" + distance + " Km entfernt).");
    position = destination;
    kmStatus += distance;
  }

  public void accelerateUntil(int targetSpeed) {
    speed = targetSpeed;
  }

  public String getOwner() {
    return owner;
  }

  public int getSpeed() {
    return speed;
  }

  public int getKmStatus() {
    return kmStatus;
  }

  public String getPosition() {
    return position;
  }

  public Navi getNavi() {
    return navi;
  }

  public void setNavi(Navi navi) {
    this.navi = navi;
  }

  @Override
  public String toString() {
    return "Car [" +
        "owner='" + owner +
        ", model='" + model +
        ", color='" + color +
        ", position='" + position +
        ", kmStatus=" + kmStatus +
        ", speed=" + speed +
        ", navi=" + navi +
        ']';
  }
}