package club.banyuan.courseTest;

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
    //添加到部门数组中,部门数组在company对象
     Department[] department1 = company.getDepartment();
     department1[0]=department;
  }

  //对员工和部门的增删改查的方法
  public   void  addEmployee(Employee employee,String  name,Company company){
    if(company.getDepartment()==null){
      return ;
    }
    if(employee.getJob()==name){
      Employee[] employee1 = company.getDepartment()[0].getEmployee();
      employee1[0]=employee;
      company.getDepartment()[0].setEmployee(employee1);
    }else{
      System.err.println("找不到组织");
      return;
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
