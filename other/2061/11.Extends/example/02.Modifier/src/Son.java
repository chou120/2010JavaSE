public class Son extends Father {


  public void getField() {
    // 不能够在子类内部直接使用父类中定义的私有的成员变量
    // System.out.println(fatherField);
    System.out.println(getFatherField());
    System.out.println(protectedField);
  }

  public static void main(String[] args) {
    Son son = new Son();
    // 子类对象可以直接使用父类中定义的public方法
    son.getFatherField();
    // son.fatherField;
    // son.privateMethod();
    son.getField();
    son.packageAccessMethod();
  }
}
