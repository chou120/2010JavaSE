package club.banyuan.extend6;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 11:03 上午
 */
public class Son extends  Father {

 // public   String name="张大炮";
  public   String  hairColor="绿色";

  //当父类的方法功能满足不了子类自己的需求时,可以进行方法重写
  //方法重写: 方法名一样,参数列表一样,返回值类型一样,实现过程不一样
  public  void  method(){
    //String  name="斯内克";
    System.out.println("子类方法"+name);
  }


  private  int  age=32;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  private  void  method2(){

  }
  void  methodInf(){
    int   age=12;
    // 12  57  57
    this.method2();
    System.out.println(age+","+this.getAge()+","+super.getAge());  //32
  }



}
