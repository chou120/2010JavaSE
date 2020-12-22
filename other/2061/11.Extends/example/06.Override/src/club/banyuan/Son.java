package club.banyuan;

public class Son extends Father {

  // 方法重载
  public void method(String str) {
    System.out.println("son method");
  }

  // public void method() {
  //   System.out.println("son method");
  // }

  // 注解，用来标识重写方法的
  @Override
  public void method() {
    System.out.println("son method");
  }

  private void privateMethod() {
    System.out.println("son private method");
  }

  public static void main(String[] args) {
    Son son = new Son();
    son.method();
  }


}
