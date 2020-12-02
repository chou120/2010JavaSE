package club.banyuan.demoListOver;

import java.util.Comparator;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 9:43 上午
 */

//内部比较器
public class Book implements Comparable<Book>{

  private String name;
  private Double price;
  private String press;//出版社
  private String author;

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

  @Override
  public int compareTo(Book o) {
    Double number =this.getPrice() - o.getPrice();

    int key = 10;
    if (number > 0) {
      key = 1;
    } else if (number < 0) {
      key = -1;
    } else {
      key = 0;
    }
    int number1 = key == 0 ? this.getName().compareTo(o.getName()) : key;
    return number1;

  }
}
