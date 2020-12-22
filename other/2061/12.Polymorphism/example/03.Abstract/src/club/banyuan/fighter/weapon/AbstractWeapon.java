package club.banyuan.fighter.weapon;

import club.banyuan.fighter.Fighter;

public abstract class AbstractWeapon {

  protected String name;

  // 因为抽象类中可以定义成员变量，因此抽象类的构造方法用来对这些变量进行初始化
  public AbstractWeapon(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract void attack(Fighter from, Fighter to);
}
