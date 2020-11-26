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
public class Rabbit  extends  Animal implements  OtherBuff{

  @Override
  public  void  eat(){
    System.out.println("mu兔子吃萝卜方法...");
  }

  @Override
  public void daDong() {
    System.out.println("兔子打洞...");
  }

}

