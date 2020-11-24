package club.banyuan.cake;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 9:25 上午
 */
public class ReadyMadeCake extends  Cake{

  private  double quantity;

  public double getQuantity() {
    return quantity;
  }

  public ReadyMadeCake(int n, double r, double quantity) {
    super(n, r);
    this.quantity = quantity;
  }

  @Override
  public double calcPrice() {
    return price*quantity;
  }
}
