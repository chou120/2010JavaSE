package club.banyuan;

public class Outer {

  private String outerField = "outer field";

  // 静态内部类
  // 静态内部类的表现和正常类类似
  public static class Inner {

    // 静态内部类中允许出现static

    public void innerMethod() {
      // 静态内部类中不能直接使用外部类的成员变量，因为外部类的对象没有被创建
      // System.out.println(outerField);
      System.out.println(new Outer().outerField);
      // Outer.this 只能出现在非静态的内部类中
    }
  }
}
