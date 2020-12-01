package club.banyuan.demoList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 3:41 下午
 */
public class MyCollection {


  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("张三丰1");
    linkedList.add("张三丰2");
    linkedList.add("张三丰3");
    linkedList.add("张三丰4");
    linkedList.add("张三丰5");   //顺序表的方式存储

    // 栈 现进后出
    linkedList.push("皮蛋");
    linkedList.push("卤蛋");
    linkedList.push("狗蛋");  //最后进去的在最上面
    linkedList.push("皮蛋");

    // System.out.println(linkedList.pop());
    // System.out.println(linkedList.poll());
    System.out.println(linkedList.peek());  //只是为了获取栈顶元素并没有移除栈顶元素
    System.out.println(linkedList.element());
    System.out.println("last:" + linkedList.getLast());
    System.out.println("index:" + linkedList.get(2));
    System.out.println("getFirst:" + linkedList.getFirst());
    //添加到栈顶  跟push一样
    System.out.println("offerFirst:" + linkedList.offerFirst("皮蛋"));
    System.out.println("offer:" + linkedList.offer("皮蛋Last"));

    System.out.println(linkedList.pollLast());

    System.out.println(linkedList);

    ArrayList<String> list = new ArrayList<>();
    list.add("哈哈哈谁撒谎1");
    list.add("哈哈哈谁撒谎2");
    list.add("哈哈哈谁撒谎3");
    list.add("哈哈哈谁撒谎5");
    list.add("哈哈哈谁撒谎4");
    list.add("哈哈哈谁撒谎8");

    ListIterator<String> stringListIterator = list.listIterator();

//    if (stringListIterator.hasNext()) {
//      System.out.println(stringListIterator.next() + "下标为:" + stringListIterator.nextIndex());
//    }
//
//    if (stringListIterator.hasPrevious()) {
//      System.out
//          .println(stringListIterator.previous() + "上一个下标:" + stringListIterator.previousIndex());
//    }
//    if (stringListIterator.hasNext()) {
//      System.out.println(stringListIterator.next() + "下标为:" + stringListIterator.nextIndex());
//    }

    stringListIterator.add("张三");
    stringListIterator.add("张三2");
    stringListIterator.add("张三3");

    if(stringListIterator.hasNext()){
      System.out.println(stringListIterator.next());
    }
    stringListIterator.add("张三4");

    //从指定的位置开始迭代
    final ListIterator<String> stringListIterator1 = linkedList.listIterator(5);
//
//    while(stringListIterator1.hasNext()){
//
//      System.out.println(">>>>>>"+stringListIterator1.next());
//      stringListIterator1.remove();
//    }
//
//    System.out.println("linkedList"+linkedList);

    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.println("-------------"+iterator.next());
      list.remove(0); //Exception in thread "main" java.util.ConcurrentModificationException
    }
    //一般迭代的情况下不建议使用更新操作
    System.out.println(list);

//    List<String>  list1=new ArrayList<>();
//    list1=new LinkedList<>();


    //Stack     Vector
    //Queue  先进先出


  }
}
