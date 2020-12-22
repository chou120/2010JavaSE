package club.banyuan.phone;

public class CellularPhone extends Thread {

  private volatile boolean callInProgress = false;
  private volatile boolean keepGoing = true;

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
   */
  public void startCall(String name, String callDisplayMessage) {
    callInProgress = true;
    display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
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
      // 如果没有电话，就处于等待的状态。并且等待过程中，需要释放掉获取到的锁。
      synchronized (this) {
        if (!callInProgress) {
          displayWaiting();
          // notify随机唤起一个处于等待的线程
          this.notify();
        }
        try {
          // 调用锁对象的wait方法，实现等待
          // 等待将会阻塞当前线程，将已经获取到的锁归还。
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    }
  }
}
