package club.banyuan.fg;

import java.util.Scanner;

public class MainRefine {

  // 出拳类型
  // 剪刀
  public static final String FINGER_TYPE_SCISSOR = "1";
  // 石头
  public static final String FINGER_TYPE_STONE = "2";
  // 布
  public static final String FINGER_TYPE_FABRIC = "3";

  public static final int USER_TYPE_HUMAN = 1;
  public static final int USER_TYPE_COMPUTER = 2;

  // 猜拳人数
  public static int playerCount;

  // 玩家列表
  public static Player[] players;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("请输入参与猜拳人数（2~5人），输入0退出");
      System.out.println("你的输入：");
      String input = scanner.nextLine();
      switch (input) {
        case "0":
          System.out.println("程序退出");
          return;
        case "2":
        case "3":
        case "4":
        case "5":
          initPlayerList(input);
          fingerGuess();
          break;
        default:
          System.out.println("输入不合法，请重新输入！");
          break;
      }
    }
  }

  private static void initPlayerList(String playerCount) {
    MainRefine.playerCount = Integer.parseInt(playerCount);
    players = new Player[MainRefine.playerCount];
    players[0] = new Player(1, USER_TYPE_HUMAN);
    for (int i = 1; i < players.length; i++) {
      players[i] = new Player(i, USER_TYPE_COMPUTER);
    }
  }

  // 循环直到1人胜出，如果有人胜出，就打印胜出玩家的信息
  // 当前未被淘汰的人依次出拳，比较当前这一轮的人的出拳结果，输出信息，然后修改玩家是否被淘汰的状态
  private static void fingerGuess() {
    System.out.println("======猜拳开始=======");
    Player winner = getWinner();
    if (winner != null) {
      System.out.println(winner.getUserTypeName() + winner.getId() + "获胜！");
    } else {
      // 如果没有玩家胜出，则开始出拳并比较
      setPlayersFinger();
      String allFinger = getFingerResult();
      // 玩家出拳平局
      if (allFinger.length() == 1 || allFinger.length() == 3) {
        printUserDrawState();
      } else {
        // 玩家出拳有胜出，有淘汰
        String winnerFinger = getWinnerFinger(allFinger);
        printAndSetPlayerOutState(winnerFinger);
      }
      // 递归调用，直到玩家剩一人未被淘汰
      fingerGuess();
    }
  }

  private static void printUserDrawState() {
    for (Player player : players) {
      if (!player.isOut) {
        System.out.println(player.getFingerTypeInfo() + ",平局");
      }
    }
  }

  private static void printAndSetPlayerOutState(String winnerFinger) {
    for (Player player : players) {
      if (!player.isOut) {
        if (player.getFingerType().equals(winnerFinger)) {
          System.out.println(player.getFingerTypeInfo() + "，获胜");
        } else {
          System.out.println(player.getFingerTypeInfo() + "，淘汰");
          player.setOut(true);
        }
      }
    }
  }

  private static String getWinnerFinger(String allFinger) {
    switch (allFinger) {
      // 剪刀和石头，最后2胜出
      case "12":
      case "21":
        return FINGER_TYPE_STONE;
      // 剪刀和布，最后1胜出
      case "13":
      case "31":
        return FINGER_TYPE_SCISSOR;
      // 石头和布，最后3胜出
      case "23":
      case "32":
        return FINGER_TYPE_FABRIC;
    }
    return "";
  }

  private static String getFingerResult() {
    String allFinger = "";
    for (Player player : players) {
      if (!player.isOut) {
        String fingerType = player.getFingerType();
        if (!allFinger.contains(fingerType)) {
          allFinger += fingerType;
        }
      }
    }
    return allFinger;
  }

  private static void setPlayersFinger() {
    for (Player player : players) {
      if (!player.isOut) {
        player.showFinger();
      }
    }
  }

  /**
   * 如果玩家列表中，只有一个未被淘汰，返回这个玩家的对象，否则返回null
   *
   * @return
   */
  private static Player getWinner() {
    int playerLeft = 0;
    Player winner = null;
    for (Player player : players) {
      if (!player.isOut) {
        playerLeft++;
        winner = player;
      }
    }
    if (playerLeft == 1) {
      return winner;
    } else {
      return null;
    }
  }

}
