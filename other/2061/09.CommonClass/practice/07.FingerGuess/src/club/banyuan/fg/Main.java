package club.banyuan.fg;

import java.util.Scanner;

public class Main {

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
    Main.playerCount = Integer.parseInt(playerCount);
    players = new Player[Main.playerCount];
    players[0] = new Player(1, USER_TYPE_HUMAN);
    for (int i = 1; i < players.length; i++) {
      players[i] = new Player(i, USER_TYPE_COMPUTER);
    }
  }

  // 循环直到1人胜出，如果有人胜出，就打印胜出玩家的信息
  // 当前未被淘汰的人依次出拳，比较当前这一轮的人的出拳结果，输出信息，然后修改玩家是否被淘汰的状态
  private static void fingerGuess() {
    System.out.println("======猜拳开始=======");
    int playerLeft = 0;
    Player winner = null;
    for (Player player : players) {
      if (!player.isOut) {
        playerLeft++;
        winner = player;
      }
    }

    if (playerLeft == 1) {
      System.out.println(winner.getUserTypeName() + winner.getId() + "获胜！");
      return;
    } else {
      for (Player player : players) {
        if (!player.isOut) {
          player.showFinger();
        }
      }

      String allFinger = "";
      for (Player player : players) {
        if (!player.isOut) {
          String fingerType = player.getFingerType();
          if (!allFinger.contains(fingerType)) {
            allFinger += fingerType;
          }
        }
      }

      if (allFinger.length() == 1 || allFinger.length() == 3) {
        for (Player player : players) {
          if (!player.isOut) {
            System.out.println(player.getFingerTypeInfo() + ",平局");
          }
        }
      } else {
        String winnerFinger = "";
        switch (allFinger) {
          // 剪刀和石头，最后2胜出
          case "12":
          case "21":
            winnerFinger = FINGER_TYPE_STONE;
            break;
          // 剪刀和布，最后1胜出
          case "13":
          case "31":
            winnerFinger = FINGER_TYPE_SCISSOR;
            break;
          // 石头和布，最后3胜出
          case "23":
          case "32":
            winnerFinger = FINGER_TYPE_FABRIC;
            break;
        }

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
      fingerGuess();
    }
  }

}
