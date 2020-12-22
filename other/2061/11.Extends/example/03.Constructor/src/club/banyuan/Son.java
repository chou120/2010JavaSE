package club.banyuan;

public class Son extends Father {

  private String sonField;

  // 父类构造方法先于子类构造方法执行
  public Son() {
    this("123");
    System.out.println("子类无参的构造方法");
  }

  public Son(String sonField) {
    // this();
    // 使用super显式指定调用哪个父类的构造方法
    // super必须出现在构造方法中的第一句话，super()只能出现在构造方法中
    super(sonField);
    this.sonField = sonField;
  }

  public static void main(String[] args) {
    // 创建子类对象时，一定会调用父类的构造方法
    // 默认会调用父类无参的构造方法，如果父类中没有无参的构造方法，则会编译报错。
    // Son son = new Son("1234");
    Son son = new Son();
  }
}
