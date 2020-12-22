package club.banyuan;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

  @Test
  public void test() {
    ClassRoom classRoom = new ClassRoom();
    classRoom.add(
        new Student(1, "张三", 19),
        new Student(2, "李四", 20),
        new Student(3, "王五", 15),
        new Student(4, "赵六", 13)
    );
    classRoom.add();
    System.out.println(classRoom);
    Assert.assertEquals(4, classRoom.getStudents().size());

    List<Student> students = classRoom.sortByAgeDesc();
    // 记录前一个学生，将后一个和前一个比较，按照年龄的降序，需要保证后一个的年龄<=前一个的年龄
    Student before = null;
    for (Student student : students) {
      if (before != null) {
        Assert.assertTrue(student.getAge() <= before.getAge());
      }
      before = student;
    }

    students = classRoom.sortById();
    before = null;
    for (Student student : students) {
      if (before != null) {
        Assert.assertTrue(student.getId() >= before.getId());
      }
      before = student;
    }

  }
}
