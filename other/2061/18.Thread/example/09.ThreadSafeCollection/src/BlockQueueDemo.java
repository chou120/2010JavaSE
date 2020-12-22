import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

    Thread thread = null;
    for (int i = 0; i < 5; i++) {
      thread = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName() + "添加" + j);
            // 添加成功返回true，失败返回false
            // System.out.println(queue.offer(j + ""));

            // 如果没有元素则返回null
            // queue.poll();

            // try {
            //   // 阻塞，直到元素添加成功
            //   queue.put(j + "");
            // } catch (InterruptedException e) {
            //   e.printStackTrace();
            // }

            //
            // try {
            //   // 阻塞，直到获取元素
            //   queue.take();
            // } catch (InterruptedException e) {
            //   e.printStackTrace();
            // }

            // 如果添加失败，则抛出异常
            // queue.add(j + "");
            // 如果没有元素，则抛异常
            queue.remove();
          }
        }
      });
      thread.start();
    }

    Thread.sleep(2000);

    System.out.println(queue);
    System.out.println(thread.getState());

    // queue.offer("123");
    // try {
    //   queue.put("123");
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // queue.add("123");
    //
    // queue.poll();
    // try {
    //   queue.take();
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // queue.remove();
  }
}
