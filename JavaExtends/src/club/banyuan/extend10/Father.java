package club.banyuan.extend10;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 2:02 下午
 */
public class Father {

  static{  //1
    System.out.println("我是父类的静态代码块....");
  }
  {  //3
    System.out.println("我是父类的构造代码块...");
  }

  public Father(){ //4
    System.out.println("我是父类的无参构造方法...");
  }

}
