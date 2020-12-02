package club.banyuan.demoMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 3:12 下午
 */
public class MyHashMap {


  /*
        有4个班级,ABC个班级有十个人(D班级空的)，现在因为,进行考试,
     考试不及格的退学,考试分数到达九十分升级到尖子班(D班级)

     Student  学号  姓名  考试成绩


   */


  public static void main(String[] args) {

    Map<String, List<Student>> studentMap = new HashMap<>();

    List<Student> list = new ArrayList<>();
    List<Student> listB = new ArrayList<>();
    List<Student> listC = new ArrayList<>();
    List<Student> listD = new ArrayList<>();

    list.add(new Student("001", "郭嘉", 97));
    list.add(new Student("002", "荀彧", 96));
    list.add(new Student("003", "诸葛亮", 95));
    list.add(new Student("004", "杨修", 93));//
    list.add(new Student("005", "司马懿", 92));
    list.add(new Student("006", "周瑜", 88));
    list.add(new Student("007", "许攸", 87));
    list.add(new Student("008", "关羽", 24));

    studentMap.put("A", list);
    studentMap.put("B", list);
    studentMap.put("C", list);
    studentMap.put("D", listD);
    add(studentMap);
    Set<String> r = studentMap.keySet();
    for (String s : r) {
      System.out.println(s+"班级:"+studentMap.get(s));
    }

    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    remove(studentMap, 88);

    Set<String> set = studentMap.keySet();
    for (String s : set) {
      System.out.println(studentMap.get(s));
    }

    //如果键是对象
    Map<Student,String> map=new HashMap<>();
    map.put(new Student("900","张飞",12), "长坂坡一声吼");
    map.put(new Student("901","张苞",15), "长坂坡一声吼");
    map.put(new Student("902","张1",13), "长坂坡一声吼");
    map.put(new Student("902","张1",13), "长坂坡2声吼");

    System.out.println(map);

  }

  public static void add(Map<String, List<Student>> map) {

    Set<String> set = map.keySet();
    final List<Student> list1 = map.get("D");
    for (String s : set) {
      if (!s.equals("D")) {
        List<Student> list = map.get(s);
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getIQ() >= 95) {
            list1.add(list.get(i));
          }
        }
      }
    }
    map.put("D", list1);

  }

  public static void remove(Map<String, List<Student>> map, int IO) {

    final Set<String> set = map.keySet();
    for (String s : set) {
      List<Student> list = map.get(s);
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getIQ() < IO) {
          list.remove(i);
        }
      }
    }

  }
}

class Student {

  private String stuNumber;
  private String name;
  private int IQ;

  public Student() {
  }

  public Student(String stuNumber, String name, int IQ) {
    this.stuNumber = stuNumber;
    this.name = name;
    this.IQ = IQ;
  }

  public String getStuNumber() {
    return stuNumber;
  }

  public void setStuNumber(String stuNumber) {
    this.stuNumber = stuNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIQ() {
    return IQ;
  }

  public void setIQ(int IQ) {
    this.IQ = IQ;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return IQ == student.IQ &&
        Objects.equals(stuNumber, student.stuNumber) &&
        Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stuNumber, name, IQ);
  }

  @Override
  public String toString() {
    return "Student{" +
        "stuNumber='" + stuNumber + '\'' +
        ", name='" + name + '\'' +
        ", IQ=" + IQ +
        '}';
  }
}
