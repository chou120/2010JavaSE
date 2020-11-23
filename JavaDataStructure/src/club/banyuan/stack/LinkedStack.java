package club.banyuan.stack;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 3:07 下午
 */
public class LinkedStack {

  private Node head;
  private int size;
  //入栈，前插入构造链表，删除头结点实现栈；向后插入构造链表，删除头结点实现队列
  public void push(Object value){
    if (head ==null) {
      head = new Node(null, value);
    }else {
      head = new Node(head, value);
    }
  }
  //出栈
  public Object pop(){
    Object oldValue =null;
    if (head!=null) {
      oldValue = head.value;
      head = head.next;
    }
    return oldValue;
  }
  @Override
  public String toString() {
    Node temp = head;
    String result= "";
    while (temp!=null) {
      result +=temp.value+" ,";
      temp = temp.next;
    }
    return result;
  }
}
