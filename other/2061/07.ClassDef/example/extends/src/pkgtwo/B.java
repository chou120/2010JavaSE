package pkgtwo;

// import pkgone.A;

import pkgone.C;

public class B {

  public static void main(String[] args) {
    C c = new C();
    c.printA();
    // B中不具备对A的访问权限，也无法直接调用A中的public方法
    // c.getA().printA();  // 编译报错
  }
}
