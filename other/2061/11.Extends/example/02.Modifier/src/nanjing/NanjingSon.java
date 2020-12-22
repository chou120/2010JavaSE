package nanjing;

import beijing.BeijingFather;
import beijing.BeijingSon;

public class NanjingSon extends BeijingFather {

  public static void main(String[] args) {
    BeijingFather beijingFather = new BeijingFather();
    BeijingSon beijingSon = new BeijingSon();
    NanjingSon nanjingSon = new NanjingSon();

    // beijingFather.defaultMethod();
    // beijingFather.protectedMethod();
    beijingFather.publicMethod();
    // beijingFather.privateMethod(); // 私有的只能在类中使用

    // beijingSon.defaultMethod();
    // beijingSon.protectedMethod();
    beijingSon.publicMethod();
    // beijingSon.privateMethod(); // 私有的只能在类中使用

    // nanjingSon.defaultMethod(); // 子类和父类不同包，不能使用父类中定义的默认权限的方法
    nanjingSon.protectedMethod(); // 父类中定义的protected方法，在子类内部可以使用，无论父类子类是否在相同的包路径下
    nanjingSon.publicMethod();
    // nanjingSon.privateMethod(); // 私有的只能在类中使用
  }
}
