package club.banyuan.queue.chainedQueue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 11:39 上午
 */
public class LinkQueue implements Queue_Interface {

  private Node front, rear;                      //定义头指针、尾指针
  /**
   * 清空队列
   */
  @Override
  public void clear() {
    front = rear = null;
    System.out.println("队列已清空");
  }

  /**
   * 入队列
   */
  @Override
  public void enter(Object obj) {
    if(rear == null) {                         //当队列为空时
      front = rear = new Node(obj, null);    //队尾指针和头指针相同
    } else {							       //队列不为空
      rear = rear.next = new Node(obj, null);//尾指针永远指向空
    }
  }

  /**
   * 初始化
   */
  @Override
  public void init() {
    front = rear = null;
  }

  /**
   * 判断是否为空
   */
  @Override
  public boolean isEmpty() {
    return front == rear;
  }

  /**
   * 出队列
   */
  @Override
  public Object leave() {
    if(front == null) {                        //先判断是不是为空
      return null;
    }else {
      Node p = front;                        //先得把头指针保存起来，不然就丢了
      front = front.next;
      if(front == null)                      //需要判断是不是为空
        rear = null;                       //为空的话尾指针必须要为null
      System.out.println("执行出队列操作，出队列的元素为：" + p.date);
      return p.date;
    }
  }

  /**
   * 返回队首元素
   */
  @Override
  public Object peek() {
    if(front == null) {
      System.out.println("队首元素为空");
      return null;
    } else {
      System.out.println("队首元素为：" + front.date);
      return front.date;                     //不为空的时候返回头指针的值
    }
  }

  /**
   * 打印出队列中的信息
   */
  @Override
  public void print() {
    Node p = front;
    System.out.println("当前队列中的元素为：");
    while(p != null) {
      System.out.print(p.date + " ");
      p = p.next;
    }
  }
}


class  Test{
  public static void main(String [] args) {
    LinkQueue lk = new LinkQueue();
    lk.init();
    lk.enter("a");
    lk.enter("b");
    lk.enter("c");
    lk.enter("d");
    lk.print();
    lk.peek();
    lk.leave();
    lk.print();
  }
}