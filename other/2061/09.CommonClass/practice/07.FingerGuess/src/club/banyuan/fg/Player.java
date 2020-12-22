package club.banyuan.fg;

import java.util.Random;
import java.util.Scanner;

public class Player {

  // 每人的出拳
  private String fingerType;
  // 每人是否被淘汰
  boolean isOut;
  // 玩家编号
  private int id;

  // 1 玩家  2 机器人
  private int userType;

  public Player(int id, int userType) {
    this.id = id;
    this.userType = userType;
  }

  public String getFingerType() {
    return fingerType;
  }

  public void setFingerType(String fingerType) {
    this.fingerType = fingerType;
  }

  public boolean isOut() {
    return isOut;
  }

  public void setOut(boolean out) {
    isOut = out;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserType() {
    return userType;
  }

  public String getUserTypeName() {
    if (userType == Main.USER_TYPE_HUMAN) {
      return "玩家";
    } else {
      return "电脑";
    }
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public void showFinger() {
    // 玩家
    if (userType == 1) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("请出拳，1.剪刀  2.石头  3.布");
      System.out.println("你的输入：");
      String s = scanner.nextLine();
      switch (s) {
        case "1":
        case "2":
        case "3":
          fingerType = s;
          break;
        default:
          System.out.println("输入错误，请重新输入！");
          showFinger();
      }
    } else {
      Random random = new Random();
      fingerType = random.nextInt(3) + 1 + "";
    }
  }

  public String getFingerTypeName() {
    switch (fingerType) {
      case "1":
        return "剪刀";
      case "2":
        return "石头";
      case "3":
        return "布";
    }
    return "";
  }

  public String getFingerTypeInfo() {
    return getUserTypeName() + id + "出了" + getFingerTypeName();
  }
}
