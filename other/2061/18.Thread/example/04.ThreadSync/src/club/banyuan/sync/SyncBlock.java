package club.banyuan.sync;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 同步代码块
 * 多线程同时操作共享资源，对资源进行修改操作
 */
public class SyncBlock {

  public static void main(String[] args) throws InterruptedException {
    List<String> list = new SyncList();
    AddToListThread t1 = new AddToListThread("线程1", list);
    AddToListThread t2 = new AddToListThread("线程2", list);
    AddToListThread t3 = new AddToListThread("线程3", list);
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();

    // list.sort(String::compareTo);
    System.out.println(list);
    System.out.println(list.size());

  }


}
