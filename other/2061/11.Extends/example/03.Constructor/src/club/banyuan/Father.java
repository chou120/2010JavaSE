package club.banyuan;

public class Father {

  private String fatherField;

  // public Father() {
  //   System.out.println("父类无参的构造方法");
  // }

  public Father(String fatherField) {
    this.fatherField = fatherField;
    System.out.println("父类带有参数的构造方法");
  }
}
