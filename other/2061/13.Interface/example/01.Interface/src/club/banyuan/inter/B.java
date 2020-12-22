package club.banyuan.inter;

// Ixxx
// able
public interface B {

  default void m1() {

  }

  // 创建静态的方法，提供工具方法
  static void m5() {

  }

  // 给default方法提供代码的复用
  private void m4() {

  }

  void m2();

  void m3();
}
