package club.banyuan.gnbs;

import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  // 正确的数字
  public static int correctNum;
  // 用户的每次的输入的记录
  private static final int[] log = new int[1000];
  // 用户输入的次数
  private static int inputTimes;
  // 用户总的输入次数
  private static int totalTimes;

  // 用户当前的输入数字
  private static int currentInput;

  // 等级的选择
  private static int level;

  // 控制菜单的flag选项
  private static final int MENU_LEVEL = 1;
  private static final int MENU_TIMES = 2;
  private static final int MENU_PLAY = 3;
  private static final int MENU_FINISH = 4;
  private static final int MENU_QUIT = 5;

  private static int flag = MENU_LEVEL;

  public static void main(String[] args) {
    while (true) {
      switch (flag) {
        case MENU_LEVEL:
          chooseLevel();
          break;
        case MENU_TIMES:
          chooseTimes();
          break;
        case MENU_PLAY:
          guessNum();
          break;
        case MENU_FINISH:
          printLog();
          break;
        case MENU_QUIT:
          System.out.println("游戏结束");
          return;
        default:
          break;
      }
    }
  }

  private static void printLog() {
    // 猜中了
    if (log[inputTimes - 1] == correctNum) {
      System.out.println("输入的是" + currentInput + "，恭喜你，猜中了");
    } else {
      System.out.println("没有猜到正确的结果");
    }
    System.out.println("猜题记录");
    //第1次 50 => -30
    // 第2次 70 => -10
    // 第3次 90 => +10
    // 第4次 80 => 正确
    for (int i = 0; i < inputTimes; i++) {
      System.out.println("第" + (i + 1) + "次 " + log[i] + " => " + (log[i] - correctNum));
    }
    String s;
    while (true) {
      System.out.println("是否继续，1.继续, 0. 退出");
      s = scanner.nextLine();
      if ("0".equals(s)) {
        flag = MENU_QUIT;
        break;
      } else if ("1".equals(s)) {
        flag = MENU_LEVEL;
        break;
      } else {
        System.out.println("输入不合法");
      }
    }
  }

  // 现在开始猜数
  // 剩余次数10，请输入数字（0~999）：5
  // 输入的是5，没有猜中，猜小了
  private static void guessNum() {
    // 开始猜数的时候，把之前输入的次数清零
    inputTimes = 0;
    Random random = new Random();
    correctNum = random.nextInt((int) Math.pow(10, level));
    System.out.println("现在开始猜数");
    int left = totalTimes - inputTimes;
    String levelMsg = "0~" + ((int) Math.pow(10, level) - 1);
    while (left > 0) {
      System.out.println("剩余次数" + left + ",请输入数字(" + levelMsg + "):");
      String s = scanner.nextLine();
      if (userInputNumInvalid(s)) {
        continue;
      }

      currentInput = Integer.parseInt(s);

      // 如果猜中了，退出循环，控制标识切换到结束状态
      if (correctNum == currentInput) {
        // 猜中了也需要记录log
        flag = MENU_FINISH;
        log[inputTimes] = currentInput;
        inputTimes++;
        break;
      } else {
        // 如果没猜中，输出信息，记录log
        log[inputTimes] = currentInput;
        inputTimes++;
        String guessMsg = currentInput > correctNum ? "大" : "小";
        System.out.println("输入的是" + currentInput + "，没有猜中，猜" + guessMsg + "了");
        // 修改条件用于退出循环
        left = totalTimes - inputTimes;
      }
    }
    // 循环结束，说明次数用光了，切换状态到结束
    flag = MENU_FINISH;
  }

  private static boolean userInputNumInvalid(String s) {
    if (isNotNumber(s)) {
      return true;
    }

    int num = Integer.parseInt(s);
    if (num < 0) {
      return true;
    }

    return num >= Math.pow(10, level);
  }

  private static void chooseTimes() {
    // 0 ~9
    // 0 ~99
    // 0 ~999
    String levelMsg = "0~" + ((int) Math.pow(10, level) - 1);
    // for (int i = 0; i < level; i++) {
    //   levelMsg += "9";
    // }

    // String level
    System.out.println("你当前选择的难度等级" + levelMsg + "\n"
        + "请输入想要猜的次数，0返回上一级\n"
        + "你的输入：");
    String input = scanner.nextLine();
    if (isNotNumber(input)) {
      System.out.println("输入不合法");
      return;
    }

    int inputTimes = Integer.parseInt(input);
    if (inputTimes < 0 || inputTimes > 1000) {
      System.out.println("输入不合法");
      return;
    }

    if (inputTimes == 0) {
      flag = MENU_LEVEL;
      return;
    }

    Main.totalTimes = inputTimes;
    flag = MENU_PLAY;
  }

  private static boolean isNotNumber(String input) {
    char[] chars = input.toCharArray();
    for (char aChar : chars) {
      if (aChar < '0' || aChar > '9') {
        return true;
      }
    }
    return false;
  }

  private static void chooseLevel() {
    System.out.println("请选择难度等级\n"
        + "1. 0~9\n"
        + "2. 0~99\n"
        + "3. 0~999\n"
        + "0. 退出");
    String input = scanner.nextLine();
    switch (input) {
      case "1":
      case "2":
      case "3":
        level = Integer.parseInt(input);
        flag = MENU_TIMES;
        break;
      case "0":
        flag = MENU_QUIT;
        break;
      default:
        System.out.println("输入不合法，请重新输入");
        break;
    }


  }
}
