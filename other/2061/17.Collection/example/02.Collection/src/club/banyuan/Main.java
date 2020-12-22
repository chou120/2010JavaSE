package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

  // add(T);
  // remove(T);
  // set(index,T) 不通用
  // get(T)
  // size()
  // isEmpty();
  // clear();
  // for each
  public static void main(String[] args) {
    Collection<Integer> collection = new ArrayList<>();
    collection.add(1);
    collection.add(2);
    collection.add(3);
    collection.add(4);

    Integer[] integers = collection.toArray(new Integer[collection.size()]);
    System.out.println(Arrays.toString(integers));

    Collection<Integer> collection1 = new ArrayList<>();
    collection1.add(1);
    collection1.add(2);
    collection1.add(3);
    collection1.add(4);
    Integer[] integers1 = collection1.toArray(new Integer[collection.size()]);
    System.out.println(Arrays.toString(integers1));

    // 操作调用该方法的集合，集合保留交集数据，如果集合数据发生变化，返回true，否则返回false
    boolean b = collection.retainAll(collection1);
    integers = collection.toArray(new Integer[0]);
    System.out.println(Arrays.toString(integers));
    System.out.println(b);

    MyArrayList<Integer> myArrayList = new MyArrayList<>();
    myArrayList.add(1);
    myArrayList.add(2);
    myArrayList.add(3);
    myArrayList.add(4);
    for (Integer one : myArrayList) {
      System.out.println(one);
    }

    Iterator<Integer> iterator = myArrayList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }
}
