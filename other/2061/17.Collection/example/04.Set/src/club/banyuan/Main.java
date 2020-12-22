package club.banyuan;

import com.sun.source.doctree.SeeTree;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    // 不能重复保存相同的元素
    // 在HashSet和LinkedHashSet中，根据equals() 和hashCode 是否相同来判定元素是否相同
    // 比较常用的用法，去重
    Set<Integer> hashSet = new HashSet<>();
    hashSet.add(1);
    hashSet.add(2);
    hashSet.add(3);
    hashSet.add(4);

    for (Integer integer : hashSet) {
      System.out.println(integer);
    }

    System.out.println("添加一个1");
    hashSet.add(1);

    Iterator<Integer> iterator = hashSet.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    Set<String> strings = new HashSet<>();
    strings.add("张三");
    strings.add("张三");
    strings.add("张三");
    System.out.println(strings);

    Set<User> users = new HashSet<>();
    users.add(new User("张三", "123456"));
    users.add(new User("张三", "123456"));
    users.add(new User("张三", "123456"));
    users.add(new User("李四", "123456"));
    users.add(new User("王五", "123456"));
    System.out.println(users);

    // linkedHashSet 会记录 元素的添加顺序
    Set<User> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add(new User("张三", "123456"));
    linkedHashSet.add(new User("李四", "123456"));
    linkedHashSet.add(new User("王五", "123456"));
    System.out.println(linkedHashSet);

    // TreeSet保存的数据必须实现Comparable接口
    // 去重规则，按照比较的规则进行去重
    Set<User> treeSet = new TreeSet<>();
    treeSet.add(new User("C", "123456"));
    treeSet.add(new User("C", "123456"));
    treeSet.add(new User("B", "123456"));
    treeSet.add(new User("B", "666"));

    System.out.println(treeSet);

    // 如果保存的数据不能是实现Comparable，就传递一个Comparator
    // Set<User> userSet = new TreeSet<>(new Comparator<User>() {
    //   @Override
    //   public int compare(User o1, User o2) {
    //     return 0;
    //   }
    // });
  }
}
