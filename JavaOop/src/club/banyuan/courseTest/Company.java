package club.banyuan.courseTest;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:14 下午
 */
public class Company {

  //用来记数添加的部门的个数
  private  int  deptNumber=0;
  //用来记数添加员工的个数
  private  int  empNumber=0;

  public int getDeptNumber() {
    return deptNumber;
  }
  public void setDeptNumber(int deptNumber) {
    this.deptNumber = deptNumber;
  }
  public int getEmpNumber() {
    return empNumber;
  }
  public void setEmpNumber(int empNumber) {
    this.empNumber = empNumber;
  }

  private String companyId; // 公司名字
  private String address;
  private String date;//时间
  //产品
  private Product[] product;
  //部门
  private Department[] department;

  private Employee employee;//公司所属人

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Product[] getProduct() {
    return product;
  }

  public void setProduct(Product[] product) {
    this.product = product;
  }

  public Department[] getDepartment() {
    return department;
  }

  public void setDepartment(Department[] department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Company{" +
        "companyId='" + companyId + '\'' +
        ", address='" + address + '\'' +
        ", date='" + date + '\'' +
        ", product=" + Arrays.toString(product) +
        ", department=" + Arrays.toString(department) +
        '}';
  }
}
