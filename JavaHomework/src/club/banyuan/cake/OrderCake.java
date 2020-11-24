package club.banyuan.cake;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 9:25 上午
 */
public class OrderCake  extends Cake {

  private  double  weightInKG;

  public OrderCake(int n, double r, double weightInKG) {
    super(n, r);
    this.weightInKG = weightInKG;
  }

  @Override
  public double calcPrice() {
    return price*weightInKG;
  }
}
