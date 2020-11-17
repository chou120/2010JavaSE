package club.banyuan.oop.question;

import club.banyuan.oop.Hammer;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 5:23 下午
 */
public class Test1 {

  public static void main(String[] args) {

    Hammer hammer = new Hammer();
    hammer.setPrice(213);

    Hammer hammer1 ;
    hammer1=hammer;
    hammer1.setPrice(7);

    System.out.println(hammer1.getInfo()+"\n"+hammer.getInfo());


  }

}
