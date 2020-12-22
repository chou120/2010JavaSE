package beijing;

import nanjing.NanjingSon;

public class BeijingNeighbor {

  public static void main(String[] args) {
    BeijingFather beijingFather = new BeijingFather();
    BeijingSon beijingSon = new BeijingSon();
    NanjingSon nanjingSon = new NanjingSon();

    beijingFather.defaultMethod();
    beijingFather.protectedMethod();
    beijingFather.publicMethod();
    // beijingFather.privateMethod(); // 私有的只能在类中使用

    beijingSon.defaultMethod();
    beijingSon.protectedMethod();
    beijingSon.publicMethod();
    // beijingSon.privateMethod(); // 私有的只能在类中使用

    // nanjingSon.defaultMethod(); // 子类和父类不同包，不能使用父类中定义的默认权限的方法
    nanjingSon.protectedMethod();
    nanjingSon.publicMethod();
    // nanjingSon.privateMethod(); // 私有的只能在类中使用

  }
}
