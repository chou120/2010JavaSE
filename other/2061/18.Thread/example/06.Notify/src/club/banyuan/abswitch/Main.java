package club.banyuan.abswitch;

public class Main {

  public static void main(String[] args) {
    PrintAThread printAThread = new PrintAThread();
    PrintBThread printBThread = new PrintBThread();

    printAThread.start();
    printBThread.start();
  }
}
