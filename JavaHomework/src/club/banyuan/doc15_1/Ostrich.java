package club.banyuan.doc15_1;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:41 下午
 */
public class Ostrich  extends  Bird{

  private double weight;
  private double speed;

  public Ostrich(String wings, String legs, double weight) {
    super(wings, legs);
    this.weight = weight;
  }

  public Ostrich(double speed) {
    this.speed = speed;
  }

  public Ostrich() {
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }
}
