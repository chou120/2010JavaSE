package q11;

class A {

  void A() {
    System.out.println(1);
  }
}

class B extends A {

  B() {
    // 构造方法中可以使用父类中定义的实例方法，只要拥有合适的访问权限
    A();
  }

  // 实例方法可以和构造方法同名，区别在于实例方法有返回值
  void B() {
    A();
  }
}

public class MainClass {

  public static void main(String[] args) {
    new B().B();
  }
}