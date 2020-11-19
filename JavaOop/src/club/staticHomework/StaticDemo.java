package club.staticHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 3:01 下午
 */
public class StaticDemo {

  StaticDemo sd = new StaticDemo();
  void method1() {
    method4();  // 1
    StaticDemo.method2(); // 2
    //method3(); // 3  类名.成员
  }
  static void method2() {

  }
  void method3() {
    method1(); //4
    method2(); //5
    sd.method2(); //6
  }
  static void method4() {
  }

}