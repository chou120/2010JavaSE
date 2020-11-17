package club.banyuan.pratice02;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 11:11 上午
 */
public class Student {

  /**
   * 一对多   一个 A  对应多个 B 一个老师多个学生   一个公司 多个员工    一个饭店多个厨师    一个人 多套衣服 ... 双十一    买了三四件的商品     一个用户
   * 多个商品 多对一
   * <p>
   * 多对多
   */

  private String stuNumber;
  private String stuName;
  private int age;
  private String classRoom;

  //所学的科目
//  private  String  subjectName; //科目名称
//  private  double  subScore; //科目成绩
//  private  String  SubId; //科目编号
  private Subject[] subject;  //学生模板有科目属性

  private  int key = -1;  //用来统计数组subject 有效长度

  public Subject[] getSubject() {
    return subject;
  }

  public void setSubject(Subject[] subject) {
    this.subject = subject;
  }


  @Override
  public String toString() {
    String str="";
    if(subject!=null){
      for (Subject subject1 : subject) {
        if(subject1!=null){
          str=str+subject1+",";
        }
      }
    }

   /* String  [] st={"张三","李四","王五","赵六"};
    for (int i = 0; i <st.length; i++) {
      System.out.println(st[i]);
    }
    *//**
     * for(数组(集合)的数据类型  变量名:数组名或者集合名)
     *//*
        for (String  u: st) {
          System.out.println(u);
        }
*/
    return "Student{" +
        "stuNumber='" + stuNumber + '\'' +
        ", stuName='" + stuName + '\'' +
        ", age=" + age +
        ", classRoom='" + classRoom + '\'' +
        ", subject=" +str +
        '}';
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
  public void addSubject(Subject sub) {
    //如果往数组里面添加数据 第一步怎么做
    if (subject == null) {
      System.out.println("没有创建对应的数组");
      return;
    }
    //如果数组不为空,存在该数组
    //利用计数器来统计该数组里面的有效元素的个数
    subject[++key] = sub; //  5   5个数据
   // this.key=++key;
  }

  //移除一个科目
  public  void  deleteSub(String  subName){  //根据科目的名称来删除科目  123456
    int   index=-1;
    for (int i = 0; i < key+1; i++) {  //
      //    new  Subject[3];    sub1  sub2  null
      if(subject[i].getSubjectName()==subName){
        subject[i]=null;  //从删除的位置开始 把后面的数据往前挪一位
        index=i;  //找到相同的科目名称的位置
      }
    }
    for (int i = index; i < subject.length-1; i++) {
      subject[i]=subject[i+1];
    }
    subject[subject.length-1]=null;
    --key;
  }

  //如何一次把所有的科目删除
  public  void  deleteAll(){
    subject=null;  //数组为空  意味着没有科目对象了
    key=-1; //表示没有数据
  }

  //如何判断数组里面的数据为空(不存在)
  public  boolean  isEmpty(){
      if(key==-1){
        return false;
      }
      return  true;
  }












}
