package club.banyuan.demo;

import java.util.function.Supplier;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 5:08 下午
 */
public class LambdaDemo4 {

}

@FunctionalInterface
interface MyFunc {
  //不是供给型接口 所以在使用 MyClass::new 的时候返回的是一个对象  没办法用来接收
  void func(int n);
}

class MyClass {

  private int val;

  public MyClass(int v) {
    val = v;
  }

  public MyClass() {
    val = 0;
  }

  public int getValue(int x) {
    return 0;
  }

  public void method(int x) {
    System.out.println(x);
  }
}

class ConstructorRefDemo {

  public static void main(String[] args) {

    Supplier<MyClass> supplier = MyClass::new;  //还是用供给型接口

    MyClass myClass = supplier.get();

    show(myClass::getValue, 323);


  }

  public static void show(MyFunc myFunc, int number) {
    myFunc.func(number);
  }

}
