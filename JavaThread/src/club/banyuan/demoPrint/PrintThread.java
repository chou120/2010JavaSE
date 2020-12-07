package club.banyuan.demoPrint;

import java.util.List;

public class PrintThread extends Thread {

  private  List<String>  list;  //how  are  you

  public PrintThread(List<String> list) {
    this.list = list;
  }

  @Override
  public void run() {
    for (String s : list) {
      System.out.print(s+"\t");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println();
  }
}
