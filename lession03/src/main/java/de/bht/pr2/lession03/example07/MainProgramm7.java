package de.bht.pr2.lession03.example07;

public class MainProgramm7 {

  // Autoboxing und Unboxing - Zuweisungen

  public static void main(String[] args) {
    // Autoboxing
    Byte byteObjekt = (byte) 1;
    Short shortObjekt = (short) 2;
    Integer integerObjekt = 3;
    Long longObjekt = 4L;
    Float floatObjekt = 5F;
    Double doubleObjekt = 6D;
    Boolean booleanObjekt = true;
    Character characterObjekt = 'a';

    // Unboxing
    byte b = byteObjekt;
    short s = shortObjekt;
    int i = integerObjekt;
    long l = longObjekt;
    float f = floatObjekt;
    double d = doubleObjekt;
    boolean bool = booleanObjekt;
    char c = characterObjekt;
  }
}
