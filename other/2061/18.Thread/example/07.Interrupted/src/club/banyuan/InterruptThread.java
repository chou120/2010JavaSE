package club.banyuan;

import java.util.Scanner;

public class InterruptThread extends Thread {

  public boolean isRun = true;

  @Override
  public void run() {
    // while (Thread.currentThread().isInterrupted()) {
    while (Thread.currentThread().isInterrupted()) {
      // for (int i = 0; i < 10000000; i++) {
      //   System.out.println(isInterrupted());
      // }

      // nextLine 不会被中断，可能会导致线程无法退出。
      // Scanner scanner = new Scanner(System.in);
      // scanner.nextLine();

      // 返回当前线程的终端标识，不会重置
      // 和 isInterrupted类似
      Thread.currentThread().isInterrupted();

      // 发送中断，将中断标识置为true
      Thread.currentThread().interrupt();

      // 静态方法，将会返回线程的中断标识，并且重置标识
      Thread.interrupted();

      try {
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(isInterrupted());
        System.out.println(Thread.interrupted());
        // Thread.sleep(1000);
        join();
      } catch (InterruptedException e) {
        System.out.println(isInterrupted());
        System.out.println(Thread.interrupted());
        // try catch 中断之后，会将中断标志清除，如果需要保持中断，需要重新标志中断
        interrupt();
        System.out.println(isInterrupted());
        // 返回线程的中断标识，同时清除标识
        System.out.println(Thread.interrupted());
        System.out.println(isInterrupted());
        System.out.println("收到中断");
      }
      System.out.println("running...");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    InterruptThread thread = new InterruptThread();
    thread.start();

    Thread.sleep(1000);

    thread.interrupt();
    System.out.println("中断");
    thread.isRun = false;

  }
}
