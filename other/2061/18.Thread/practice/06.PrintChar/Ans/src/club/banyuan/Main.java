package club.banyuan;

public class Main {

  public static final Object LOCK = new Object();

  public static void main(String[] args) {
    LetterThread t1 = new LetterThread();
    NumThread t2 = new NumThread();
    t2.start();
    t1.start();
  }
}
