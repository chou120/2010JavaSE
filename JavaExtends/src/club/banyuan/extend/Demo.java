package club.banyuan.extend;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 9:15 上午
 */
public class Demo {

  /**
   * 继承:
   */

  public static void main(String[] args) {
    Person person = new Person();
    person.setName("张飒");
    person.setAge(12);
    person.setSex('男');

    //System.out.println(person);
    Student student = new Student();
    student.setName("李四");
    student.setAge(13);
    student.setSex('女');

    System.out.println("student："+student);

    Teacher teacher = new Teacher();
    teacher.setName("老李");
    teacher.setAge(14);
    teacher.setSex('女');

    teacher.setSalary(34);

    System.out.println("teacher："+teacher);




  }


}
