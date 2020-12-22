public class LinkedList<T> {

  // 头结点中的value保存链表的长度
  private Node<T> head;
  private int count = 0;

  public LinkedList() {
    head = new Node<>();
  }

  /**
   * 更新数组指定下标的元素
   *
   * @param index   待更新的元素下标
   * @param element 更新后的元素对象
   * @return 被替换掉的旧对象
   */
  public T set(int index, T element) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    Node<T> node = getNode(index);
    T rlt = node.getValue();
    node.setValue(element);
    return rlt;
  }

  /**
   * 查询指定位置下标的元素
   *
   * @param index 需要判断index是否合法
   * @return 返回查找到的元素，找不到返回null
   */
  public T get(int index) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    Node<T> node = getNode(index);
    return node.getValue();
  }

  private Node<T> getNode(int index) {
    // 遍历index次数，拿到指定的节点
    Node<T> node = head.getNext();
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node;
  }

  /**
   * 清空集合内容
   */
  public void clear() {
    Node<T> node = head.getNext();
    while (node != null) {
      Node<T> next = node.getNext();
      removeNode(node);
      node = next;
    }
  }

  /**
   * 删除指定下标的元素
   *
   * @param index 元素下标
   * @return 将删除的元素返回，如果下标不合理，返回null
   */
  public T remove(int index) {
    if (index < 0 || index >= size()) {
      System.out.println("下标不合法");
      return null;
    }
    Node<T> node = getNode(index);
    T rlt = node.getValue();
    removeNode(node);
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
    Node<T> node = head.getNext();
    while (node != null) {
      T value = node.getValue();
      if ((o == null && value == null) || (o != null && o.equals(value))) {
        removeNode(node);
        return true;
      } else {
        node = node.getNext();
      }
    }
    return false;
  }

  /**
   * 删除传入的节点元素
   * 将当前节点的前一个节点的下一个节点，设置为当前节点的下一个节点
   * 将当前节点的下一个节点的前一个节点，设置为当前节点的前一个节点
   *
   * @param node
   */
  private void removeNode(Node<T> node) {
    if (node == null) {
      return;
    }
    node.getPrev().setNext(node.getNext());
    if (node.getNext() != null) {
      node.getNext().setPrev(node.getPrev());
    }
    node.setNext(null);
    node.setPrev(null);
    node.setValue(null);
    addCount(-1);
  }


  /**
   * 添加一个元素
   *
   * @param o
   * @return 添加成功后返回true 失败返回false
   */
  public boolean add(T o) {
    Node<T> lastNode = head.getNext();

    // 如果链表是空的，追加第一个元素
    if (lastNode == null) {
      appendNode(head, o);
      addCount(1);
      return true;
    }
    // 找到链表中的最后一个元素
    while (lastNode.getNext() != null) {
      lastNode = lastNode.getNext();
    }
    // 最后一个元素后面追加一个元素
    appendNode(lastNode, o);
    addCount(1);
    return true;
  }

  private void addCount(int count) {
    this.count += count;
  }

  private void appendNode(Node<T> node, T o) {
    node.setNext(new Node<T>(o));
    node.getNext().setPrev(node);
  }

  /**
   * @return 数组中没有元素，返回true
   */
  public boolean isEmpty() {
    return size() == 0;
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

    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);

    for (int i = 0; i < linkedList.size(); i++) {
      System.out.println(linkedList.get(i));
    }

    System.out.println(linkedList.isEmpty());

    System.out.println(linkedList.remove(1));

    System.out.println(linkedList.remove(Integer.valueOf(4)));

    System.out.println("============");

    for (int i = 0; i < linkedList.size(); i++) {
      System.out.println(linkedList.get(i));
    }
    linkedList.set(0, 200);
    System.out.println("+++++++++++++");
    for (int i = 0; i < linkedList.size(); i++) {
      System.out.println(linkedList.get(i));
    }

    linkedList.clear();

    System.out.println(linkedList.isEmpty());
    System.out.println(linkedList.head);

  }
}
