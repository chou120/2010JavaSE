package club.banyuan.game;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 4:00 下午
 */
public class TestGane {


  public static void main(String[] args) {
    SpearWeapon spearWeapon = new SpearWeapon();
     HalberdWeapon halberdWeapon = new HalberdWeapon();

    Fighter fighter1 = new Fighter("张飞", spearWeapon);
    Fighter fighter2 = new Fighter("吕布", halberdWeapon);

   while (fighter1.getHp()>0 && fighter2.getHp()>0){
     fighter1.attack(fighter2);
     fighter2.attack(fighter1);
   }






   if(fighter1.getHp()<0){

   }else{

   }





  }

}
