package club.banyuan.courseTest;


/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:15 下午
 */
public class Product {
  //产品     产品编号    产品名称   产品上线时间   产品负责人

  private  String proId;
  private  String proName;
  private  String date;
  private  Employee  Employee; //哪个员工负责

  public String getProId() {
    return proId;
  }

  public void setProId(String proId) {
    this.proId = proId;
  }

  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Employee getEmployee() {
    return Employee;
  }

  public void setEmployee(Employee employee) {
    Employee = employee;
  }
}
