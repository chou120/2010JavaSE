package club.banyuan;

// 可以通过子类对象或子类类名访问父类中定义的静态方法和成员
// 子类可以覆盖父类的静态内容，定义同名的方法或成员。可以使用父类名称进行引用
public class Son extends Father {

  public static String fatherField = "sonField";

  static {
    System.out.println("son static block"); // 1
  }

  {
    System.out.println("son instance block"); // 2
  }

  public static void staticMethod(){
    Father.staticMethod();
    System.out.println("static son method");
  }

  public static void main(String[] args) {
    // System.out.println(fatherField);
    // System.out.println(Son.fatherField);
    // System.out.println(Father.fatherField);
    // staticMethod();
    // 所有的类先加载，优先加载父类，加载完成后，从父类开始执行构造方法进行初始化
    Son son = new Son(); // 3 1 4 2
  }
}
