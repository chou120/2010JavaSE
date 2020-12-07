package club.banyuan.demoProduct;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 9:29 上午
 */
public class Product {

  //需求   张三李四两个人去买商品,商品只有十个,张三和李四去争抢这个商品
  private int  number=10;

  public Product() {
  }

  public Product(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Product{" +
        "number=" + number +
        '}';
  }
}
