package club.threadHomework2;


/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:41 上午
 */
public class Test {

  public static void main(String[] args) {
    Tool tool = new Tool();
    AddThread addThread = new AddThread(tool);
    DelThread delThread = new DelThread(tool);

    Thread threadA = new Thread(addThread, "线程A");
    Thread threadB = new Thread(addThread, "线程B");
    Thread threadC = new Thread(delThread, "线程C");
    Thread threadD = new Thread(delThread, "线程D");

    threadA.start();
    threadB.start();
    threadC.start();
    threadD.start();

  }
}
