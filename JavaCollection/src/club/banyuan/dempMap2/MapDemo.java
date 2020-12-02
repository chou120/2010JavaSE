package club.banyuan.dempMap2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 3:53 下午
 */
public class MapDemo {

  public static void main(String[] args) {

    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    map.put("12", "12");
    map.put("13", "13");
    map.put("14", "14");
    map.put("15", "14");
    map.put("16", "14");
    map.put("17", "14");
    map.put("12", "126");

    System.out.println(map);

    Set<String> set = map.keySet();
    for (String s : set) {
      System.out.println(s + "--" + map.get(s));
    }

    TreeMap<String, Integer> treeMap = new TreeMap();
    treeMap.put("11", 11);
    treeMap.put("15", 61);
    treeMap.put("12", 1);
    treeMap.put("14", 31);
    treeMap.put("13", 211);

//    System.out.println(treeMap);
//
//    final Set<String> set1 = treeMap.keySet();
//
//    System.out.println(">>>"+set1);
    SortedMap<String, Integer> stringIntegerSortedMap = treeMap.headMap("13");

    System.out.println(stringIntegerSortedMap);

    //final String s = treeMap.ceilingKey("16");
    // System.out.println(s);
    Hashtable<String, Integer> hashtable = new Hashtable<>();
    hashtable.put("asdas", 12);
    //hashtable.put(null, 2121);
   // hashtable.put("", null);
    hashtable.put("张三", 21);
    System.out.println(hashtable);

    HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("asdas", 12);
    objectObjectHashMap.put(null, 2121);
    objectObjectHashMap.put("", null);
    objectObjectHashMap.put("张三", 21);
    System.out.println(objectObjectHashMap);

    /**Hashtable   HashMap
     *  上述两者的区别
     *
     *   前者键和值不可使用null,后者可以
     *        前者线程安全的,存储效率低
     *        后者线程不安全,存储效率高
     *
     */



  }
}
