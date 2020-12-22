package club.banyuan;

import club.banyuan.OuterClass;

public class Main {

  public static void main(String[] args) {
    // 内部类的创建
    // 内部类对象的创建，依赖于一个外部类的对象
    OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

    innerClass1.innerMethod();
    innerClass1.innerMethod(outerClass);
  }
}
