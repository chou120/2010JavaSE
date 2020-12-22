public class Main {

  public static void main(String[] args) {
    Company company = new Company();

    Employee e1 = new Employee(200,"a");
    Employee e2 = new Employee(300,"b");
    Employee e3 = new Employee(220,"c");
    Employee e4 = new Employee(100,"d");

    company.addEmployee(e1);
    company.addEmployee(e2);
    company.addEmployee(e3);
    company.addEmployee(e4);
    company.printAllSalary();
    company.printEmployeeSalary("b");
    company.printEmployeeSalary("a");
    company.fireEmployee("a");
    company.printAllSalary();
  }
}
