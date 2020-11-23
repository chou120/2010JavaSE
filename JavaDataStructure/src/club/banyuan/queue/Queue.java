package club.banyuan.queue;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 9:26 上午
 */
public interface Queue {

  void add(String str);

  String remove();

  //队列长度
  int  size();
  //返回对头元素,并未删除
  String  front();
  //是否为空
  boolean   isEmpty();
  //是否已满
  boolean  isFull();

}
