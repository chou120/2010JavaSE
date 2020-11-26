package club.banyuan.api;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 10:41 上午
 */
public class ObjectDemo {

  /**
   * Application programming  interface
   * <p>
   * API    提供一个接口  直接调用
   */
  public static void main(String[] args) throws CloneNotSupportedException {
    /*Object obj = new Object();
    Student student = new Student();
    Student clone = (Student) student.clone();
    System.out.println(student == clone);  //

    //901506536
    System.out.println(student.hashCode() + "》》》》" + student.getName());
    //932607259
    System.out.println(clone.hashCode() + "》》》》》" + clone.getName());

    System.out.println(student.equals(clone));

    Class<?> aClass = obj.getClass();
    System.out.println(aClass);//class java.lang.Object

    Class<?> aClass1 = student.getClass();
    System.out.println(aClass1);//class club.banyuan.api.Student
    System.out.println(aClass1.getName());  //类名

    System.out.println(student.toString() + "---" + Integer.toHexString(student.hashCode()));
    System.out.println(clone.toString() + "---" + Integer.toHexString(clone.hashCode()));
*/
    Student student1 = new Student();
    student1.setName("老周");
    student1.setAge(24);
    student1.setAddress("栖霞区自动创意园B9B座3楼");
    Student student2 = new Student();
    student2.setName("老周");
    student2.setAge(24);
    student2.setAddress("栖霞区自动创意园B9B座3楼");

   // System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
//    System.out.println(student1.equals(student2));
//    System.out.println(student1 == student2);

    /**equals 表示比较内容是否一样
     * == 比较内容和地址
     *
     */


//    System.out.println(student1.toString());
//    System.out.println(student2.toString());

//    Object student3 = new Student();
//    System.out.println(student3.getClass());

    System.out.println(student1.equals(student2));

  }
}
