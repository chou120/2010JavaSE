package club.banyuan.demo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/4 10:32 上午
 */
public class SteamAPI2 {

  public static void main(String[] args) {

//通过 Arrays 中的 stream() 获取一个数组流
    Integer[] nums = new Integer[10];
    Stream<Integer> stream1 = Arrays.stream(nums);
    //通过 Stream 类中静态方法 of()
    Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

    //Stream
    //初始化一个员工数组,找到工资大于指定工资的所有的员工
    Emp[] employees = new Emp[]{
        new Emp("9527", "周星星", 56, 5990.9),
        new Emp("9528", "吴孟达", 69, 123123.9),
        new Emp("9529", "送终鸡", 41, 1234.11),
        new Emp("9530", "李开心", 11, 1465.6),
        new Emp("9531", "周吉吉", 13, 2552.9)
    };

    Stream<Emp> stream = Arrays.stream(employees);
    stream.filter(emp -> emp.getSalary() > 1234.11)
        .forEach(System.out::println);

    //  allMatch(Predicate p)——检查是否匹配所有元素。
//          练习：是否所有的员工的年龄都大于18

    stream = Arrays.stream(employees);
    // boolean flag=  stream.allMatch(emp -> emp.getAge() > 18);
//    boolean flag=  stream.anyMatch(emp -> emp.getAge() > 18);
//    System.out.println(flag);

    // Stream<Emp> empStream = Arrays.asList(employees).parallelStream();
    //Emp emp = empStream.findAny().get();
    // System.out.println("\n"+emp);

    //   1  2  3
    //   2  3  1
    //   3  1  2

//    Emp emp = Arrays.asList(employees).parallelStream().findFirst().get();
//    System.out.println("\n"+emp);
//
//    final Emp emp1 =  stream.findAny().get();   //
//    System.out.println("\n"+emp1);

//    boolean flag = stream.noneMatch(emp -> emp.getName().equals("张三"));
//    System.out.println(flag);

    final List<Emp> collect = stream.filter(emp -> emp.getSalary() > 2000)
        .collect(Collectors.toList());

    System.out.println("\n"+collect);


    //分组:按照字符串的长度分组
   List<String> list = Arrays.asList("test","hello","dassdasjavaasdas","world","java","tom","C","javascript");
    //相同长度的字符串放到一个List集合中作为Map的value,字符串的长度作为Map的Key
  /*   Map<Integer, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(String::length));
    System.out.println(collect2);
*/

    //分割:按照字符串是否包含java进行划分  partitioning分割划分的意思

//    Map<Boolean, List<String>> collect3 =
//        list.stream().collect(Collectors.partitioningBy(s -> s.indexOf("java")!=-1));
//    System.out.println(collect3);
//

    List<String> list2 = Arrays.asList("java", "python", "C++","php","java");
    //直接将输出结果拼接
    System.out.println(list2.stream().collect(Collectors.joining()));
    //每个输出结果之间加拼接符号“|”
    System.out.println(list2.stream().collect(Collectors.joining(" | ")));
    //输出结果开始头为Start--，结尾为--End，中间用拼接符号“||”
    System.out.println(list2.stream().collect(Collectors.joining(" || ", "Start--", "--End")));

    final String s = list2.stream().collect(Collectors.maxBy(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    })).get();
    System.out.println("长度最大的是:"+s);





  }
}

class Emp {

  private String number;
  private String name;
  private Integer age;
  private Double salary;

  public Emp() {
  }

  public Emp(String number, String name, Integer age, Double salary) {
    this.number = number;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
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
  public String toString() {
    return "Emp{" +
        "number='" + number + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}
