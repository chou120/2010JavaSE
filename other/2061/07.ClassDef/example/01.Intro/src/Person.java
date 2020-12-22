public class Person {

  String name;
  int age;
  String sex;
  Person father;

  void print() {
    System.out.printf("我是%s，我%d岁，性别%s,我的父亲叫%s", name, age, sex, father.name);
  }

  /**
   * 属性
   * 名字
   * 年龄
   * 性别
   * 父亲(Person)
   *
   * 方法
   * 自报家门，我是xxx，我xx岁，我的父亲叫xxx
   */

}
