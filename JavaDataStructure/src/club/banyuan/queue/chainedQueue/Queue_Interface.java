package club.banyuan.queue.chainedQueue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 11:38 上午
 */
public interface Queue_Interface {

  void init();            //初始化队列

  void enter(Object obj); //入队列

  Object leave();         //出对列

  Object peek();          //返回队列的首元素

  boolean isEmpty();             //判断队列是否为空

  void clear();           //清空队列

  void print();           //打印队列


}
