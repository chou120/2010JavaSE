package club.banyuan.linkedList;

public class LinkedList {

  private Node head;

  private int count;//用来统计有多少个节点

  public LinkedList() {
    //在创建LinkedList对象的时候,初始化头结点
    head = new Node();
    head.setValue(0);
    count++;
  }

  /**
   * 更新数组指定下标的元素
   *
   * @param index   待更新的元素下标
   * @param element 更新后的元素对象
   * @return 被替换掉的旧对象
   */

  public Object set(int index, Object element) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    Node next = head.getNext();
    for (int i = 0; i < index; i++) {
      next = next.getNext();
    }
    Object value = next.getValue();
    next.setValue(element);
    return value;
  }

  /**
   * 查询指定位置下标的元素
   *
   * @param index 需要判断index是否合法
   * @return 返回查找到的元素，找不到返回null
   */
  public Object get(int index) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    // 遍历index次数，拿到指定的节点
    Node node = head.getNext();
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    //找到和index位置一样的node
    return node.getValue();
  }

  /**
   * 清空集合内容
   */
  public void clear() {
    head.setNext(null); //设置头结点的下一个节点为null
  }

  /**
   * 删除指定下标的元素
   *
   * @param index 元素下标
   * @return 将删除的元素返回，如果下标不合理，返回null
   */
  public Object remove(int index) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    Node next = head.getNext();
    //找到要移除的节点对象的前面一个对象 next
    for (int i = 0; i < index - 1; i++) {
      next = next.getNext();
    }
    //获取要移除节点的后面一个节点
    Node next1 = next.getNext().getNext();
    Node no = next.getNext();
    next.setNext(next1);
    count--;
    return no.getValue();
  }

  /**
   * 查找并删除元素
   *
   * @param o 通过目标元素 equals 方法判断是否匹配， 需要判断o是否为null，如果传入null，则用== 进行比较
   * @return
   */
  public boolean remove(String o) {
    //定义一个计数器
    int key = 0;
    Node node = head.getNext();
    String value = (String) node.getValue();
    if (o == null && value == null) {
      return false;
    }
    while (node != null) {
      if (o != null && o.equals(value)) {
        //如果找到了就移除
        Node next = node.getNext(); //要移除节点的后面一个节点
        Node removePrevNode = findRemovePrevNode(key - 1);//同时要找到上一个节点
        System.out.println("移除节点的上一个节点为:" + removePrevNode.getValue());
        removePrevNode.setNext(next);//上一个节点和下一个节点进行关联
        count--;
        return true;
      } else {
        key++;
        node = node.getNext();
        value = (String) node.getValue();
      }
    }
    return false;
  }

  /**
   * 找到上一个节点
   *
   * @param index
   */
  private Node findRemovePrevNode(int index) {
    Node next = head.getNext();
    for (int i = 0; i < index; i++) {
      next = next.getNext();
    }
    return next;
  }

  /**
   * 添加一个元素
   *
   * @param o
   * @return 添加成功后返回true 失败返回false
   */
  public boolean add(Object o) { //添加的是数据
    Node next = head.getNext();
    //如果头结点后面没有节点,也就是链表为空
    Node node = new Node();
    node.setValue(o);

    if (next == null) {
      head.setNext(node);
      return true;
    }
    //如果头节点后面有数据,那么我们可以使用循环的方式找到最后一个节点
    while (next.getNext() != null) {
      next = next.getNext();
    }
    //当next为空的时候,next肯定表示的是最后一个节点
    next.setNext(node);
    count++;
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

  public void print() {
    Node next = head.getNext();
    while (next != null) {
      System.out.println(next.getValue());
      next = next.getNext();
    }
  }
}
