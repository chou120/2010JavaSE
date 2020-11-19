package club.banyuan.constructor09;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 9:42 上午
 */
public class Demo {
 //public class  Person{
  // 一个源文件中只有一个对外提供访问的公共类    不能有第二个 这种写法报错
  // 如果同一个源文件出现了两个对外访问的公共类  那么java并不能确定具体是哪个对外开放
  /**
   *
   */
  public static void main(String[] args) {
    //Person person = new Person();   //  new  Person(); 只不过没有变量名来接收这个Person对象  没有变量名来接收的叫匿名对象
    //Person  person=null;  // 没有引用具体的Person对象
//    new Person();
//    new Person();  //匿名对象调用一次 就会被当成垃圾   jvm 自动回收
//    new Person();

     Person zhangfei = new Person();
    System.out.println(zhangfei.toString());

    /**
     *  对象根据什么创建的?   对象构造器      每个java文件都会有一个默认的构造器(隐藏起来)
     */

  }
}
class  Person{
  //  private  默认的  protected   public   1  2  3  4

  private  String name;  // null
  private  int   age; //0
  private  String address; // null

  /**
   * 当jvm执行java程序的时候如果发现该java文件没有提供显示的构造器 那么会去自动提供一个无参构造器
   */

  /**
   * 无参构造器(无参构造方法)
   */
  public  Person(){  //作用 就是用来创建对象
    //this() 前面没有代码,不然会报错   为什么? 创建当前对象的动作没有完成,不能去执行输出语句

    //可不可以在无参构造器里面调用有参构造器
    this("哈市");  //this（参数） 表示调用当前对象的有参构造器
    System.out.println("这是无参构造器,用来创建对象");
  }

  //有参构造器
  public   Person(String name){  //只给对象name赋值
    this.name=name;
    System.out.println("一个参数的构造器");
  }

  public   Person(String name,int  age){  //只给对象name赋值
    this.name=name;
    this.age=age;
    System.out.println("2个参数的构造器");
  }
  public   Person(String name,int  age,String address){  //只给对象name赋值
    this.name=name;
    this.age=age;
    this.address=address;
    System.out.println("3个参数的构造器");
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public  void show(){

  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }
}
