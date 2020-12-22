public class FinalDemo {

  int b = c;
  int a = b;
  // static int e= c; // 编译报错
  static int c;
  // static int d = a; // 编译报错

  public final String[] strings = new String[10];

  // 使用这种方式定义常量，定义常量，建议使用全单词大写，使用_分割的命名方式
  public static final double PI = 3.14;

  // 被final修饰的实例变量，必须在定义的时候赋初值
  // final int instanceField = 12;
  final int instanceField;

  final static int staticField;

  // 可以在静态代码块中对静态的final变量进行初始化
  static {
    staticField = 12;
  }

  // 或者通过构造方法，给final修饰的成员变量赋初值
  // public FinalDemo(int instanceField) {
  //   this.instanceField = instanceField;
  // }

  // 使用构造代码块可以给final的实例变量赋初值
  {
    instanceField = 4;
  }

  // 如果有构造方法，没有选择会final的实例变量赋值，则会编译报错
  // public FinalDemo(String a) {
  //
  // }

  public static void main(String[] args) {
    // 被final修饰的局部变量只能被赋值一次
    final int a = 4;
    // a = 5; 编译报错

    FinalDemo demo = new FinalDemo();
    // final修饰的引用数据类型，可以使用变量对引用的数据进行操作
    // 不能使用赋值语句，修改变量的引用
    demo.strings[0] = "1234";
    // demo.strings = new String[20];
  }
}
