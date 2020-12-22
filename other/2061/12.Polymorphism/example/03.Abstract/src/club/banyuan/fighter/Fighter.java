package club.banyuan.fighter;

import club.banyuan.fighter.weapon.AbstractWeapon;
import java.util.Random;

public class Fighter {

  private Random random = new Random();

  private int hp = 1000;
  private String name;
  private AbstractWeapon abstractWeapon;
  private int armor = 200;

  public Fighter(String name) {
    this.name = name;
  }

  public Fighter(String name, AbstractWeapon abstractWeapon) {
    this.name = name;
    this.abstractWeapon = abstractWeapon;
  }

  public int getArmor() {
    return armor;
  }

  public void setArmor(int armor) {
    this.armor = armor;
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

    abstractWeapon.attack(this, fighter);
    // int attack = random.nextInt(100) + 100;
    // fighter.hp -= attack;
    // System.out
    //     .println(name + "向" + fighter.getName() + "发起攻击," + attack + "，剩余血量：" + fighter.getHp());
  }

  public int attack() {
    return random.nextInt(100) + 100;
  }

  /**
   * @param hurt 受到的伤害
   * @return 真实受到的伤害值，被护甲抵消
   */
  public int hurt(int hurt) {
    int realHurt = (int) (hurt - armor * 0.5);
    System.out.println("护甲抵消：" + (hurt - realHurt));
    System.out.println("受到伤害:" + realHurt);
    hp -= realHurt;
    return realHurt;
  }
}
