package q8;

class Test {

  void myMethod() {
    System.out.println("Test");
  }
}

class Derived extends Test {

  void myMethod() {
    System.out.println("Derived");
  }

  public static void main(String[] args) {
    Derived object = (Derived) new Test();
    object.myMethod();

    // Test test = new Derived();
    // Derived derived = (Derived) test;
  }
}


class A {

}

class B extends A {

}

class C extends B {

  public static void main(String[] args) {
    C c = new C();
    A a = c;
    B b = (B) a;
    A a1 = new B();
    // 编译报错， 向下转型的时候需要确保变量中保存的对象的数据类型和需要转换的数据类型一致，或者是转换的数据类型的子类
    // C a11 = (C) a1;
  }
}