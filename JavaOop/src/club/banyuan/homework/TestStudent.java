package club.banyuan.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 10:11 上午
 */
public class TestStudent {

  public static void main(String[] args) {
    Student[] students = new Student[3];  //引用数据类型的数组里面的默认值是null
    //System.out.println(students[0]);  //
   // Scanner   scanner=new Scanner(System.in);

//    for (int i = 0; i < students.length; i++) {
//      Student student = new Student();

//      System.out.println("输入第"+(i+1)+"个学生的编号:");
//      String  stuId=scanner.next();
//      student.setStuId(stuId);
//
//      System.out.println("输入第"+(i+1)+"个学生的名字:");
//      String  name=scanner.next();
//      student.setStuName(name);
//
//      System.out.println("输入第"+(i+1)+"个学生的成绩:");
//      double  score=scanner.nextDouble();
//      student.setStuScore(score);
//
//      System.out.println("输入第"+(i+1)+"个学生的地址:");
//      String  address=scanner.next();
//      student.setStuAddress(address);

//      students[i]=student;
//
//    }
//    sort(students);

    System.out.println(Arrays.toString(students));  //把数组里面所有的数据都输出一遍

//    Student student = new Student();
//    System.out.println("》》》》"+student);

  }

  public  static  void  sort(Student[] students){

    for (int i = 0; i < students.length; i++) {
      for (int j = 0; j < students.length-1-i; j++) {
        if(students[j].getScore() < students[j+1].getScore()){
              Student   temp=students[j];
              students[j]=students[j+1];
              students[j+1]=temp;
        }
      }

    }



  }


}
