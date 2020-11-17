package club.banyuan.homework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 9:59 上午
 */
public class Student {
//  现有学生模板,有以下其属性:
//  学生名   stuName
//  学号     stuId
//  学生成绩  stuScore
//  学生住址  stuAddress;
//
//3年五班 有6个学生  进行一次测试,根据测试的成绩进行降序排序
//  Student[] student=new Student[6];

  private  String  stuName="周星星";
  private  String  stuId="9527";
  private  double  stuScore=45.6;
  private  String  stuAddress="未知";

  //如果模板提供的属性没有给初始化值 那么 该属性的默认值是否存在  如果存在 那么默认值是什么？
  private  int  age;
  private  char   sex;
  private  String  IDCard;  //一般是特殊的变量名可用大写
  private  double  height;


  //提供一个对外开放的方法  去访问私有化的属性(得到私有化的属性值)
  public  double   getScore(){
    return   stuScore;
  }

  public String getStuName() {
    return stuName;
  }

  public String getStuId() {
    return stuId;
  }

  public double getStuScore() {
    return stuScore;
  }

  public String getStuAddress() {
    return stuAddress;
  }

  public int getAge() {
    return age;
  }

  public char getSex() {
    return sex;
  }

  public String getIDCard() {
    return IDCard;
  }

  public double getHeight() {
    return height;
  }

  public  void  setStuName(String  newName){
    //TODO newName长度  你们去做判断
    stuName=newName;
  }

  public  void  setStuId(String  newStuId){
    // TODO
    stuId=newStuId;
  }

  public void setStuScore(double newStuScore) {
    if(newStuScore>=0 && newStuScore<=100){
      stuScore = newStuScore;
    }else {
      System.out.println("输入的成绩不合法");
    }
  }

  public void setStuAddress(String newStuAddress) {
    stuAddress = newStuAddress;
  }

  public void setAge(int newAge) {
    if(newAge>0 && newAge< 150){
      age = newAge;
    }else {
      System.out.println("年龄的取值范围不对");
    }
  }

  public void setSex(char newSex) {
    sex = newSex;
  }

  public void setIDCard(String newIDCard) {
    IDCard = newIDCard;
  }

  public void setHeight(double newHeight) {
    height = newHeight;
  }


  /**
   * 显示对象各个属性的信息方法统一命名为 toString  为了方便调用
   * 在输出语句中直接输出一个对象名,其实就输出该对象的所有的属性信息
   * @return
   */
  public String toString() {
    System.err.println("我哟没哟被调用");
    return "学生信息如下:{" +
        "stuName='" + stuName + '\'' +
        ", stuId='" + stuId + '\'' +
        ", stuScore=" + stuScore +
        ", stuAddress='" + stuAddress + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        ", IDCard='" + IDCard + '\'' +
        ", height=" + height +
        '}';
  }
}
