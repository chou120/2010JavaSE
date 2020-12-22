package club.banyuan;

import java.util.Arrays;

public class Player {

  private String num;
  private Card[] cards;

  public Player(String num, Card[] cards) {
    this.num = num;
    this.cards = cards;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public Card[] getCards() {
    return cards;
  }

  public void setCards(Card[] cards) {
    this.cards = cards;
  }

  @Override
  public String toString() {
    return num + ":" + Arrays.toString(cards);
  }
}
