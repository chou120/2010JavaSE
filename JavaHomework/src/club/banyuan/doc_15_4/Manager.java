package club.banyuan.doc_15_4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:34 上午
 */
public class Manager extends Employee {

  private final String vehicle = "三轮";


  public static void main(String[] args) {
    Role role = new Employee();
    role.setName("张三");  //

    System.out.println(role.getName());
    role.play();
  }

}
