package club.banyuan.finalDemo;

import club.banyuan.extend10.Father;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 3:57 下午
 */
public class Demo {

  private final String ADDRESS="2112";
  /**
   * final  修饰类:        不能被继承 修饰变量       变量变常量 修饰方法        方法不能被重写
   *
   * @param args
   */

  public static void main(String[] args) {
    new Son().method();
    Person   person=new Person();
//     Banana banana = person.changeData(123);
//    System.out.println(banana);

     Banana lisi = person.changeData(new Banana("李四"));
    System.out.println(lisi.hashCode());

  }
}

class Person {

  private static final String USERNAME = "定值";  //如果final修饰一个变量最好给初始值

  public String getUSERNAME() {
    return USERNAME;
  }

//  public  void setUSERNAME(String name){
//    this.USERNAME=name;  //报错  常量不能改变
//  }


  public final void method() {
    System.out.println("我是最终的 fnafga。。。");
  }


//  public void changeData(final String name) {  //西瓜苹果
//    //某种黑客技术  找到这个方法名称 在此方法执行的第一行对传递过来的数据进行修改
//    //name="你大爷";  //禁止在方法里面二次操作数据
//    Banana banana = new Banana();
//    banana.setName(name);
//  }


  public Banana changeData(final Banana banana) {  //西瓜苹果
    System.out.println("----"+banana.hashCode());
    //final对引用数据类型的修饰,其实就是对内存中的地址进行定值操作
    //banana=new Banana();//如果重新new一个对象就表示引用的对象不再是传递过来的那个对象(banana)了
    banana.setName("哈哈是");
    return banana;
  }

  public Banana changeData(final int name) {  //西瓜苹果
    //某种黑客技术  找到这个方法名称 在此方法执行的第一行对传递过来的数据进行修改
    //name=123;  //禁止在方法里面二次操作数据
    Banana banana = new Banana();
    banana.setName(name+"");
    return banana;
  }




}

class Son extends Person {

  //不能被重写
//  public  final void  method(){
//    System.out.println("我是最终的 fnafga。。。");
//  }


}
