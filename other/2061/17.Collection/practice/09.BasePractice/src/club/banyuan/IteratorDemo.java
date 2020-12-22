package club.banyuan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratorDemo {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    Iterator<String> iterator = list.iterator();

    // while (iterator.hasNext()) {
    String next = iterator.next();
    System.out.println(next);
    iterator.remove();
    // 集合进行了添加或删除操作后，之前生成的迭代器作废，不能再使用
    // 如果要继续使用，则会抛出ConcurrentModificationException异常
    // list.remove(1);
    System.out.println(iterator.hasNext());
    iterator.next();
    // for (String s : list) {
    //   list.add("123");
    // }
    // }

    // iterator.next();

    Iterator<String> iterator1 = list.iterator();
    // while (iterator1.hasNext()) {
    //   consumer.acept(iterator1.next());
      // System.out.println(iterator1.next());
    // }

    // iterator1.forEachRemaining(
    //     // 循环遍历迭代器的内容
    //     // 将每一个内容取出来
    //     自定义的方法(接收每一个迭代器取出来的对象) {
    //   自定义的方法实现。
    // }
    // }
    //
    //

    iterator1.forEachRemaining(new Consumer<String>() {
      @Override
      public void accept(String s) {
        // 不构成方法引用
        System.out.println("结果是:" + s);
      }
    });

    iterator1.forEachRemaining(s -> {
      // 构成方法引用
      System.out.println(s);
      System.out.println(s);
      System.out.println(s);
      System.out.println(s);
    });

    // 构成方法引用
    iterator1.forEachRemaining(System.out::println);




    // );

    // list.remove(1);

    // System.out.println(iterator.next());

  }
}
