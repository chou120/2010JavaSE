package club.banyuan.area;

// 抽象类，不能实例化
abstract public class Shape {

  // 抽象方法，没有方法体, 抽象方法强制要求子类重写。
  // 如果子类不重写，这个子类也必须是抽象类
  abstract public double area();

  abstract public double perimeter();

  abstract public String getShapeName();

}
