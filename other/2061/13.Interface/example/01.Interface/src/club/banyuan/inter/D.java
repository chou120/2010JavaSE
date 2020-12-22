package club.banyuan.inter;

// 要求子类强制重写两个接口的冲突的方法
public abstract class D implements InterA, InterB {

  abstract public void method();

  // @Override
  // public void method() {
  //
  // }
}
