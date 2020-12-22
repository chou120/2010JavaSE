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
      // TODO 发起一个呼叫

      // TODO 呼叫持续中，休眠随机生成的时间，

      // TODO 结束通话
    }


  }
}
