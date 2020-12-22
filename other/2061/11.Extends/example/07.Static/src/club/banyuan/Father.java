package club.banyuan;

public class Father {

  public static String fatherField = "fatherField";

  public static void staticMethod() {
    System.out.println("father static method");
  }

  static {
    System.out.println("father static block"); // 3
  }

  {
    System.out.println("father instance block"); // 4
  }
}
