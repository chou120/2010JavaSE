package club.banyuan.moon.refine;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 2:51 下午
 */
public class Moon {

  private  String name; //月饼名称
  private  Double price;//月饼价格
  boolean flag=false;//月饼是否生产成功   红绿灯模式

  public Moon() {
  }

  public Moon(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Moon{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
