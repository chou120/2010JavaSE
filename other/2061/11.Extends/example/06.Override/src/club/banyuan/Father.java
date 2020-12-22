package club.banyuan;

// overload 重载，用来声明相同名称的方法
// override 重写，子类中定义和父类同名的方法
public class Father {

  public void method() {
    System.out.println("father method");
  }

  private void privateMethod() {
    System.out.println("father method");
  }

}
