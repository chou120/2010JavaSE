package club.banyuan.inter;

public interface A {

  // 接口中使用default创建默认的方法实现，实现类中可以选择重写或者不重写
  default void method() {
    System.out.println("提供默认的方法");
  }
}
