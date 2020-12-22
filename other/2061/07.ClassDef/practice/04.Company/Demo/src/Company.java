public class Company {

  private Employee[] employees = new Employee[10];
  private int count;

  public void addEmployee(Employee employee) {
    if (count >= 10) {
      System.err.println("公司人满了！");
      return;
    }

    employees[count] = employee;
    count++;
  }

  public void fireEmployee(String name) {
    int index = -1;
    // 查找被删除的员工的位置，即数组下标
    for (int i = 0; i < count; i++) {
      if (employees[i].getName() == name) {
        index = i;
        break;
      }
    }

    // 把最后一个人，填补到被删除的员工所在的位置。并且把原来最后一个人的位置的值修改为null
    if (index > -1) {
      employees[index] = employees[count - 1];
      employees[count - 1] = null;
      count--;
    }
  }

  public void printEmployeeSalary(String name) {
    int index = -1;
    // 查找查找员工
    for (int i = 0; i < count; i++) {
      if (employees[i].getName() == name) {
        index = i;
        break;
      }
    }

    if (index > -1) {
      Employee employee = employees[index];
      System.out.println(employee.getName() + ":" + employee.getSalary());
    } else {
      System.err.println("查无此人");
    }
  }


  public void printAllSalary() {
    int total = 0;

    for (int i = 0; i < count; i++) {
      Employee employee = employees[i];
      total += employee.getSalary();
      System.out.println(employee.getName() + ":" + employee.getSalary());
    }

    // 产生空指针异常，因为就算没有员工，也会遍历10次，每次拿到一个null，调用null的getSalary方法，会出现空指针异常
    // for (Employee employee : employees) {
    //   total += employee.getSalary();
    //   System.out.println(employee.getName() + ":" + employee.getSalary());
    // }

    System.out.println("总工资：" + total);
  }

}
