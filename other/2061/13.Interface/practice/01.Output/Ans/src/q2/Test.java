package q2;

interface A {

  void myMethod();

  void getInfo();
}

abstract class B implements A {

  void getData() {
    System.out.println("B");
  }

  // public abstract void myMethod();

  // abstract public void getInfo();

}

public class Test extends B {

  public void myMethod() {
    System.out.println("myMethod");
  }

  public void getInfo() {
    System.out.println("getInfo");
  }

  public static void main(String[] args) {
    B obj = new Test();
    obj.getInfo();
    obj.myMethod();
    obj.getData();
  }
}