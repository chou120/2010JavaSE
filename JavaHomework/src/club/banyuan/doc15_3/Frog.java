package club.banyuan.doc15_3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:05 上午
 */

/**
 * 1.编写程序描述兔子和青蛙
 * 			需求说明：使用面向对象的思想，设计自定义类描述兔子和青蛙
 */
public class Frog  extends  Animal implements  FrogOtherBuff{

  @Override
  public void eat() {
    System.out.println("青蛙吃害虫...");
  }

  @Override
  public   void   run(){
    System.out.println("青蛙运动...");
  }

}

