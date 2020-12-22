package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IteratorDemo {

  public static void main(String[] args) {
    Collection<Integer> collection = new ArrayList<>();
    collection.add(1);
    collection.add(2);
    collection.add(3);
    collection.add(4);


    // iterable 的实现类，都可以使用 foreach的方式进行遍历
    for (Integer integer : collection) {

    }

    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new LinkedList<>();


  }
}
