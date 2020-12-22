package club.banyuan;

public class Card {

  private String pattern;
  private String face;
  private String joker;

  public Card(String pattern, String face) {
    this.pattern = pattern;
    this.face = face;
  }

  public Card(String joker) {
    this.joker = joker;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }

  public String getJoker() {
    return joker;
  }

  public void setJoker(String joker) {
    this.joker = joker;
  }

  @Override
  public String toString() {
    if (joker != null) {
      return joker;
    } else {
      return pattern + face;
    }
  }
}
