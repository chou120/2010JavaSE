public class BlockDemo {

  public BlockDemo() {
    System.out.println("1");
  }

  public BlockDemo(String a) {
    System.out.println("a");
  }

  static {
    System.out.println("2");
  }

  // 构造代码块，构造代码块的代码在new 类的时候被调用
  // 构造代码块代码相较于构造方法的代码优先执行
  // 可以将构造方法中公共的部分提取到构造代码块中
  {
    System.out.println("3");
  }

  public void instanceMethod() {
    System.out.println("4");
  }

  public static void staticMethod() {
    System.out.println("5");
  }

  public static void main(String[] args) {
    BlockDemo blockDemo = new BlockDemo();
    // blockDemo.instanceMethod();

    // BlockDemo.staticMethod();
  }
}
