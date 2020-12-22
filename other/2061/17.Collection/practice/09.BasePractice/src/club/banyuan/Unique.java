package club.banyuan;

import java.util.HashSet;
import java.util.Set;

public class Unique {

  private Object[] values = new Object[10];

  public void add(Object target) {
    if (target == null) {
      return;
    }
    for (Object value : values) {
      if (target.equals(value)) {
        return;
      }
    }

    int hash = target.hashCode();
    int index = hash % values.length;
    values[index] = target;
  }

  /**
   * 过滤掉数组中的null元素
   *
   * @return
   */
  public Set<Object> values() {
    Set<Object> rlt = new HashSet<>();
    for (Object value : values) {
      if (value != null) {
        rlt.add(value);
      }
    }
    return rlt;
  }

  public static void main(String[] args) {
    // Unique unique = new Unique();
    // unique.add("1234");
    // unique.add("2234");
    // unique.add("1234");
    //
    // System.out.println(unique.values());

    Unique unique1 = new Unique();
    unique1.add(new Item("11"));
    unique1.add(new Item("12"));
    unique1.add(new Item("13"));

    System.out.println(unique1.values());

  }
}
