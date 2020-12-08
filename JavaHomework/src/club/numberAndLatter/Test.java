package club.numberAndLatter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/7 9:05 下午
 */
public class Test {

  public static void main(String[] args) {
    LatterThread latterThread = new LatterThread();
    NumberThread numberThread = new NumberThread();
    latterThread.start();
    numberThread.start();
  }
}
