package club.banyuan.practice;

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

    Subject subject = new Subject();
    subject.setSubId("1001");
    subject.setSubjectName("是兄弟就来砍我");
    subject.setSubScore(999);

    Subject[] subjects = new Subject[3];
    subjects[0]=subject;

    Subject subject1 = new Subject();//新建一个Subject对象
    subject1.setSubId("1002");
    subject1.setSubjectName("是兄弟");
    subject1.setSubScore(29);
    subjects[1]=subject1;


    Subject subject2 = new Subject(); //新建一个Subject对象
    subject2.setSubId("1003");
    subject2.setSubjectName("兄弟砍我");
    subject2.setSubScore(49);
    subjects[2]=subject2;


    //循环输入



    //将科目的数组直接赋值给学生  那就意味着学生有了多个科目的值
    student.setSubject(subjects);  //
   //student.setSubject(new Subject[]{new Subject(),new Subject(),new Subject()});

    System.out.println("学生的具体信息有:"+student);

  }
}
