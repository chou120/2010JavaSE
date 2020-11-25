package club.banyuan.linkedList;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 8:02 下午
 */
public class TestLinkedList {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.add("213");
    linkedList.add("13");
    linkedList.add("23");
    linkedList.add("123");
    linkedList.add("3");

   // Object remove = linkedList.remove(2);
    //boolean remove = linkedList.remove("23");
   // System.out.println("移除是否:" + remove);
    Object set = linkedList.set(2, 45);
    System.out.println(">>>>>"+set);
    linkedList.print();

  }
}
