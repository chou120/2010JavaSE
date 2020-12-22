package club.banyuan;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

  // 保存数据
  private Object[] values;
  // 记录保存了多少个数据
  private int count;

  // 无参的构造方法调用另一个有参的构造方法，传递初始化数组的长度
  public MyArrayList() {
    this(10);
  }

  public MyArrayList(int capacity) {
    values = new Object[capacity];
  }

  /**
   * 更新数组指定下标的元素
   *
   * @param index   待更新的元素下标
   * @param element 更新后的元素对象
   * @return 被替换掉的旧对象
   */
  public T set(int index, T element) {
    // if (index < 0 || index >= count) {
    //   System.out.println("index 不合法");
    //   return null;
    // }
    indexIllegal(index);
    T oldOne = (T) values[index];
    values[index] = element;
    return oldOne;
  }

  /**
   * 查询指定位置下标的元素
   *
   * @param index 需要判断index是否合法
   * @return 返回查找到的元素，找不到返回null
   */
  public T get(int index) {
    indexIllegal(index);
    // if (index < 0 || index >= count) {
    //   System.out.println("index 不合法");
    //   return null;
    // }
    return (T) values[index];
  }

  void indexIllegal(int index) {
    if (index < 0 || index >= count) {
      throw new IndexOutOfBoundsException(index + "不合法");
    }
  }

  /**
   * 清空集合内容
   */
  public void clear() {
    values = new Object[values.length];
    count = 0;
  }

  /**
   * 删除指定下标的元素
   *
   * @param index 元素下标
   * @return 将删除的元素返回，如果下标不合理，返回null
   */
  public T remove(int index) {
    indexIllegal(index);
    T rlt = (T) values[index];
    // if (index == count - 1) {
    //   count--;
    //   values[index] = null;
    //   return rlt;
    // }
    // 从哪里开始  index + 1
    // 2  0
    // 考虑到了最后的边界的情况，传入数组长度的值是合法的，但是同时length必须等于0
    System.arraycopy(values, index + 1, values, index, count - index - 1);
    count--;
    return rlt;
  }

  /**
   * 查找并删除元素
   *
   * @param o 通过目标元素 equals 方法判断是否匹配，
   *          需要判断o是否为null，如果传入null，则用== 进行比较
   * @return
   */
  public boolean remove(T o) {
    for (int i = 0; i < count; i++) {
      if ((o == null && values[i] == null) || (o != null && o.equals(values[i]))) {
        remove(i);
        return true;
      }
    }

    return false;
  }


  /**
   * 添加一个元素
   *
   * @param o
   * @return 添加成功后返回true 失败返回false
   */
  public boolean add(T o) {
    // 判断数组是否需要扩容
    // 保存的元素个数是否和数组长度相等
    if (values.length == count) {
      // 将原始数组内容复制到新数组中
      // Object[] newObjArr = new Object[values.length * 2];
      // System.arraycopy(values, 0, newObjArr, 0, count);
      // 新建一个新数组，将传入数组的内容复制到新数组中，新数组长度由第二个参数指定
      values = Arrays.copyOf(values, values.length * 2);
    }
    // 添加元素
    values[count++] = o;
    return true;
  }

  /**
   * @return 数组中没有元素，返回true
   */
  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * 返回数组中保存的元素个数
   *
   * @return
   */
  public int size() {
    return count;
  }


  public static void main(String[] args) {

    MyArrayList<Integer> arrayList = new MyArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);

    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

    System.out.println(arrayList.isEmpty());

    System.out.println(arrayList.remove(1));

    System.out.println(arrayList.remove(Integer.valueOf(4)));

    System.out.println("============");

    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }
    arrayList.set(0, 200);
    System.out.println("+++++++++++++");
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

    MyArrayList<String> arrayList1 = new MyArrayList<>();
    arrayList1.add("123");
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      int pos = 0;

      @Override
      public boolean hasNext() {
        return count > pos;
      }

      @Override
      public T next() {
        return (T) values[pos++];
      }
    };
  }
}