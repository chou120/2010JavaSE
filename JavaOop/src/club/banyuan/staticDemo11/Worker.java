package club.banyuan.staticDemo11;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 11:07 上午
 */
public class Worker {

  /**
   * static 关键字   1.通过类名.静态方法  可以直接调用该方法
   *                2.静态的只能访问静态的成员,不能访问非静态的成员 非静态的成员可以任意访问
                    3.static 修饰的属性 被所有的对象共享 以最终的修改之后的数据为结果
                    4.被static修饰的成员优先于对象成员加载到内存中

                    5.被static修饰的成员属性生命周期,在整个程序结束之前都存在;对象成员属性随着对象的消失而消失


     6.   静态代码块          构造代码块   构造函数代码块     优先级顺序
        1  记载一遍         2           3

     7.   this关键字能不能和static一起使用
          不能一起混合使用   this表示当前对象  而 static 是属于类成员

   */

  // 4.知识点   被static 成员叫类成员  其他的属于对象成员
  //    属于class文件   对象是根据xxx.class文件创建  只有一个class文件但是根据class文件创建的对象有很多

  static {
    System.out.println("我是静态的代码块...");
    // 7.System.out.println("我是静态的代码块..."+this.getName()); 结果报错
  }

  {
    System.out.println("我是构造代码块...");
  }

  private String name = "站感受";
  private static String country = "中国";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static String getCountry() {
    return country;
  }

  public static void setCountry(String country) {
    Worker.country = country;
  }

  public void method1() {
    System.out.println("非静态方法..." + name + "," + country);
  }
  public static void   method2(){
    System.out.println("静态方法..."+country);
  }


  @Override
  public String toString() {
    return "Worker{" +
        "name='" + name + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
