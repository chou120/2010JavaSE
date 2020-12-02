package club.collection;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 9:43 上午
 */
public class Book {

  private  String name;
  private  Double price;
  private  String  press;//出版社
  private  String author;

  public Book() {
  }

  public Book(String name, Double price, String press, String author) {
    this.name = name;
    this.price = price;
    this.press = press;
    this.author = author;
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

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", press='" + press + '\'' +
        ", author='" + author + '\'' +
        '}';
  }
}
