package club.banyuan.linkedList;

public class Node {

  private Node prev;  //指向的是上一个节点(对象)
  private Node next; //指向的是下一个对象

  private Object value; //用来存放数据

  public Node() {
  }

  public Node(Node prev, Node next, Object value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public static void main(String[] args) {
    Node node = new Node();
    node.next = new Node();

    node.next.setValue(1);

    node.next.next = new Node();

    node.next.next.setValue(2);

    while (node != null) {
      System.out.println(node.getValue());
      node = node.next;
    }
  }
}
