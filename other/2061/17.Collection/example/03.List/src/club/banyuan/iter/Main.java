package club.banyuan.iter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");

    System.out.println(list);

    // 不要在循环的时候对进行对集合长度变化产生影响的操作
    // for (int i = 0; i < list.size(); i++) {
    //   if (i % 2 == 0) {
    //     list.remove(i);
    //   }
    // }
    //
    // System.out.println(list);

    Iterator<String> iterator = list.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      iterator.next();
      if (count % 2 == 0) {
        iterator.remove();
      }
      count++;
    }
    System.out.println(list);


    List<String> list1 = new ArrayList<>();
    list1.add("1");
    list1.add("2");
    list1.add("3");
    list1.add("4");
    list1.add("5");
    list1.add("6");

    Iterator<String> iterator1 = list1.iterator();
    int count1 = 0;
    while (iterator1.hasNext()) {
      iterator1.next();
      // 不要在迭代器操作的时候，操作集合对象添加元素 ConcurrentModificationException
      // list1.add("123");
      if (count1 % 2 == 0) {
        iterator1.remove();
      }
      count1++;
    }
    System.out.println(list1);

    // ConcurrentModificationException
    for (String s : list1) {
      list1.remove(s);
    }
  }
}
