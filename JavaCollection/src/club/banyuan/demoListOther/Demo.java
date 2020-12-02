package club.banyuan.demoListOther;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 10:48 上午
 */
public class Demo {

  public static void main(String[] args) {
    Stack<String> strings = new Stack<>();
    strings.push("张三");
    strings.push("三儿");
    strings.push("张儿");
    strings.push("两百字");
    strings.push("流氓");
    System.out.println(strings);

    System.out.println(strings.search("张儿"));
    System.out.println(strings.elementAt(3));
    System.out.println(strings.firstElement());
    System.out.println(strings.get(0));

    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.push("asdad1");
    linkedList.push("asdad2");
    linkedList.push("asdad3");
    linkedList.push("asdad4");
    linkedList.push("asdad5");

    System.out.println(linkedList.toString());

    Queue<String> queue = new ArrayDeque<>();
    queue.add("沾上干1");
    queue.add("沾上干2");
    queue.add("沾上干3");
    queue.add("沾上干4");
    queue.add("沾上干5");

    queue=new  LinkedList<>();

//    String element = queue.element();
//    final String poll = queue.poll();
    queue.add("沾上干1");
    queue.add("沾上干2");
    queue.add("沾上干3");
    queue.add("沾上干4");
    queue.add("沾上干5");
    String element = queue.element();
    final String poll = queue.poll();

    System.out.println(queue.toString() + "-----" + element+">>>>"+poll);




  }
}
