package club.banyuan.demoMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 2:54 下午
 */
public class MapDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();  //哈希表存储

    map.put("刘备", 3);
    map.put("曹操", 1);
    map.put("孙权", 2);
    map.put("袁绍", 4);
    map.put("董卓", 5);
    map.put("詹姆斯", 23);
    map.put("马腾", 12);
    map.put("詹姆斯", 12);

    //System.out.println(map);
    //
    Set<String> set = map.keySet();
    for (String s : set) {
      System.out.println("键是:" + s + ",值是:" + map.get(s));
    }

    final Collection<Integer> values = map.values();
    System.out.println(values);

    final Integer integer = map.remove("詹姆斯");
    System.out.println("詹姆斯的值为:" + integer);

    final Integer integer1 = map.replace("曹操", 56);
    System.out.println(integer1);

    System.out.println(map.containsValue(12));

    System.out.println(map);

    //HashMap和CurrentHashMap两个的底层实现原理以及他们的区别



  }
}
