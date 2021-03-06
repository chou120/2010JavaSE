package club.banyuan.cal;

import java.util.Scanner;

public class MainRefine {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 1 + 1
    // while (true) {
    String s = scanner.nextLine();
    // asd 输入不合法
    // 1 + a 操作数不合法
    // 1 a 2 操作符不合法
    while (true) {
      try {
        validate(s);
        break;
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("请重新输入");
        s = scanner.nextLine();
      }
    }

    System.out.println(add(s));
    // }

  }

  private static void validate(String s) {
    String[] split = s.split(" ");
    if (split.length != 3) {
      throw new IllegalArgumentException("输入不合法"); // 抛出异常
    } else if (!isNumber(split[0]) || !isNumber(split[2])) {
      throw new IllegalArgumentException("操作数不合法");
    } else if (!"+".equals(split[1])) {
      throw new IllegalArgumentException("操作符不合法");
    }
    System.out.println("validate ok");
  }

  // 引入异常机制，告知调用方方法调用是正常结束还是出现异常
  // 将正常的业务代码和处理异常的代码分开。
  private static String add(String s) {
    String[] split = s.split(" ");
    return Integer.parseInt(split[0]) + Integer.parseInt(split[2]) + "";
  }

  private static boolean isNumber(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char aChar = chars[i];
      if (i == 0 && aChar == '-') {
        continue;
      }
      if ('0' > aChar || '9' < aChar) {
        return false;
      }
    }
    // for (char aChar : chars) {
    //   if ('0' > aChar || '9' < aChar) {
    //     return false;
    //   }
    // }

    return true;
  }
}
