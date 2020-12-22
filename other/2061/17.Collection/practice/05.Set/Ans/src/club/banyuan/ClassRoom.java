package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassRoom {

  private Set<Student> students = new HashSet<>();

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

  public void add(Student student) {
    students.add(student);
  }

  public void add(Student... stuArr) {
    students.addAll(Arrays.asList(stuArr));
  }

  public void printInfo() {
    for (Student student : students) {
      System.out.println(student);
    }
  }

  public List<Student> sortById() {
    List<Student> rlt = new ArrayList<>(students);
    rlt.sort(Comparator.comparingInt(Student::getId));
    return rlt;
  }

  public List<Student> sortByAgeDesc() {
    List<Student> rlt = new ArrayList<>(students);
    rlt.sort((s1, s2) -> s2.getAge() - s1.getAge());
    return rlt;
  }

  @Override
  public String toString() {
    return "ClassRoom{" +
        "students=" + students +
        '}';
  }

  public static void main(String[] args) {
    ClassRoom classRoom = new ClassRoom();
    // classRoom.add(
    //     new Student(1, "张三", 19),
    //     new Student(2, "李四", 19),
    //     new Student(3, "王五", 19),
    //     new Student(4, "赵六", 19)
    // );
    // classRoom.add();
    // System.out.println(classRoom);

    // Student student = new Student();
    // classRoom.add(student);
    //
    // student.setAge(19);
    // student.setId(1);
    // student.setName("123");
    //
    // System.out.println(classRoom);

    // Set<Student> set = new HashSet<>();
    // Student student = new Student();
    // set.add(student);
    // student.setName("123");
    //
    // for (Student student1 : set) {
    //   System.out.println(student1.getName());
    // }

    Set<List<Student>> setList = new HashSet<>();
    for (List<Student> oneList : setList) {
      for (Student oneStu : oneList) {
        System.out.println(oneStu.getName());
      }
    }

    List<Student> studentList = new ArrayList<>();
    setList.add(studentList);

    studentList.add(new Student(1, "2", 3));

    for (List<Student> oneList : setList) {
      for (Student oneStu : oneList) {
        System.out.println(oneStu.getName());
      }
    }
  }

}
