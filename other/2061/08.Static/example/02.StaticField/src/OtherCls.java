public class OtherCls {

  public int field;
  public static int staticField;

  // 静态代码块，执行顺序按照定义的先后顺序
  static {
    System.out.println("OtherCls 加载");
  }

  static {
    System.out.println("OtherCls 加载1");
  }

  static {
    System.out.println("OtherCls 加载2");
  }

  public OtherCls() {
    System.out.println("OtherCls 构造方法");
  }

  public static void staticMethod() {
    System.out.println("静态方法调用");
  }
}
