import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    // 线程不安全
    // Map<String, Integer> map = new HashMap<>();

    // 线程安全
    Map<String, Integer> map = new ConcurrentHashMap<>();

    for (int i = 0; i < 5; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          for (int j = 0; j < 100; j++) {
            map.put(Thread.currentThread().getName() + j, j);
          }
        }
      }).start();
    }

    Thread.sleep(5000);

    System.out.println(map.size());

    // 线程不安全
    // List<String> list = new ArrayList<>();
    // 线程安全
    List<String> list = new CopyOnWriteArrayList<>();
    AddToListThread t1 = new AddToListThread(list);
    AddToListThread t2 = new AddToListThread(list);
    AddToListThread t3 = new AddToListThread(list);
    AddToListThread t4 = new AddToListThread(list);
    t1.start();
    t2.start();
    t3.start();
    t4.start();

    t1.join();
    t2.join();
    t3.join();
    t4.join();

    System.out.println(list);
    System.out.println(list.size());
  }
}
