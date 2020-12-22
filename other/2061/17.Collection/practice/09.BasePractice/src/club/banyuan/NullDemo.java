package club.banyuan;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class NullDemo {

  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    hashSet.add(null);

    // Set<String> treeSet = new TreeSet<>();
    // 不允许保存null元素，因为null元素需要被转换成Comparable对象
    // treeSet.add(null);

    // 指定了comparator，并在其中处理的null的情况，可以传入null元素
    Set<String> treeSet1 = new TreeSet<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1 == null && o2 == null) {
          return 0;
        } else if (o1 == null) {
          return 1;
        } else if (o2 == null) {
          return -1;
        }
        return o1.compareTo(o2);
      }
    });
    treeSet1.add(null);
    treeSet1.add(null);
    treeSet1.add(null);
    treeSet1.add("123");
    treeSet1.add("345");
    System.out.println(treeSet1);

    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add(null);
    linkedHashSet.add(null);
    System.out.println(linkedHashSet);

    Map<String, String> hashMap = new HashMap<>();
    hashMap.put(null, null);
    hashMap.put(null, "1234");
    System.out.println(hashMap);

    Map<String,String> treeMap = new TreeMap<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return 0;
      }
    });
    treeMap.put(null, "123");

    Map<String,String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(null,null);
    linkedHashMap.put("null",null);
    linkedHashMap.put("1234",null);
    System.out.println(linkedHashMap);
  }
}
