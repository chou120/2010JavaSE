package club.banyuan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> {

  private Node<K, V>[] values = new Node[16];

  class Node<K, V> {

    K key;
    V value;
    int hash;
    Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      hash = key.hashCode();
    }

    @Override
    public String toString() {
      return "Node{" +
          "key=" + key +
          ", value=" + value +
          ", hash=" + hash +
          ", next=" + next +
          '}';
    }
  }

  public V put(K key, V value) {
    int hash = key.hashCode();
    int index = hash % values.length;
    Node<K, V> node = values[index];
    // 当前的数组的位置，还没有保存过数据，创建一个节点
    if (node == null) {
      values[index] = new Node<>(key, value);
    } else {
      // 第一个节点，进行判断
      if (node.key.equals(key)) {
        node.value = value;
        return value;
      }
      // 如果没有上面的判断，当节点长度为1时，不会进入while循环，因此没有进行该节点的比较
      while (node.next != null) {
        if (node.key.equals(key)) {
          node.value = value;
          return value;
        } else {
          // 如果没有找到匹配的key，则继续下一个节点寻找
          node = node.next;
        }
      }
      // 因为如果找到匹配的节点，while循环中已经进行了return，就不会走到这里来
      // 如果走到这里，表示没有找到匹配的key，则新增一个映射关系
      node.next = new Node<>(key, value);
    }
    return value;
  }

  public V remove(K key) {
    int hash = key.hashCode();
    int index = hash % values.length;
    Node<K, V> node = values[index];
    if (node == null) {
      return null;
    }
    // 第一个节点，如果满足，把数组保存第一个节点后面的节点，这样就把满足的节点断掉了
    if (node.key.equals(key)) {
      values[index] = node.next;
      return node.value;
    }
    while (node.next != null) {
      if (node.next.key.equals(key)) {
        // 找到了要被删除的节点， 被删除的节点引用是 node.next
        // 因此需要把node.next 的引用重新赋值，将next.next 这个引用赋值给next
        // 赋值之前需要先把next里面保存的数据缓存下来，不然一旦完成赋值，需要返回的数据保存的节点将找不不到了
        V rlt = node.next.value;
        node.next = node.next.next;
        return rlt;
      }
      node = node.next;
    }
    return null;
  }

  public Set<K> keySet() {
    Set<K> rlt = new HashSet<>();
    // 遍历所有的数组，每个数组都保存一个链表的头部节点，遍历所有的链表，将里面保存的key放到set中
    for (Node<K, V> value : values) {
      while (value != null) {
        rlt.add(value.key);
        value = value.next;
      }
    }
    return rlt;
  }

  @Override
  public String toString() {
    return "MyHashMap{" +
        "values=" + Arrays.toString(values) +
        '}';
  }

  public static void main(String[] args) {

    MyHashMap<String, String> myHashMap = new MyHashMap<>();
    myHashMap.put("1", "2");
    myHashMap.put("1", "2");
    myHashMap.put("1", "2");

    System.out.println(myHashMap);
    System.out.println(myHashMap.keySet());

    myHashMap.put("3", "3");
    myHashMap.remove("2");
    System.out.println(myHashMap);
    myHashMap.remove("1");
    System.out.println(myHashMap);


  }
}
