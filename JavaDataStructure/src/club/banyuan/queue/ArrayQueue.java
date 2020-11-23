package club.banyuan.queue;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/23 9:28 上午
 */
public class ArrayQueue implements Queue {

  private String[] data;
  private int size;//元素个数
  private int front;//队列中第一个对象的位置,队头
  private int rear;//队列中当前对象的位置,队尾


  public ArrayQueue() {
    this.data = new String[10];
    this.size = 0;
    this.front = 0;
    this.rear = 0;
  }

  @Override
  public void add(String str) {
    if(isFull()){
      //如果满了就重新扩容
      resize();
      front=0;
    }
    //获取到的是队尾
    rear=(front+size)%data.length;
    data[rear]=str;
    size++;
  }

  //扩容方法
  private void resize() {
     String[] strings = new String[data.length * 2];
     System.arraycopy(data, 0,strings, 0,data.length);
     this.data=strings;
     strings=null;//重新设置为空 为了可以垃圾回收
  }

  @Override
  public String remove() {
    if(isEmpty()){
      throw new RuntimeException("队列是空的");
    }
    //移除的永远是队头
    String datum = data[front];
    data[front]=null;
    front=(front+1)%(data.length);
    size--;
    return datum;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String front() {
    if(isEmpty()){
      throw new RuntimeException("队列为空");
    }
    return data[front];
  }

  @Override
  public boolean isEmpty() {
    return size==0;
  }

  @Override
  public boolean isFull() {
    return size==data.length;
  }


  @Override
  public String toString() {
    return "ArrayQueue{" +
        "data=" + Arrays.toString(data) +
        ", size=" + size +
        ", front=" + front +
        ", rear=" + rear +
        '}';
  }
}
