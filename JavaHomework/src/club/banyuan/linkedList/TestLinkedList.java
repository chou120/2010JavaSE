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

    //Object remove = linkedList.remove(4);
    //boolean remove = linkedList.remove("3");
    // System.out.println("移除:" + remove);
    Object set = linkedList.set(4, 45);
     System.out.println(">>>>>"+set);
    linkedList.print();

  }
}
