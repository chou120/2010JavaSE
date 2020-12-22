package club.banyuan.phone;

import java.util.Random;

/**
 * 用于向电话呼叫
 */
public class PhoneCallGenerator extends Thread {

  private CellularPhone phone;

  public PhoneCallGenerator(String name, CellularPhone thePhone) {
    super(name);
    phone = thePhone;
  }

  public void run() {

    // 生成20个电话
    for (int i = 0; i < 20; i++) {
      synchronized (phone) {
        // TODO 发起一个呼叫
        phone.startCall(getName(), i + "");
        // TODO 呼叫持续中，休眠随机生成的时间，
        try {
          Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // TODO 结束通话
        phone.endCall(getName(), i + "");
        // 通过调用锁对象的notifyAll，通知所有处于wait状态的线程，唤醒线程
        // phone.notifyAll();
        phone.notify();
        try {
          phone.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      Thread.yield();
    }


  }
}
