package club.banyuan.staticDemo11.testStatic;

import club.banyuan.staticDemo11.Worker;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 11:09 上午
 */
public class Test {

  public static void main(String[] args) {
//    Worker.method2();
//    new  Worker().method1();
//    new Worker().method2(); //也可以通过创建对象来调用静态方法  因为静态方法和非静态方法都是属于Worker类的成员

    // System.out.println(Worker.country);

    //测试静态和非静态属性
    Worker worker = new Worker();
    worker.setName("阳刚");
    worker.setCountry("小日本");

    Worker worker2 = new Worker();
    worker2.setName("潘潘");
    worker2.setCountry("韩棒子");  //马来西亚  印度尼西亚  印度

    Worker worker3 = new Worker();
    worker3.setName("王子仁");
    worker3.setCountry("印度");

    System.out.println(worker);
    System.out.println(worker2);
    System.out.println(worker3);



  }
}
