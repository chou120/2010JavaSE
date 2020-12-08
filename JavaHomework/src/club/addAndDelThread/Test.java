package club.addAndDelThread;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 8:31 下午
 */
public class Test {

  public static void main(String[] args) {
    Tool  tools=new Tool();
    AddThread  addThread1=new AddThread(tools);
    DelThread  delThread2=new DelThread(tools);

    Thread t1=new Thread(addThread1, "线程A");
    Thread t2=new Thread(addThread1, "线程B");
    Thread t3=new Thread(delThread2, "线程C");
    Thread t4=new Thread(delThread2, "线程D");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
