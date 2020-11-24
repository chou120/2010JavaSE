package club.banyuan.interfaceDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 11:08 上午
 */
public interface Demo {

  /**
   *  接口作为一种开发的规范而存在
   *        可以添加额外的功能
   *
   *        在反射可以去实现
   */
    public  abstract    void  login(String name,String pwd);  //接口里面是抽象方法

    //jdk  1.8以后有默认的方法
    //  default  void  method(String  name){
    //
    //  }

    void   register(Object  obj);


}
