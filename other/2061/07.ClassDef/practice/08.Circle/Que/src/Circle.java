public class Circle {

  private double r;

  public Circle(double r) {
    this.r = r;
  }

  public Circle(Circle circle) {
    r = circle.r;
  }

  // 虽然名字和类名一致，但是有返回值，不是构造方法
  // public void Circle(double r) {
  //   r = r;
  // }

  public double calPerimeter() {
    return 2 * Math.PI * r;
  }

  public double calArea() {
    return Math.PI * r * r;
  }

  public void setRadius(double r) {
    this.r = r;
  }
}
