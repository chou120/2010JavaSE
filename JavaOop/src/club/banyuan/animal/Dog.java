package club.banyuan.animal;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 2:51 下午
 */
public class Dog {

  private  String  dogName="二哈";
  int    age;
  protected  String  color;
  public  String  type;//品种

  //还有在上继承的是补上

  private  void run(){
    System.out.println("这是dog的私有化run方法"+dogName);
  }

  void   bark(){
    //run();
    System.out.println("这是dog的默认的bark方法");
  }

  public  void   eat(){
    System.out.println("这是dog的public的eat方法");
  }

  protected String  killHome(){
    System.out.println("这是dog的protected的拆家方法");
    return "拆家";
  }

}

class DogMom{


}