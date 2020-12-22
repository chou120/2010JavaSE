package club.banyuan;

public class StaticMethodDemo {

  public static void staticMethod() {
    // 静态方法无法使用this，因为方法调用的时候，还没有创建对象
    // this
    System.out.println("staticMethod");
    // 静态方法中不能通过方法名字直接调用实例方法
    // otherInstanceMethod();

    // 可以通过new 创建一个对象，调用对象的实例方法
    new StaticMethodDemo().otherInstanceMethod();
    new StaticMethodDemo().instanceMethodWithObj(new StaticMethodDemo());

    // 调用其他类的静态方法，需要指定类名字
    OtherCls.staticMethod();
  }

  public void instanceMethod() {
    System.out.println("instanceMethod");
    // 实例方法中，可以直接使用方法名调用另一个实例方法
    // 调用这个实例方法的对象，就是this
    otherInstanceMethod();
    // 实例方法中，可以直接调用静态方法
    staticMethod();

    // 调用其他类中的静态方法
    OtherCls.staticMethod();
    // 创建其他类的对象后，才能调用实例方法
    new OtherCls().instanceMethod();
  }

  // this默认传入的，是调用该方法的对象，如果传参是同一个对象，这是this == staticMethodDemo
  // 如果传参是new 的一个新对象，此时 this != staticMethodDemo
  public void instanceMethodWithObj(StaticMethodDemo staticMethodDemo) {
    otherInstanceMethod();
    staticMethodDemo.otherInstanceMethod();
  }

  public void otherInstanceMethod() {
    System.out.println("otherInstanceMethod");
  }

  public static void main(String[] args) {
    StaticMethodDemo demo = new StaticMethodDemo();
    demo.instanceMethod();
    // 可以使用对象调用静态方法
    demo.staticMethod();
    // 在同一个类的内部，可以直接调用静态方法(在静态方法中)
    staticMethod();
    // 无法在静态方法中直接通过方法名字调用实例方法
    // instanceMethod();

    demo.instanceMethodWithObj(demo);
    demo.instanceMethodWithObj(new StaticMethodDemo());
  }
}
