package club.banyuan.pratice02;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 11:17 上午
 */
public class TestStudent {

  public static void main(String[] args) {
    Student student = new Student();
    student.setAge(18);
    student.setClassRoom("三年2班");
    student.setStuName("渣渣辉");
    student.setStuNumber("9999");

    Subject[] subjects = new Subject[3];  //重新创建的数组
    student.setSubject(subjects);

    Subject subject = new Subject();
    //对  subject 进行赋值操作
    subject.setSubId("10001");
    subject.setSubjectName("语文");
    subject.setSubScore(45.6);
    student.addSubject(subject);  //subjects[0]=subject;

    Subject subject2 = new Subject();
    //对  subject 进行赋值操作
    subject2.setSubId("10002");
    subject2.setSubjectName("数学");
    subject2.setSubScore(87.6);
    student.addSubject(subject2);  //subjects[0]=subject;

    Subject subject3 = new Subject();
    //对  subject 进行赋值操作
    subject3.setSubId("10003");
    subject3.setSubjectName("物理");
    subject3.setSubScore(89.5);
    student.addSubject(subject3);  //subjects[0]=subject;

   // System.out.println(student);

    //请输入要删除的科目
    String name = "语文";
    student.deleteSub(name);
    student.deleteSub("数学");
    student.deleteSub("物理");
    System.out.println(student);

    //student.deleteAll();
    //System.out.println(student);

    System.out.println(student.isEmpty());

  }
}
