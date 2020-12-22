package club.banyuan;

import java.util.ArrayList;
import java.util.Iterator;

public class Pairs<K, V> implements Iterable<OnePair<K, V>> {

  /* 声明一对对象的固定大小的数组（最多10个元素） */
  private OnePair<K, V>[] value = new OnePair[10];
  private int count = 0;

  /**
   * 创建一个集合，该集合将存储成对添加的项目。
   */
  public Pairs() {
  }
  //
  // public OnePair<K, V>[] getValue() {
  //   return value;
  // }
  //
  // public void setValue(OnePair<K, V>[] value) {
  //   this.value = value;
  // }
  //
  // public int getCount() {
  //   return count;
  // }
  //
  // public void setCount(int count) {
  //   this.count = count;
  // }

  /**
   * 创建一个新的对，并在有空间的情况下将其添加到集合中。
   *
   * @param first  The first object.
   * @param second The second object.
   */
  public boolean addPair(K first, V second) {
    if (count == value.length) {
      return false;
    }
    value[count++] = new OnePair<>(first, second);
    return true;
  }


  @Override
  public Iterator<OnePair<K, V>> iterator() {
    return new PairIterator();
    // return new PairIterator<>(this);
  }

  /*
   * 根据以下位置的API文档在此处实现迭代器
   * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
   * 按照规定抛出异常
   */
  private class PairIterator implements Iterator<OnePair<K, V>> {

    private int index = -1;

    @Override
    public boolean hasNext() {
      return index + 1 < count;
    }

    /**
     * 返回迭代器中的下一个对象
     */
    @Override
    public OnePair<K, V> next() {
      if (!hasNext()) {
        throw new IndexOutOfBoundsException("没有下一个元素");
      }

      return value[++index];
    }

    /**
     * 从集合中移除next（）返回的上一个对象。
     */
    @Override
    public void remove() {
      if (count - 1 - index >= 0) {
        System.arraycopy(value, index + 1, value, index, count - 1 - index);
      }
      value[--count] = null;
    }
  }

}