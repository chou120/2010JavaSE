package club.banyuan.doc15_3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:17 上午
 */
public class MaleRabbit  extends Animal implements  OtherBuff {

  @Override
  public void eat() {
    System.out.println("公兔子....");
  }

  @Override
  public void daDong() {
    System.out.println("用嘴巴搬运泥土");
  }
}

class  Test{

  public static void main(String[] args) {
    Animal  animal=new Rabbit();
   // animal=new MaleRabbit();
    animal.eat();

  }
}