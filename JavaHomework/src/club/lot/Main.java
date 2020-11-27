package club.lot;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String s = scanner.nextLine();
      if ("0".equals(s)) {
        System.out.println("谢谢使用");
        return;
      }
      System.out.println(BoxRefine.draw());
    }
  }
}
