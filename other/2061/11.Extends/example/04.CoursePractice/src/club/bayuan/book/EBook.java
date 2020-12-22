package club.bayuan.book;

public class EBook extends Book {

  private double sizeMB;

  public EBook(String title, double price, double cost, int pages, double sizeMB) {
    super(title, price, cost, pages);
    this.sizeMB = sizeMB;
  }

  public EBook(String title, double price, double cost, int pages) {
    super(title, price, cost, pages);
  }

  public double getSizeMB() {
    return sizeMB;
  }

  public void setSizeMB(double sizeMB) {
    this.sizeMB = sizeMB;
  }
}
