package club.banyuan.staticDemo11;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 11:07 上午
 */
public class Worker {

  /**
   * static 关键字   1.通过类名.静态方法  可以直接调用该方法 2.静态的只能访问静态的成员,不能访问非静态的成员 非静态的成员可以任意访问
                    3.static 修饰的属性 被所有的对象共享 以最终的修改之后的数据为结果
   */
  private String name = "站感受";
  private static String country = "中国";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static String getCountry() {
    return country;
  }

  public static void setCountry(String country) {
    Worker.country = country;
  }

  public void method1() {
    System.out.println("非静态方法..." + name + "," + country);
  }
//  public static void   method2(){
//    System.out.println("静态方法..."+country);
//  }


  @Override
  public String toString() {
    return "Worker{" +
        "name='" + name + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
