package club.banyuan.courseTest;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:15 下午
 */
public class Department {

  //部门     部门编号    部门名称   部门所在地
  // 员工: 编号  名字  联系方式   职责   入职时间   所属部门   工资
  private  String  deptId;
  private  String deptName;
  private  String address;
  //还有员工
  private  Employee[]  employee;  // employee=null

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Employee[] getEmployee() {
    return employee;
  }

  public void setEmployee(Employee[] employee) {
    this.employee = employee;
  }

  @Override
  public String toString() {
    return "Department{" +
        "deptId='" + deptId + '\'' +
        ", deptName='" + deptName + '\'' +
        ", address='" + address + '\'' +
        ", employee=" + Arrays.toString(employee) +
        '}';
  }
}
