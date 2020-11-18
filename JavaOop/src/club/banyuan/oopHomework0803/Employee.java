package club.banyuan.oopHomework0803;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:55 上午
 */
public class Employee {

  private double hours;
  private String name;
  private double baseSalary = 5000;

  public double getHours() {
    return hours;
  }

  //设置工作时间
  public void setHours(double hours) {
    this.hours = hours;
  }

  //  方法：
//      1. 设置工作的时长
//   2. 计算工资的方法：
//  当每月工作的小时数超过196 小时时，超出的部分按每小时200 元。
//  基本工资+（工作的小时-196）*200。
  /*public   double  checkMoney(){
    if(this.hours<=196){
      return  this.baseSalary;
    }else  if(this.hours>196){
     return this.baseSalary=this.baseSalary+(this.hours-196)*200;
    }else {
      return this.baseSalary;
    }
  }
*/
  public void checkMoney() {
    if (this.hours <= 196) {
       this.setBaseSalary(baseSalary);
    } else {
      this.baseSalary = this.baseSalary + (this.hours - 196) * 200;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }


  @Override
  public String toString() {
    return "Employee{" +
        "hours=" + hours +
        ", name='" + name + '\'' +
        ", baseSalary=" + baseSalary +
        '}';
  }
}
