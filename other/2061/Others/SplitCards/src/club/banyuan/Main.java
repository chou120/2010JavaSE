package club.banyuan;

import java.util.Arrays;
import java.util.Random;

public class Main {

  public static final String[] PATTERN = {"♥", "♠", "♦", "♣"};
  public static final String[] FACE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
      "K"};

  public static void main(String[] args) {
    Card[] cards = new Card[54];
    int count = 0;

    for (String pattern : PATTERN) {
      for (String face : FACE) {
        Card card = new Card(pattern, face);
        cards[count++] = card;
      }
    }

    cards[52] = new Card("大王");
    cards[53] = new Card("小王");

    System.out.println(Arrays.toString(cards));

    Random random = new Random();
    int length = cards.length;
    while (length > 0) {
      int index = random.nextInt(length);
      length--;
      Card temp = cards[index];
      cards[index] = cards[length];
      cards[length] = temp;
    }

    // Player[] players = new Player[]{new Player("玩家1", Arrays.copyOf(cards, 17)),
    //     new Player("玩家2", Arrays.copyOfRange(cards, 17, 34)),
    //     new Player("玩家3", Arrays.copyOfRange(cards, 34, 51)),
    //     new Player("底牌", Arrays.copyOfRange(cards, 51, 54)),
    // };

    int interval = 17;
    int playerCont = 0;

    Player[] players = new Player[]{
        new Player("玩家1", Arrays.copyOfRange(cards, playerCont * interval,
            Math.min((playerCont++ + 1) * interval, cards.length))),
        new Player("玩家2",
            Arrays.copyOfRange(cards, playerCont * interval,
                Math.min((playerCont++ + 1) * interval, cards.length))),
        new Player("玩家3",
            Arrays.copyOfRange(cards, playerCont * interval,
                Math.min((playerCont++ + 1) * interval, cards.length))),
        new Player("底牌",
            Arrays.copyOfRange(cards, playerCont * interval,
                Math.min((playerCont++ + 1) * interval, cards.length))),
    };

    for (Player player : players) {
      System.out.println(player);
    }

    // System.out.println(Arrays.toString(players));

  }
}
