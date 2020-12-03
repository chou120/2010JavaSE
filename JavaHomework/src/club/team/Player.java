package club.team;

import java.util.Objects;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/3 1:39 下午
 */
public class Player {

  private  String name;
  private  Integer number;
  private  String  position;

  public Player(String name, Integer number, String position) {
    this.name = name;
    this.number = number;
    this.position = position;
  }

  public Player() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", number=" + number +
        ", position='" + position + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name) &&
        Objects.equals(number, player.number) &&
        Objects.equals(position, player.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, number, position);
  }
}
