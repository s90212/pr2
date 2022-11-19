package de.bht.pr2.lession03.example08;

public class MainProgramm8 {

  // Autoboxing und unboxing - Methoden

  public static Integer myMethod(Integer i) { // Autoboxing
    i += 100;
    return i;
  }

  public static void main(String[] args) {
    int a = 10;
    int b = myMethod(a); // Unboxing
  }
}
