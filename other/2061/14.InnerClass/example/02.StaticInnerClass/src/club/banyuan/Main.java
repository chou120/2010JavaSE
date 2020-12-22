package club.banyuan;

import club.banyuan.Outer.Inner;

public class Main {

  public static void main(String[] args) {
    // 静态内部类的创建，不依赖于外部类对象
    Outer.Inner inner = new Outer.Inner();
  }
}
