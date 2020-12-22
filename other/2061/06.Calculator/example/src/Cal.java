import java.util.Scanner;

public class Cal {

  public static void main(String[] args) {
    while (true) {
      System.out.println("要进行哪种运算？\n"
          + "1.加法\n"
          + "2.减法\n"
          + "3.乘法\n"
          + "4.除法\n"
          + "5.退出");
      int input = scanInt("请输入：");
      System.out.println("输入的内容是:" + input);
      switch (input) {
        case 1:
          // 加法
          System.out.println("加法流程");
          // 接收用户的第一个操作数

          int a = scanInt("请输入第一个操作数:");

          // 请输入第一个操作数:
          int b = scanInt("请输入第二个操作数:");
          // 接收用户的第二个操作数
          // 请输入第二个操作数:
          //System.out.println(a+b);
          // 将两个操作数相加，并且输出结果
          // 1 + 2 = \
          int c = a + b;
          System.out.println(a + "+" + b + "=" + c);
          System.out.printf("%d + %d = %d", a, b, c);
          break;
        case 2:
          System.out.println("减法流程");
          // 减法

          break;
        case 3:
          System.out.println("乘法流程");
          // 乘法
          break;
        case 4:
          System.out.println("除法流程");
          // 除法
          break;
        case 5:
          // TODO 5替换成取余操作 %
          // 退出
          System.out.println("程序退出，谢谢使用！");
          return;
        // TODO 6 退出程序
        default:
          System.out.println("输入不合法");
          break;
      }
    }

  }


  public static int scanInt(String msg) {
    System.out.println(msg);
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      System.out.println("输入不合法，请重新输入！");
      return scanInt(msg);
    }
  }
}
