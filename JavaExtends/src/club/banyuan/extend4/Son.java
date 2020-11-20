package club.banyuan.extend4;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 10:35 上午
 */
public class Son extends  Father{

  private  String  number;//学号

  public Son() {
    //super();  //默认隐藏
   // this("asda","as","dass");
    System.out.println("这是子类的无参构造方法...");
  }
  public Son(String number,String  name,String address) {
   //super(); //默认隐藏
    super(name,address); //访问父类的有参构造
    this.number = number;
    System.out.println("这是子类的有参构造方法...");
  }
}

class  TestSon{
  public static void main(String[] args) {
     //Son son = new Son();  //优先去访问父类的无参构造方法
     //Son son = new Son(9527+"");  //优先去访问父类的无参构造方法

     //Son son = new Son("9527","张安福","稀奇");  //优先去访问父类的有参构造方法
    /**
     * 通过创建子类对象发现,父类的构造器也被调用了? 那么父类对象有没有被创建？ 没有
     *  super(); 提供一个对父类成员访问的机制  指向父类在内存中的区域,是为了方便访问父类的成员
     */


    new  Son();
  }
}