package club.banyuan.fighter;

import club.banyuan.fighter.weapon.Weapon;
import java.util.Random;

public class Fighter {

  private Random random = new Random();

  private int hp = 1000;
  private String name;
  private Weapon weapon;

  public Fighter(String name) {
    this.name = name;
  }

  public Fighter(String name, Weapon weapon) {
    this.name = name;
    this.weapon = weapon;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void attack(Fighter fighter) {

    weapon.attack(this, fighter);
    // int attack = random.nextInt(100) + 100;
    // fighter.hp -= attack;
    // System.out
    //     .println(name + "向" + fighter.getName() + "发起攻击," + attack + "，剩余血量：" + fighter.getHp());
  }
  public int attack() {
    return random.nextInt(100) + 100;
  }
}
