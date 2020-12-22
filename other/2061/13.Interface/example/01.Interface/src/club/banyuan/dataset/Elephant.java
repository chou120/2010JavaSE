package club.banyuan.dataset;

// 类可以继承一个类，实现多个接口
public class Elephant extends Animal implements Measure {

  private double weightKG;

  public Elephant(double weightKG) {
    this.weightKG = weightKG;
  }

  public double getWeightKG() {
    return weightKG;
  }

  public void setWeightKG(double weightKG) {
    this.weightKG = weightKG;
  }

  @Override
  public String getType() {
    return "大象";
  }

  public void elephantMethod() {
    System.out.println("elephant method called");
  }

  @Override
  public double measure() {
    return weightKG;
  }
}
