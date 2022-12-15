package de.bht.pr2.lession07;

import java.util.Objects;

public class Car {
  private String owner = "";
  private String model = "";
  private String color = "";
  private String position = "";
  private int kmStatus = 0;
  private int speed = 0;
  private transient Navi navi = null;


  //------------------------------
  // Konstruktor
  public Car() {

  }

  public Car(String zeile) {
    String[] tokens = zeile.split(",");
    this.owner = tokens[0];
    this.model = tokens[1];
    this.color = tokens[2];
    this.position = tokens[3];
    this.kmStatus = Integer.parseInt(tokens[4]);

    navi = new Navi("TomTom", "maennlich", true);
  }

  public Car(String owner, String model, String color, String standort, int kmStatus) {
    this.owner = owner;
    this.model = model;
    this.color = color;
    this.position = standort;
    this.kmStatus = kmStatus;

    navi = new Navi("TomTom", "maennlich", true);
  }

  //------------------------------
  // Methoden
  public void bremsen() {
    while (speed > 0) {
      speed--;
    }
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

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getKmStatus() {
    return kmStatus;
  }

  public void setKmStatus(int kmStatus) {
    this.kmStatus = kmStatus;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return kmStatus == car.kmStatus && speed == car.speed && Objects.equals(owner,
        car.owner) && Objects.equals(model, car.model) && Objects.equals(color,
        car.color) && Objects.equals(position, car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, model, color, position, kmStatus, speed);
  }
}