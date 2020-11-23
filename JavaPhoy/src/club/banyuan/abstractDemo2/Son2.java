package club.banyuan.abstractDemo2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 5:22 下午
 */
public abstract class Son2  extends  Person{

  public  abstract  void login();

  @Override
  public void method() {

  }
}


class   GrandSon  extends   Son2{

  @Override
  public void login() {

  }

  @Override
  public void method() {

  }

  @Override
  void method2() {

  }
}