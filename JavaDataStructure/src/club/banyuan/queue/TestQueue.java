package club.banyuan.queue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 9:44 上午
 */
public class TestQueue {

  public static void main(String[] args) {
    final ArrayQueue arrayQueue = new ArrayQueue();
    arrayQueue.add("李四1");
    arrayQueue.add("李四2");
    arrayQueue.add("李四3");
    arrayQueue.add("李四4");

    arrayQueue.remove();

    System.out.println(arrayQueue);

  }

}
