package club.banyuan.gamePhoy;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 3:36 下午
 */
public  abstract class Weapon {
  private String name;//武器的名字
  private String teture;//材质

  public String getTeture() {
    return teture;
  }

  public void setTeture(String teture) {
    this.teture = teture;
  }

  public Weapon() {
  }
  public Weapon(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


//抽象方法
  public  abstract void attack(Fighter fighter1, Fighter fighter2);
  //{  //一个回合的
//    int attack = fighter1.attack();
//    int hp = fighter2.getHp();
//    hp = hp - attack;
//    fighter2.setHp(hp);
//    System.out
//        .println(fighter1.getName() + "向" + fighter2.getName() + "发起了攻击,造成的伤害为:" + attack + ","
//            + fighter2.getName() + "还剩下的血量为:" + fighter2.getHp()+"......");
//  }

  //武器都有重新铸造的行为
 public abstract void  reset(String   caizhi);
//  {
//      this.teture=caizhi;
//    System.out.println("哈哈是");
//  }

}
