package club.banyuan.anonymityOther;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 4:16 下午
 */
public class Outer {

  /**
   * 1.内部类可以很好的实现隐藏
   * <p>
   * 一般的非内部类，是不允许有 private 与protected权限的，但内部类可以
   * <p>
   * 2.内部类拥有外围类的所有元素的访问权限
   * <p>
   * 3.可是实现多重继承
   * <p>
   * 4.可以避免修改接口而实现同一个类中两种同名方法的调用
   */

  public static Inter method() {
   // Inter  inter=new Inter(); //这种写法才是创建父类对象

     /*
        类名         对象名=new       类名();
        InterImpl   im=new  InterImpl();
        Inter  inter=new  InterImpl();
      */

//    Inter inter = new Inter(){  //创建匿名子类对象
//      @Override
//      public void show() {
//        System.out.println("你好");
//      }
//    };
//    return inter;

    return new Inter(){
      @Override
      public void show() {
        System.out.println("你好");
      }
    };

  }
}

interface Inter {
  void show();
}
//class InterImpl implements Inter {
//  @Override
//  public void show() {
//    System.out.println("你好");
//  }
//}

class Test {
  public static void main(String[] args) {
//     Inter inter = Outer.method();
//     inter.show();
    Outer.method().show();

  }
}