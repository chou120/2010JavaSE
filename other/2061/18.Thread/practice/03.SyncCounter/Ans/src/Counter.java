public class Counter {

  private int value;

  /**
   * 将counter每次加1，加10次，时不时地休息一下。
   */
  public void count() {
    for (int i = 0; i < 10; i++) {
      synchronized (Counter.class) {
        value++;
      }

      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public int get() {
    return value;
  }

}
