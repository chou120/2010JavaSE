package club.banyuan.courseTest;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:10 下午
 */
public class Demo {

  /**
   * 需求: 现在有一个公司Company 属性自定义 编号 公司地址 公司成立时间 产品     产品编号    产品名称   产品上线时间   产品负责人 部门     部门编号
   * 部门名称   部门所在地 员工 属性:
   * <p>
   * 公司成立 boss 让 HR 招人   人事部3     研发部3个人   教学部3个人   后勤部1个
   * <p>
   * <p>
   *
   *   完成:对 员工和部门 所在的对象 增删改查
   *
   * 增加难度:每个人都有上司
   */

  public static void main(String[] args) {
    Company company = new Company();
    company.setCompanyId("半圆学社");
    company.setAddress("栖霞区紫东创意园B9B座3楼");
    company.setDate("2018年08月07日");

    Employee employee = new Employee();  //创建老板
    employee.setJob("BOSS");
    employee.setEmpId("0001");
    employee.setName("吴楠");
    employee.setIphone("13011011101");
    company.setEmployee(employee);

    UpdateCompanyData updateCompanyData = new UpdateCompanyData();
    updateCompanyData.init(company);  //初始化之后的部门和产品存储数据的位置都有了

    Department department = new Department();
    department.setDeptId("123");
    department.setAddress("南京");
    department.setDeptName("人事部");
    Employee[] employees = new Employee[3];
    department.setEmployee(employees);

    updateCompanyData.addDepartment(department, company);

    System.out.println(company);


    //现在是把员工添加进去
    Employee employee1 = new Employee();
    employee1.setName("行健");
    employee1.setEmpId("004");
    employee1.setJob("人事");

    updateCompanyData.addEmployee(employee1,"人事", company);

    System.out.println(company);

  }


}
