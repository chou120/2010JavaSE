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
  }
  public Son(){//6
    System.out.println("我是zi类的无参构造方法...");
  }

}

class  Test{

  public static void main(String[] args) {
      new  Son();
  }
}


