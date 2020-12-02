package club.banyuan.demoListOver;

import java.util.Comparator;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 10:33 上午
 */
//外部比较器
public class MyComparetor  implements Comparator<Book> {
  @Override
  public int compare(Book o1, Book o2) {

    Double number = o1.getPrice() - o2.getPrice();
    int key = 10;
    if (number > 0) {
      key = 1;
    } else if (number < 0) {
      key = -1;
    } else {
      key = 0;
    }
    int number1 = key == 0 ? o1.getName().compareTo(o2.getName()) : key;
    return number1;
  }
}
