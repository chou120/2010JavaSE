package club.banyuan;

import java.io.OutputStream;

public class Outer {

  public static void main(String[] args) {
    // 创建了一个匿名的A接口的实现类
    A a = new A() {
      @Override
      public void methodA() {

      }
    };

    // 函数式接口可以被lambda表达式替换
    A a1 = () -> {

    };

    Outer o1 = new Outer();

    // 创建一个Outer的匿名子类
    Outer outer = new Outer() {

    };

    // 创建一个抽象类的匿名子类
    AbstractB abstractB = new AbstractB() {

    };
  }


}
