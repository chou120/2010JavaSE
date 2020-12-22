import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CellularPhone extends Thread {

  private volatile boolean callInProgress = false;
  private volatile boolean keepGoing = true;
  private Lock lock = new ReentrantLock();
  private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(40);

  public CellularPhone(String name) {
    super(name);
  }

  /**
   * 假设控制台是手机的窗口。
   *
   * @param message 要显示的消息
   */
  void display(String message) {
    System.out.println(message);
  }

  /**
   * 接听电话。在终端显示消息。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 呼叫正在进行时显示的消息
   * @return true 电话被接听，false 电话没有接通
   */
  public boolean startCall(String name, String callDisplayMessage) {
    // 获取锁，成功表示电话被接通
    if (lock.tryLock()) {
      callInProgress = true;
      display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
      return true;
    } else {
      return false;
    }
  }

  /**
   * 挂断电话。在此方法完成后，电话能够接听其他电话。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 要显示的消息
   */
  public void endCall(String name, String callDisplayMessage) {
    display("   <" + name + ">: Call (" + callDisplayMessage + ") ends");
    callInProgress = false;
    lock.unlock();
  }

  /**
   * 显示手机正在等待做某事
   */
  private void displayWaiting() {
    display("<" + this.getName() + ">: Waiting...");
  }

  /**
   * 停止电话接听程序
   */
  public void stopPhone() {
    keepGoing = false;
  }

  /**
   * 运行模拟器
   */
  public void run() {
    // 循环直到stopPhone被调用
    while (keepGoing) {
      if (!callInProgress && lock.tryLock()) {
        if (blockingQueue.isEmpty()) {
          displayWaiting();
        } else {
          try {
            displayMessages();
          } catch (InterruptedException e) {
            // 中断退出
            break;
          }
        }
        lock.unlock();
      }

      // 假装手机在做别的事情
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void addMessage(String s) throws InterruptedException {
    blockingQueue.put(s);
  }

  private void displayMessages() throws InterruptedException {
    while (!blockingQueue.isEmpty()) {
      String poll = blockingQueue.take();
      System.out.println("<Phone>: Message: " + poll);
    }
  }

}
