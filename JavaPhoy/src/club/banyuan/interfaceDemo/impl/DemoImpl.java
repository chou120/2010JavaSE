package club.banyuan.interfaceDemo.impl;

import club.banyuan.interfaceDemo.Demo;
import club.banyuan.interfaceDemo.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 11:15 上午
 */
public class DemoImpl implements Demo {


  @Override
  public void login(String name, String pwd) {

  }

  @Override
  public void register(Object obj) {
       // obj=new User(); //自动类型提升了
      //显示obj所有的信息
   // System.out.println(obj.getUsername());
    User  user=(User)obj;
    System.out.println(user.getUsername());


  }
}

class TestInterface {

  public static void main(String[] args) {
    Demo demo = new DemoImpl();
    //demo.login();
    demo.register(new User("张三", "123456" ));

  }
}
