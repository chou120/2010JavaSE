package club.banyuan.func;

public class EffectivelyFinalDemo {

  public static int staticI = 20;
  public int fieldI = 30;

  public static void main(String[] args) {
    EffectivelyFinalDemo demo = new EffectivelyFinalDemo();
    int i = 15;
    // i = 20;
    A a = new A() {
      @Override
      public void methodA() {
        // 如果这里需要使用外部定义的局部变量
        // 需要保证变量被final修饰
        // 如果使用的外部局部变量没有被修改过
        // 这种情况被称作effectively final，允许在匿名内部类中使用。
        System.out.println(i);

        // 静态变量或成员变量没有effectively final的限制。
        System.out.println(staticI);
        staticI++;
        System.out.println(demo.fieldI);
        demo.fieldI++;
      }
    };

    OtherDemo otherDemo = new OtherDemo();
    A test = otherDemo.test(demo);
    test.methodA();
  }
}
