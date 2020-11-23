package club.banyuan.playJoker;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 10:13 上午
 */
public class Player {

  private  String name;
  private  boolean flag;
  private  String [] jokers;

  //添加牌的方法
  public void  addJoker(String joker){
    jokers=Arrays.copyOf(jokers, jokers.length+1);
    jokers[jokers.length-1]=joker;
  }
  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", flag=" + flag +
        ", jokers=" + Arrays.toString(jokers) +
        '}';
  }

  public Player() {
    jokers=new String[0];//初始化数组
  }

  public Player(String name, boolean flag, String[] jokers) {
    this.name = name;
    this.flag = flag;
    this.jokers = jokers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public String[] getJokers() {
    return jokers;
  }

  public void setJokers(String[] jokers) {
    this.jokers = jokers;
  }
}
