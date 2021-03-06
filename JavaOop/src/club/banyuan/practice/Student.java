package club.banyuan.practice;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 11:11 上午
 */
public class Student {
  /**
   * 一对多   一个 A  对应多个 B
   *          一个老师多个学生   一个公司 多个员工    一个饭店多个厨师    一个人 多套衣服
   *          ...
   *          双十一    买了三四件的商品     一个用户 多个商品
   * 多对一
   *
   * 多对多
   *
   */

  private String stuNumber;
  private String stuName;
  private int age;
  private String classRoom;

  //所学的科目
//  private  String  subjectName; //科目名称
//  private  double  subScore; //科目成绩
//  private  String  SubId; //科目编号
  private Subject[]  subject;  //学生模板有科目属性
  //

  @Override
  public String toString() {
    return "Student{" +
        "stuNumber='" + stuNumber + '\'' +
        ", stuName='" + stuName + '\'' +
        ", age=" + age +
        ", classRoom='" + classRoom + '\'' +
        ", subject=" + Arrays.toString(subject) +
        '}';
  }

  public Subject[] getSubject() {
    return subject;
  }

  public void setSubject(Subject[] subject) {
    this.subject = subject;
  }

  public String getStuNumber() {
    return stuNumber;
  }

  public void setStuNumber(String stuNumber) {
    this.stuNumber = stuNumber;
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getClassRoom() {
    return classRoom;
  }

  public void setClassRoom(String classRoom) {
    this.classRoom = classRoom;
  }


  //学生有主动添加科目的方法
  public   void  addSubject(Subject subject){


  }





}
