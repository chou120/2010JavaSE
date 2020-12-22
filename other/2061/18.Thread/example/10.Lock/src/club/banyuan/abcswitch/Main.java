package club.banyuan.abcswitch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

  public static void main(String[] args) {

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    PrintAThread printAThread = new PrintAThread(lock, a, b);
    PrintBThread printBThread = new PrintBThread(lock, b, c);
    PrintCThread printCThread = new PrintCThread(lock, c, a);

    printAThread.start();
    printBThread.start();
    printCThread.start();
  }
}
