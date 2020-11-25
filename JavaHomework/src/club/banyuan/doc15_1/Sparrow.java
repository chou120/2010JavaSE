package club.banyuan.doc15_1;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 1:40 下午
 */
public class Sparrow  extends  Bird{

  private int age;
  private double weight;

  public Sparrow(String wings, String legs, int age) {
    super(wings, legs);
    this.age = age;
  }

  public Sparrow(String wings, String legs, double weight) {
    super(wings, legs);
    this.weight = weight;
  }

  public Sparrow(String wings, String legs) {
   //super(wings, legs); 默认父类的无参
  }

  public Sparrow() {
    super();
  }

  @Override
  public String toString() {
    return "Sparrow{" +
        "age=" + age +
        ", weight=" + weight +
        '}';
  }
}
