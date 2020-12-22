public class Son extends Father {

  public String field = "son";

  public String getFatherField() {
    String field = "local";
    System.out.println(this.field);
    return super.field;
  }

  public void method() {
    System.out.println("son method");
  }

  // 子类的实例方法内部，使用super访问父类中定义的成员变量和方法
  public void callFatherMethod() {
    method(); // 子类中定义的
    super.method(); // 父类中定义的
  }

  public Son getSon() {
    return this;
  }

  // public Father getFather() {
    // super并不是一个父类对象的引用。
    // 只是用来在子类内部区分父类中定义的成员和方法
    // return super; // 编译报错
  // }

  public static void main(String[] args) {
    Son son = new Son();
    System.out.println(son.field);
    // System.out.println(super.field);
  }
}
