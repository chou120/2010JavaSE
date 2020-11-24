package club.banyuan.memberInner;

import club.banyuan.memberInner.OriginalClass.OriginalInner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 2:56 下午
 */
public class OriginalClass {

  private static int t1 = 100;
  private int t2 = 200;

  public   final  int age2=16;


  public void action() {
    System.out.println("originalinner action非静态方法...");
  }
  public  static  void  info(){
    System.out.println("外部类的静态方法....");
  }
  //成员内部类,没有static
  public class OriginalInner {

   // public  static  final  int age2=12; //常量池
   // public  static   int  age1=12; //属于类文件   加载到静态域里面

    public   final  int age2=16;

    public void method() {
      int age2=12;
      age2=1231;
      action();
      info();
      System.out.println("我是成员内部类"+OriginalClass.this.age2);
      System.out.println(this.age2);
      System.out.println(age2);
      /**
       * 前提是在内部类的方法中去调用:
       * 当内部类的成员变量和外部类的成员变量重名时   可以使用
       *  外部类名.this.属性   表示访问外部类对象
       *  this.属性  表示内部类对象
       */

    }

    //成员内部类里面没有静态一说
//    public  static  void  getInfo(){
//
//    }

  }
}

class Test{

  public static void main(String[] args) {
    OriginalClass.OriginalInner originalInner = new OriginalClass().new OriginalInner();//创建成员内部类对象
    originalInner.method();


  }
}

