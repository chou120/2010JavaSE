package club.banyuan;

public class Main {

  // RuntimeException 和其子类，被称为非受查异常，运行时异常
  public static void main(String[] args) {
    // System.out.println("1");
    // System.out.println("2");
    // String s = null;
    // // System.out.println(s.toUpperCase()); // 抛出异常导致后续代码不会执行
    // // throw new RuntimeException("运行时异常");
    // throw new RuntimeException();
    // System.out.println("3");

    a();
    System.out.println("main finish");
  }

  public static void a() {
    System.out.println("a");
    b();
    System.out.println("a finish");
  }

  public static void b() {
    System.out.println("b");
    throw new RuntimeException();
    // System.out.println("b finish");
  }

  public static void c() {
    System.out.println("c");
    // throw 后面只能放 Throwable的子类对象
    throw new MyRuntimeException();
  }
}
