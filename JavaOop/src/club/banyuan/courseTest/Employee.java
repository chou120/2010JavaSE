package club.banyuan.courseTest;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:18 下午
 */
public class Employee {

  //员工: 编号  名字  联系方式   职责   入职时间   所属部门   工资
  private  String  empId;
  private  String  name;
  private  String iphone;
  private  String  job;
  private  String  date;
  private  Department  department;  //
  private  double  empSalary = 5000;

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public double getEmpSalary() {
    return empSalary;
  }

  public void setEmpSalary(double empSalary) {
    this.empSalary = empSalary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "empId='" + empId + '\'' +
        ", name='" + name + '\'' +
        ", iphone='" + iphone + '\'' +
        ", job='" + job + '\'' +
        ", date='" + date + '\'' +
        ", department=" + department +
        ", empSalary=" + empSalary +
        '}';
  }
}
