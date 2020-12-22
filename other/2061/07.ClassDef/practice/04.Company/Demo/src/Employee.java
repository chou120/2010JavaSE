public class Employee {

  // 工作时长（小时）
  //    姓名
  //    基本工资
  private int workHour;
  private String name;
  private int salary = 3000;

  public Employee(int workHour, String name) {
    this.workHour = workHour;
    this.name = name;
  }

  public int getWorkHour() {
    return workHour;
  }

  public void setWorkHour(int workHour) {
    this.workHour = workHour;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //当每月工作的小时数超过196 小时时，超出的部分按每小时200 元。
  //    基本工资+（工作的小时-196）*200。
  public int getSalary() {
    int overTimeSalary = 0;
    if (workHour > 196) {
      overTimeSalary = (workHour - 196) * 200;
    }
    return salary + overTimeSalary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

}
