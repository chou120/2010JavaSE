package club.banyuan;

// 外部类
public class OuterClass {

  private String outerField = "outer field";

  public void outerMethod() {
    // 使用调用该方法的外部类对象来创建一个内部类对象
    System.out.println(new InnerClass().innerField);
  }

  // 静态方法调用的时候，没有外部类对象，因此需要创建一个外部类对象才能继续创建内部类对象
  public static void outerStaticMethod() {
    System.out.println(new OuterClass().new InnerClass().innerField);
  }

  // 内部类
  public class InnerClass {

    private String innerField = "inner field";
    // 内部类中不允许出现static
    // static String test = "";

    public void innerMethod() {
      System.out.println(this);
      // 获取创建这个内部类对象时，使用的外部类的对象
      System.out.println(OuterClass.this);
      System.out.println(outerField);
    }

    public void innerMethod(OuterClass outerClass) {
      System.out.println(this);
      // 获取创建这个内部类对象时，使用的外部类的对象
      System.out.println(OuterClass.this == outerClass);
      System.out.println(outerField);
    }

  }

}


