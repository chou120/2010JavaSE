package club.banyuan.func;

public class Main {

  public static void testA(A a) {
    a.methodA();
  }

  public static void testB(B b) {
    b.methodB("1234"); // => System.out.println("1234")
  }

  public static void testC(String s1, String s2) {
    System.out.println(s1);
    System.out.println(s2);
  }

  public static void main(String[] args) {
    A a = new A() {
      @Override
      public void methodA() {
        System.out.println("1234");
      }
    };

    A a1 = () -> {
      System.out.println("1234");
    };

    A a2 = () -> System.out.println("1234");

    testA(a);
    testA(a1);

    B b = new B() {
      @Override
      public void methodB(String s) {
        System.out.println(s);
      }
    };

    B b1 = s -> System.out.println(s);

    B b2 = System.out::println;

    testB(b2);

    C c = new C() {
      @Override
      public void methodC(String s1, String s2) {
        s1.indexOf(s2);
      }
    };

    C c1 = String::indexOf; // 对象1.indexOf(对象2)
    // c1.methodC(对象1,对象2);
    // 方法引用，实例方法，有一个入参，入参的数据类型和对象2的数据类型一致
    // 调用方法的实例的数据类型和对象1的数据类型一致

    // 引用静态方法，C的方法的两个入参，作为静态方法的两个入参传入。
    C c2 = Main::testC;
  }
}
