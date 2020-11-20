package club.banyuan.extend10;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 2:02 下午
 */
public class Son  extends  Father{

  static{//2
    System.out.println("我是zi类的静态代码块....");
  }
  {//5
    System.out.println("我是zi类的构造代码块...");
  }//6
  public Son(){//6
    System.out.println("我是zi类的无参构造方法...");
  }

}

class  Test{

  public static void main(String[] args) {
      new  Son();
  }
}


class A {
  int i = 1212;
}
class B extends A {
  A a;  //成员变量a 有对象
  //int  i=1212;
  public B(A a) {
    this.a = a;  //  a.i=1212
  }
  public  void  method(){
    System.out.println(i);     //1212
  }
}
 class MainClass {
  public static void main(String[] args) {
    A a = new A();

    B b = new B(a);

    System.out.println(a.i);  //1212

    System.out.println(b.i); // 1212

    System.out.println(b.a.i); // 1212

    b.a.i = 2121;
    b.method();

    System.out.println("--------");
    System.out.println(a.i);  //2121
    System.out.println(b.i);  // 1212
  }
}