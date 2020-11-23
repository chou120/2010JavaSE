package club.banyuan.com2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 2:12 下午
 */
public class Test {

  /**
   * 2.多态成员访问特点: 成员变量 在多态的情况下,如果子类变量名和父类重名了,那么使用的变量是父类的 成员方法 在发生方法重写的情况下,父类变量名(person)引用的方法名其实还是子类自己的
   * 静态方法 在多态的前提下,如果父类引用指向子类对象,那么父类和子类相同的静态方法名被调用, 其实调用的是父类自己的(可以从此话得出,静态方法根本算不上被重写)
   */

  public static void main(String[] args) {
    Person person = new Son();
    //Son son = new Son();
   // person.useParent(); 不能直接调用
    System.out.println(person.address);
    //person.study();
//    person.makeMoney();  //
//    Person.makeMoney();
    // Son son = new Son();  //这种写法没有使用到多态
    //  System.out.println(son.address);

    person.getAddress();

    //弊端：如果子类有自己的行为或者属性,那么父类就不能直接去使用
    Son son = (Son) person;  //
    son.useParent();
    System.out.println(son.address);

  }
}
