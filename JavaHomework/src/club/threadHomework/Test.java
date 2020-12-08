package club.threadHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/8 9:03 上午
 */
public class Test {
  //12A 34B  56C  ...5152Z

  public static void main(String[] args) {
    final LetterThread letterThread = new LetterThread();
    letterThread.start();
    final NumberThread numberThread = new NumberThread();
    numberThread.start();
   // letterThread.setPriority(10);



  }
}
