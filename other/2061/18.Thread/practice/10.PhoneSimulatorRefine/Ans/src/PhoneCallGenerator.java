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
      if (phone.startCall(getName(), i + "")) {
        try {
          Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        phone.endCall(getName(), i + "");
      } else {
        System.out.println("<" + getName() + ">: Busy, call (" + i + ") dropped");
      }
      try {
        Thread.sleep(new Random().nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      Thread.yield();
    }


  }
}
