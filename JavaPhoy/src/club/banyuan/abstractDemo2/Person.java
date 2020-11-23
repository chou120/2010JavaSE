package club.banyuan.abstractDemo2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 5:19 下午
 */
public abstract class Person {

  public  abstract  void  method();

 // private  abstract  void login();
 // public   abstract  static  void  method2();
  //以上两个用法不对
  protected  abstract  void login();
  abstract   void  method2();


}

class Son  extends  Person{

  @Override
  public void method() {

  }

  @Override
  protected void login() {

  }

  @Override
  public  void method2() {

  }
}
