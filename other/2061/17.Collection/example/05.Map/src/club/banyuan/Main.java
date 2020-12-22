package club.banyuan;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    // 保存key value的映射关系。
    // key 不允许重复， value可以重复
    Map<String, String> map = new HashMap<>();
    map.put("张三", "13999999999");
    map.put("李四", "13312345678");
    map.put("李四", "22222222222");

    String zhangsanPhone = map.get("张三");
    System.out.println(zhangsanPhone);
    System.out.println(map);
  }
}
