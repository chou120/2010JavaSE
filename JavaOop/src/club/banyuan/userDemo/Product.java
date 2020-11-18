package club.banyuan.userDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 11:02 上午
 */
public class Product {

  private  String productId;
  private  String proName;
  private  String proAddress;
  private  double price;
  private  String size;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }

  public String getProAddress() {
    return proAddress;
  }

  public void setProAddress(String proAddress) {
    this.proAddress = proAddress;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId='" + productId + '\'' +
        ", proName='" + proName + '\'' +
        ", proAddress='" + proAddress + '\'' +
        ", price=" + price +
        ", size='" + size + '\'' +
        '}';
  }
}
