package club.banyuan.demoListOver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 10:19 上午
 */
public class Test {

  public static void main(String[] args) {


    List<Book> listBook = new ArrayList<>();
    listBook.add(new Book("十万个为什么", 34.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("d万个为什么", 2.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("8万个为什么", 121.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("7万个为什么", 24.0, "中国人民出版社", "xxx"));
    listBook.add(new Book("b万个为什么", 2.0, "中国人民出版社", "xxx"));

//    listBook.sort(new Comparator<Book>() {
//      @Override
//      public int compare(Book o1, Book o2) {
//        Double  number= o1.getPrice()-o2.getPrice() ;
//        int  key=10;
//        if(number>0){
//          key=1;
//        }else  if(number<0){
//          key=-1;
//        }else{
//          key=0;
//        }
//        int  number1=  key == 0 ?  o1.getName().compareTo(o2.getName()) : key;
//        return number1;
//      }
//    });
   // listBook.sort(new MyComparetor());

  //Collections.sort(listBook);
  //  Collections.sort(listBook, new MyComparetor());
   // System.out.println(listBook);

    List<String> list=new ArrayList<>();
    list.add("Z");
    list.add("A");
    list.add("D");
    list.add("U");
    list.add("C");

   //Collections.reverse(list);  //
    Collections.shuffle(list);
    String max = Collections.max(list);

    System.out.println(max);
    //数组类的单列集合  ArrayList  LinkedList  Stack    Vector  Queue




  }
}
