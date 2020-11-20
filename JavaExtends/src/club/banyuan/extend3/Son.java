package club.banyuan.extend3;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/20 9:42 上午
 */
public class Son  extends  Father {


  public  void   method(){
    address="家中有屋又有田";
    //不是私有化的属性可以直接访问  其实这也体现了继承的另一个弊端：打破了封装性
    setName("萨达撒");
    System.out.println(address+","+age+","+","+IdCard+getName());
    //Father fa=new  Father();  fa.setName();
  }
}

class  TestSon{
  public static void main(String[] args) {
    Son son = new Son();
    //System.out.println(son.address+","+son.IdCard+","+son.age+","+son.getName());

    son.getMoney();
    son.protectWife();


  }

}