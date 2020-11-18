package club.banyuan.courseTest;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 3:48 下午
 */
public class UpdateCompanyData {

  //初始化所有的数组
  public  void   init(Company company){
    //产品数组初始化
    Product[] products = new Product[3];
    //部门数组初始化
    Department[] departments = new Department[4];
//    //员工数组初始化
//    Employee[] employees=new Employee[10];
    company.setDepartment(departments);
    company.setProduct(products);
    //塞员工数组了   由于员工数组在部门中 所以需要考虑初始化的 要不要创建员工数组
  }

  //添加一个部门
  public  void  addDepartment(Department department,Company  company){
    int deptNumber = company.getDeptNumber();
    //添加到部门数组中,部门数组在company对象
     Department[] department1 = company.getDepartment();
     department1[deptNumber++]=department;
     company.setDeptNumber(deptNumber);
  }

  //对员工和部门的增删改查的方法
  public   void  addEmployee(Employee employee,String  name,Company company){

    Department[] department = company.getDepartment();
    Employee [] employees=null;

    for (int i = 0; i < company.getDeptNumber(); i++) {
      if(department[i].getEmployee()==null){
          if(department[i].getDeptName().equals("人事部")){
              //创建人事部的员工数组
              employees=new Employee[1];
              employees[0]=employee;
            department[i].setEmployee(employees);
          }else if(department[i].getDeptName().equals("研发部")){
            employees=new Employee[1];
            employees[0]=employee;
            department[i].setEmployee(employees);
          }
      }else {
          //如果数组长度不为空,对原有的数组进行扩容
        if(department[i].getDeptName().startsWith(name)){
          Employee[] employee1 = department[i].getEmployee();
          //使用此方式对原有的数组进行扩容
          employee1=Arrays.copyOf(employee1,employee1.length+1);
          employee1[employee1.length-1]=employee;
          department[i].setEmployee(employee1);
        }

      }
    }

  }

  //判断数组是否为空
   public  boolean  isEmpty(Department  department){
     Employee[] employee = department.getEmployee();
     if(employee==null){
       return true;
     }
     if(employee.length!=0 ){ //数组里面没有元素
       for (int i = 0; i < employee.length; i++) {
         if(employee[i]!=null){
           return false;
         }
       }
        return true;
     }
     return false;
   }


   //删除一个员工   或者删除一个部门




}
