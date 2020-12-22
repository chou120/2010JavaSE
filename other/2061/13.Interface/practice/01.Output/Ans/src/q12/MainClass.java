package q12;

import java.util.ArrayList;

interface X {

  // default void method() {
  //   System.out.println("interface X");
  // }
  void method();
}

class Y {

  public void method() {
    System.out.println("CLASS Y");
  }
}

class Z extends Y implements X {

  // public void method() {
  //   System.out.println("CLASS Z");
  // }
}

public class MainClass {

  public static void main(String[] args) {
    X x = new Z();

    x.method(); // CLASS Y
  }
}