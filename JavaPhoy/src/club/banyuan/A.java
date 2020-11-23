package club.banyuan;
/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 3:09 下午
 */
public class A {
  private  final  String  NAME;
  public A(String NAME) {  //在创建对象的时候同时给对象里面的属性进行赋值    对象的完成标志是以最后一个属性赋值完成为结束
    this.NAME = NAME;
  }
  public String getNAME() {
    return NAME;
  }
}
class  TestA{
  public static void main(String[] args) {
       A a= new  A("李四");
    System.out.println(a.getNAME());
  }
}