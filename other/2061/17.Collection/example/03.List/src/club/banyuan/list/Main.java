package club.banyuan.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(3);
    linkedList.add(2);
    linkedList.add(6);
    linkedList.add(4);

    // Queue<String> queue = new LinkedList<>();
    // queue.offer("1");
    // queue.offer("2");
    // queue.offer("3");
    // queue.offer("4");
    // queue.offer("5");
    //
    // System.out.println(queue.isEmpty());
    // System.out.println(queue.size());
    // System.out.println(queue.peek());
    // System.out.println(queue.size());
    // System.out.println("出队列");
    // System.out.println(queue.poll());
    // System.out.println(queue.size());
    // System.out.println(queue.peek());

    // linkedList.sort(new Comparator<Integer>() {
    //   @Override
    //   public int compare(Integer o1, Integer o2) {
    //     return o2 - o1;
    //   }
    // });
    //
    // linkedList.sort((o1, o2) -> o2 - o1);
    //
    // System.out.println(linkedList);
    //
    Arrays.sort(new Integer[10], new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return 0;
      }
    });

    // 提供一个用于比较两个对象大小的对象。 像裁判一样。
    sort(linkedList, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    System.out.println(linkedList);
  }

  public static void sort(List<Integer> list, Comparator<Integer> comparator) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = i; j < list.size(); j++) {
        if (comparator.compare(list.get(i), list.get(j)) > 0) {
          Integer integer = list.get(i);
          list.set(i, list.get(j));
          list.set(j, integer);
        }
      }
    }
  }

}
