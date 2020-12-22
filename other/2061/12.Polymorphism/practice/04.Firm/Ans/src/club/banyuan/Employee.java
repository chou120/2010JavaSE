package club.banyuan;

/**
 * 定义一般员工
 */
public class Employee extends StaffMember {

  protected String socialSecurityNumber;
  protected double payRate;

  // 用指定的信息设置员工
  public Employee(String eName, String eAddress, String ePhone,
      String socSecNumber, double rate) {
    // 因为name 等属性都是在父类中定义的protected，子类可以直接通过名称使用
    // 但是不建议在子类中通过名称赋值的方式进行初始化。
    super(eName, eAddress, ePhone);
    socialSecurityNumber = socSecNumber;
    payRate = rate;
  }

  //以字符串形式返回有关员工的信息
  public String toString() {
    String result = super.toString();
    result += "\n社保账号: " + socialSecurityNumber;
    return result;
  }

  // 返回此员工的工资率.
  public double pay() {
    return payRate;
  }

}