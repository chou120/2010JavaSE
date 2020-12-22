package demo;

public class Product {

  private static int codeBase = 1000;
  private String name;
  private double price;
  private int scanCode;
  private int num;

  {
    // 构造代码块中，只要对象创建，代码都会被执行
    // 对每个对象中的scanCode的成员变量进行初始化，每个对象的编号都是不同的
    scanCode = codeBase++;
  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getScanCode() {
    return scanCode;
  }

  public void setScanCode(int scanCode) {
    this.scanCode = scanCode;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  /**
   * 输出商品信息
   *
   * @return
   */
  public String getInfo() {
    StringBuilder builder = new StringBuilder();
    builder.append("商品名称：").append(name);
    builder.append(System.lineSeparator());
    builder.append("价格：").append(price);
    builder.append(System.lineSeparator());
    builder.append("编码：").append(scanCode);
    // System.out.println("商品名称：" + name);
    // System.out.println("价格：" + price);
    // System.out.println("编码：" + scanCode);
    String rlt = builder.toString();
    System.out.println(rlt);
    return rlt;
  }

  public boolean buy(int num) {
    if (num > this.num) {
      return false;
    } else {
      this.num -= num;
      return true;
    }
  }

  public static void main(String[] args) {
    Product product = new Product("手机", 1000.11);
    product.getInfo();
    product.setNum(100);

    System.out.println(product.buy(60));
    System.out.println(product.buy(60));
  }
}
