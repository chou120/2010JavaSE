package club.banyuan.doc_15_4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 9:31 上午
 */
public class Employee extends Role {

  private double salary;
  private static int ID;

  private String name="万股为";

  public Employee() {
  }

  public Employee(String name, int age, char sex, double salary) {
    super(name, age, sex);
    this.salary = salary;
  }
  @Override
  public String getName() {
    return name;
  }
  @Override
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public void play() {
    System.out.println(super.getName());
  }

  public final  void  sing(){

  }


}
