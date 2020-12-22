package club.banyuan;

import java.util.Objects;

public class Player {

  private String name;
  private Position position;
  private int num;

  public Player() {
  }

  public Player(String name, Position position) {
    this.name = name;
    this.position = position;
  }

  public Player(String name, Position position, int num) {
    this.name = name;
    this.position = position;
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  public String toString() {
    // return "Player{" +
    //     "name='" + name + '\'' +
    //     ", position=" + position +
    //     ", num=" + num +
    //     '}';

    return "姓名：" + name + ",位置:" + position + ",号码:" + num;
  }

}
