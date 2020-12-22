package club.banyuan;

import java.util.Scanner;

public class ScanInput {

  private static Scanner scanner = new Scanner(System.in);

  // // 从键盘接收一个数据，根据用户的检查来判断数据是否合法
  // public static String scanInput(检测输入是否合法的方法，如果不合法你应该怎么做) {
  //   String s = scanner.nextLine();
  //   boolean isValid = 检测输入是否合法的方法(s);
  //   if (isValid) {
  //     return s;
  //   } else {
  //     如果不合法你应该怎么做();
  //   }
  // }

  // 从键盘接收一个数据，根据用户的检查来判断数据是否合法

  // 回调 callback
  public static String scanInput(ScannerRule scannerRule) {
    String s = scanner.nextLine();
    boolean isValid = scannerRule.validate(s);
    if (isValid) {
      return s;
    } else {
      scannerRule.doWhenError();
      return scanInput(scannerRule);
    }
  }
}
