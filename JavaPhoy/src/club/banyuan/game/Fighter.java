package club.banyuan.game;

import java.util.Random;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 3:37 下午
 */
public class Fighter {

  private String name;
  private int hp = 1000; //生命值
  private Weapon weapon;

  private Random  random=new Random();

  public Fighter() {

  }
  public Fighter(String name,  Weapon weapon) {
    this.name = name;
    this.weapon = weapon;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  //攻击方法
  public void attack(Fighter fighter) {
    weapon.attack(this, fighter);
  }

  //自身攻击伤害(随机100到200之间的攻击力)
  public int attack() {
      return  random.nextInt(100)+100;
  }
}
