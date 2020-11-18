package club.banyuan.oopHomework0803;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 10:06 上午
 */
public class TestCompany {


  public static void main(String[] args) {
    Company company = new Company();
    Employee employee = new Employee();
    employee.setName("张三");
    //  employee.setBaseSalary();
    employee.setHours(205);

//    double  v=employee.checkMoney();
//    employee.setBaseSalary(v);

    employee.checkMoney();
    company.add(employee);

    employee = new Employee();
    employee.setName("李四");
    //  employee.setBaseSalary();
    employee.setHours(220);
    employee.checkMoney();

    company.add(employee);

    employee = new Employee();
    employee.setName("王五");
    //  employee.setBaseSalary();
    employee.setHours(180);
    employee.checkMoney();

    company.add(employee);

    employee = new Employee();
    employee.setName("田七");
    employee.setHours(196);
    employee.checkMoney();

    company.add(employee);

//    System.out.println(company);
//
//    Employee employee1 = company.removeByName("田七");
//
//    System.out.println(employee1);
//
    double salary = company.getSalary("李四");
    System.out.println(salary);





  }


}
