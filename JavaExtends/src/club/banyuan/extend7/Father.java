package club.banyuan.extend7;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 1:36 下午
 */
public class Father {

  /**
   * 方法重写的注意事项 父类中私有方法不能被重写 子类重写父类方法时，访问权限不能更低 父类静态方法，子类也必须通过静态方法进行重写。(其实这个算不上方法重写，但是现象确实如此，至于为什么算不上方法重写，多态中我会讲解)
   * Public   默认(不写)  protected   private
   */

  static int i = 0;

  private String getInfo1() {
    System.out.println("父类私有化的方法...");
    return "";
  }

  void getInfo2() {
    System.out.println("父类默认的方法...");
  }

  protected void getInfo3() {
    System.out.println("父类protected的方法...");
  }

  public static void method() {
    System.out.println("这是父类的静态方法...." + i);
  }


}

class Son extends Father {


  public String getInfo1() {
    System.out.println("子类私有化的方法...");
    return "";
  }

  @Override
  void getInfo2() {
    System.out.println("zi类默认的方法...");
  }

  @Override
  protected void getInfo3() {
    System.out.println("zi类protected的方法...");
  }

  public static void method() {
    System.out.println("这是zi类的静态方法...." + (i++));
  }

  //属于的各自的class文件

}

class Test {

  public static void main(String[] args) {
    Son son = new Son();
    son.getInfo3();
    son.method(); //
    Father.method();



  }
}