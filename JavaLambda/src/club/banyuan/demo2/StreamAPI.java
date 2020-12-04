package club.banyuan.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 9:15 上午
 */
public class StreamAPI {


  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("123");
    list.add("21312");
    list.add("1");
    list.add("12223");
    list.add("82423");

    //fork/join  线程的一种设计框架    无序 随机   并行(并发)
    Stream<String> stream = list.parallelStream();
    stream.forEach(System.out::println);  //  终止流
    System.out.println("-----");
    //stream.forEach(System.out::println);

    Stream<String> stream1 = list.stream();  //串行
    //stream1.forEach(x-> System.out.println(x));
    stream1.forEach(System.out::println);  //中间操作   并没做其他操作  在调用结束流方法的时候一起执行

    Stream<String> stream2 = list.stream();
    stream2.filter(
        string -> Integer.parseInt(string) > 12223)
        .forEach(System.out::println);

    System.out.println();

    Stream<String> stream3 = list.stream();
    stream3.limit(4).forEach(System.out::println);

    System.out.println(list);

    List<Employee> emps = Arrays.asList(
        new Employee(102, "李四", 59, 6666.66),
        new Employee(101, "张三", 18, 9999.99),
        new Employee(103, "王五", 28, 3333.33),
        new Employee(104, "赵六", 8, 7777.77),
        new Employee(104, "赵das六", 8, 7787.77),
        new Employee(104, "赵六", 8, 7777.77),
        new Employee(105, "田wqq七", 38, 5555.55)
    );

    emps.stream().filter(employee -> employee.getSalary() > 5555.55).
        limit(5).forEach(System.out::println);
    System.out.println(">>>>>>>");
    emps.stream().limit(5).filter(employee -> employee.getName().length() > 6)
        .forEach(System.out::println);
    System.out.println(">>>>>>>");

    emps.stream().limit(5).skip(2).forEach(System.out::println);
    //没有改变原有的数据  但是我们可以收集改变之后的数据   Stream
    System.out.println();
    emps.stream().distinct().forEach(System.out::println);

    System.out.println();

    emps.stream().map(employee -> {
      if (employee.getAge() > 18) {
        Double money = employee.getSalary() + 200;
        employee.setSalary(money);
      }
      return employee;
    }).forEach(System.out::println);

    Employee employee = emps.stream().max(new Comparator<Employee>() {
      @Override
      public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
      }
    }).get();

    System.out.println(">>>>>>" + employee);

    final OptionalInt max = list.stream().mapToInt(Integer::parseInt).max();

    System.out.println("和是:" + max.getAsInt());


    //sorted
    List<Integer> list2 = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
    list2.stream().sorted().limit(5).forEach(System.out::println);

    System.out.println();
    list2.stream().sorted(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    }).forEach(System.out::println);


  }
  public static void get(int... x) {

  }
}

class Employee {

  private Integer number;
  private String name;
  private Integer age;
  private Double salary;

  public Employee() {
  }

  public Employee(Integer number, String name, Integer age, Double salary) {
    this.number = number;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(number, employee.number) &&
        Objects.equals(name, employee.name) &&
        Objects.equals(age, employee.age) &&
        Objects.equals(salary, employee.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, age, salary);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "number=" + number +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}