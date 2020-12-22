package club.banyuan.dataset;

// 接口不能实例化
public interface Measure {

  // 定义在接口中的变量都是public static final类型的
  public static final int a = 50;

  // 接口没有构造方法
  // 接口中定义的方法都是抽象方法，都是public的
  double measure();
}
