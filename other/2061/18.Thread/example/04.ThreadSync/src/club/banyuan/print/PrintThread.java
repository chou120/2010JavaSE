package club.banyuan.print;

public class PrintThread extends Thread {

  private PrintString printString;

  public PrintThread(PrintString printString) {
    this.printString = printString;
  }

  public PrintString getPrintString() {
    return printString;
  }

  public void setPrintString(PrintString printString) {
    this.printString = printString;
  }

  @Override
  public void run() {
    try {
      printString.print();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
