package club.banyuan;

import java.util.Scanner;

public class RentScanner {

  public static final Scanner scanner = new Scanner(System.in);

  public static int getYear() {
    System.out.println("请输入车辆年份(4位数年份)：");
    String s = scanner.nextLine();
    try {
      int year = Integer.parseInt(s);
      if (year >= 9999 || year <= 1000) {
        System.out.println("输入不合法");
        return getYear();
      }
      return year;
    } catch (NumberFormatException e) {
      System.out.println("输入不合法");
      return getYear();
    }
  }

  public static int getInt(String message) {
    System.out.println(message);
    String s = scanner.nextLine();
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      System.out.println("输入不合法");
      return getInt(message);
    }
  }

  public static int getInt() {
    String s = scanner.nextLine();
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      System.out.println("输入不合法");
      return getInt();
    }
  }
}
