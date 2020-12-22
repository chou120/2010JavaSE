package club.banyuan.abcswitch;

public class Main {

  public static void main(String[] args) {
    PrintAThread printAThread = new PrintAThread();
    PrintBThread printBThread = new PrintBThread();
    PrintCThread printCThread = new PrintCThread();

    printAThread.start();
    printBThread.start();
    printCThread.start();
  }
}
