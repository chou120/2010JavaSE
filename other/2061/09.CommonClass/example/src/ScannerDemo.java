import java.util.Scanner;

public class ScannerDemo {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 阻塞，直到键盘输入内容，然后返回true
    while (scanner.hasNext()) {
      System.out.println("键盘有输入");
      // 接收键盘的缓冲区的数据，读取数据直到换行符
      // String next = scanner.nextLine();
      // String next = scanner.next();
      int next = scanner.nextInt();
      System.out.println("输入内容:" + next);
      // if (next.equals("quit")) {
      //   System.out.println("程序退出！");
      //   break;
      // }
      if(next == 10){
        System.out.println("程序退出");
        break;
      }
    }


  }
}
