package club.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 9:17 上午
 */
public class Demo {
/*1.分析以下需求，并用代码实现：
      (1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合
      (2)编写方法对List集合进行排序
      (2)然后利用迭代器遍历集合元素并输出
      (3)如：15 18 20 40 46 60 65 70 75 91
  2.编写一个类Book，具有name,price,press,author 然后创建5个对象
      放入ArrayList中，并实现按照price大小排序，
      然后遍历ArrayList输出每个Book对象, 使用toString 方法打印。
  3.把如下元素存入List集合
    “aaa” “bbb” “aaa” “abc”“xyz” “123” “xyz”
  去掉重复元素
  4.某中学有若干学生(学生对象放在一个List中)，每个学生有一个姓名属性(String)、班级名称属性(String)和考试成绩属性(double) 
  某次考试结束后，每个学生都获得了一个考试成绩。遍历list集合，并把学生对象的属性打印出来*/

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      int number = (int) (Math.random() * 100) + 1;
      if (!list.contains(number)) {
        list.add(number);
      } else {
        i--; //如果包含就自减一次
      }
    }

//    final List<Integer> sort = sort(list);
//
//    System.out.println(sort);

    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    System.out.println(list);

    List<Book> listBook = new ArrayList<>();
    listBook.add(new Book("十万个为什么", 34.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("9万个为什么", 2.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("8万个为什么", 121.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("7万个为什么", 24.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("1万个为什么", 2.0, "中国人民出版社", "xxx"));

    listBook.sort(new Comparator<Book>() {
      @Override
      public int compare(Book o1, Book o2) {
        //思考:如果价格一样 根据名字排序
        return o1.getPrice()-o2.getPrice() > 0 ? 1 : -1;   //1.5-2.0  (int)(-0.5)
      }
    });

   // System.out.println((int) (0.5 - 2.0));
    for (Book book : listBook) {
      System.out.println(book);
    }


    // “aaa” “bbb” “aaa” “abc”“xyz” “123” “xyz”
    List<String> stringList=new ArrayList<>();
    stringList.add("aaa");
    stringList.add("bbb");
    stringList.add("aaa");
    stringList.add("abc");
    stringList.add("xyz");
    stringList.add("123");
    stringList.add("xyz");

    //去重
    List<String> stringList2=new ArrayList<>();
    for (String s : stringList) {
      if(!stringList2.contains(s)){
        stringList2.add(s);
      }
    }
    System.out.println(stringList2);



  }

  public static List<Integer> sort(List<Integer> list) {
    Object[] integers = list.toArray();
    for (int i = 0; i < integers.length; i++) {
      for (int j = 0; j < integers.length - 1 - i; j++) {
        if ((int) (integers[j]) > (int) (integers[j + 1])) {
          int temp = (int) integers[j];
          integers[j] = integers[j + 1];
          integers[j + 1] = temp;
        }
      }
    }
    List<Integer> list1 = new ArrayList<>();
    for (Object object : integers) {
      Integer integer = (Integer) object;
      list1.add(integer);
    }
    return list1;
  }
}
