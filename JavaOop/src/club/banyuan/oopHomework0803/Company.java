package club.banyuan.oopHomework0803;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:55 上午
 */
public class Company {

  private Employee[] employees=new Employee[4];
  private  int count=0; // count=0表示员工数组里面的 数据为null

  //1.添加一个员工。
  public  void  add(Employee employee){
    employees[count++]=employee;
  }

  @Override
  public String toString() {
    return "Company{" +
        "employees=" + Arrays.toString(employees) +
        ", count=" + count +
        '}';
  }

  //2. 通过员工的名字来删除员工,返回移除员工的对象
  public   Employee  removeByName(String  name){

    Employee  employee=null;
    for (int i = 0; i < count; i++) {
      if(employees[i].getName().equals(name)){  //判断 两个字符串是否是一样的
        //在移除之前拿到要移除的数据
        employee=employees[i];

        if(i==employees.length-1){
          employee=employees[employees.length-1];
          employees[employees.length-1]=null;  //如果移除的是最后一个
          count--;
          return   employee;
        }
        //进行移除
        for (int j =i; j < count-1; j++) { // 0 1 2 3   count=4
          employees[j]=employees[j+1];
        }
        employees[count-1]=null;
        count--;
      }
    }
    return employee;
  }

  //3. 通过员工的名字来显示员工的工资。
  public double   getSalary(String  name){
    for (int i = 0; i <count; i++) {
      if(employees[i].getName().equals(name)){
        return employees[i].getBaseSalary();
      }
    }
    return  0.0;
  }
  // 4. 输出所有员工的工资和。
  



}

