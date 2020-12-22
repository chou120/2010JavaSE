package club.bayuan.book;

public class Book {

  // - 标题
  protected String title;
  // - 售价
  protected double price;
  // - 成本
  protected double cost;
  // - 页数
  protected int pages;

  public Book(String title, double price, double cost, int pages) {
    this.title = title;
    this.price = price;
    this.cost = cost;
    this.pages = pages;
  }

  public double getProfit() {
    return price - cost;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }
}
