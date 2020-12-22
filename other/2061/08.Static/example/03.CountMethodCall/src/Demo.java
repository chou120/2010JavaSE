public class Demo {

  int countIn = 0;
  static int countSt = 0;

  public void instanceMethod() {
    staticMethod();
    // 增加调用次数的显示，实例方法的调用次数，每个对象是分开计算
    System.out.println("instance method called:" + (++countIn));
  }

  public static void staticMethod() {
    // instanceMethod(); // 报错
    // 增加调用次数的显示，静态方法的调用次数，是一起计算
    System.out.println("static method called:" + (++countSt));
  }

  public static void main(String[] args) {
    Demo demo1 = new Demo();
    Demo demo2 = new Demo();
    demo1.instanceMethod();
    demo1.instanceMethod();
    demo1.instanceMethod();
    demo1.instanceMethod();
    demo1.instanceMethod();
    demo2.instanceMethod();
    demo2.instanceMethod();
    demo2.instanceMethod();
    demo2.instanceMethod();
    demo2.instanceMethod();
    demo2.instanceMethod();
    Demo.staticMethod();
    Demo.staticMethod();
    Demo.staticMethod();
    Demo.staticMethod();
    demo1.staticMethod();
    demo1.staticMethod();
    demo1.staticMethod();
    demo2.staticMethod();
    demo2.staticMethod();
    demo2.staticMethod();
    demo2.staticMethod();
  }
}
