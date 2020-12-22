package club.banyuan.dataset;

public class Circle extends Shape implements Measure{

  private int r;

  @Override
  public String getShapeName() {
    return "圆形";
  }

  public Circle(int r) {
    this.r = r;
  }

  @Override
  public double area() {
    return Math.PI * r * r;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * r;
  }

  @Override
  public double measure() {
    return this.area();
  }
}
