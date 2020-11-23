package club.banyuan.queue.chainedQueue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 11:40 上午
 */
public class Node {
  Object date;
  Node next;
  public Node(Object obj, Node nt) {
    this.date = obj;
    this.next = nt;
  }
}
