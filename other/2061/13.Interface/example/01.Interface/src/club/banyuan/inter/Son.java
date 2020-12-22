package club.banyuan.inter;

/**
 * ClsA和InterA同时定义了两个相同的方法，由父类中的方法重写接口的方法
 */
public class Son extends ClsA implements InterA {

  public static void main(String[] args) {
    Son son = new Son();
    son.method();

    ((InterA) son).method();
    InterA interA = son;
    interA.method();

    ClsA clsA = son;
    clsA.method();
  }
}
