package club.banyuan.genHigh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 2:53 下午
 */
public class Test {

  public static void main(String[] args) {
    Collection<String> a1 = new ArrayList<String>();
    a1.add("a");
    a1.add("b");
    a1.add("c");

    Collection<Integer> a2 = new ArrayList<Integer>();
    a2.add(1);
    a2.add(2);
    a2.add(3);

    Genric.printList(a2);
    Genric.printList(a1);

    // Genric.printList(a2);

    /* Genric<String> objectGenric = new Genric<>();
    objectGenric.printList1(a2);*/

  }
}

class Genric<T> {

//  public  <T> void printList1(Collection<T> list) {
//    Iterator<T> iterator = list.iterator();
//    while (iterator.hasNext()){
//      T object = iterator.next();
//      System.out.println(object);
//    }
//  }


  public static void printList(Collection<?> list) {  //未知的

    Iterator<?> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}

//定义一个Person类
class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getNmae() {
    return this.name;
  }
}

// 定义一个Student 并继承 Person
class Student extends Person {

  Student(String name) {
    super(name);
  }

  //main方法如下
  public static void main(String[] args) {

    ArrayList<Person> a1 = new ArrayList<Person>();
    a1.add(new Person("abc1"));
    a1.add(new Person("abc2"));
    a1.add(new Person("abc3"));

    printMethod(a1);

    // 下面是错误的。a2存的是Person，存在继承的话，也能放worker。
    // 但是等号右边只能存Student，存不进worker.类型安全问题。左右两边要一致
    // ArrayList<Person> a2 = new ArrayList<Student>();
    // 如果我想调用也`printMethod(a2);`怎么做？。

    ArrayList<Student> a2 = new ArrayList<Student>();
    a2.add(new Student("abc--1"));
    a2.add(new Student("abc--2"));
    a2.add(new Student("abc--3"));
    printMethod(a2);

    ArrayList<Work> a3 = new ArrayList();
    ArrayList<Object> a4 = new ArrayList();
    //printMethod(a3); 类型之间没有任何关系并不能调用此方法


    printMethod2(a1);
//    printMethod2(a2);
//    printMethod2(a3);
//    printMethod2(a4);

  }

  //向下限定  person所有的子类都不能传递过来
  public static void printMethod2(ArrayList<?  super   Person> a1) {
    Iterator<? super Person> it = a1.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  //向上限定   能接收Person及其子类数据的集合
  //没有使用泛型方法  只是使用了通配符的方式
  public static void printMethod(ArrayList<?  extends  Person> a1) {
    Iterator<? extends Person> it = a1.iterator();
    while (it.hasNext()) {
      System.out.println(it.next().getNmae());
    }
  }


//  public static void printMethod(ArrayList<Person> a1) {
//    Iterator<Person> it = a1.iterator();
//    while (it.hasNext()) {
//      System.out.println(it.next().getNmae());
//    }
//  }

}

class  Work{

  public static void main(String[] args) {

  }

}
