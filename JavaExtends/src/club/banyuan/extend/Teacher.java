package club.banyuan.extend;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 9:18 上午
 */
public class Teacher extends Person {

  private double salary;

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }


  //方法重写: 当父类的功能不能满足子类的需求,这个时候子类就需要对父类的方法进行重写
  @Override
  public String toString() {
    return "Teacher{" +
        "salary=" + salary +
        '}';
  }

  //子类特有的方法
  public   void  paoniu(){
    System.out.println("子类有泡妞的功能...");
  }


}
