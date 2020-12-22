public class Driver {

  public static void main(String[] args) throws InterruptedException {
    // 创建一个电话
    CellularPhone aPhone = new CellularPhone("Phone");

    aPhone.start();

    // 创建两个呼叫生成器，他们不停的打电话。
    PhoneCallGenerator pcGen1 = new PhoneCallGenerator("Tom", aPhone);
    PhoneCallGenerator pcGen2 = new PhoneCallGenerator("Jerry", aPhone);
    pcGen1.start();
    pcGen2.start();

    pcGen1.join();
    pcGen2.join();

    aPhone.stopPhone();
  }
}
