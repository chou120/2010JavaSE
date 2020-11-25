package club.banyuan.check;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 10:10 上午
 */
public class XiaoMing {

  private String name;
  private String address;
  private int age;

  //省略set/get方法

  @Override
  public String toString() {
    return "XiaoMing{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", age=" + age +
        '}';
  }
}
