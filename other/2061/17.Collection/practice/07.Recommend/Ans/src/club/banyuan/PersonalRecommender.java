package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PersonalRecommender {

  private Map<String, List<String>> likes = new HashMap<>();


  public void addLikes(String name, String subject) {
    // 先从map中根据key获取映射内容
    List<String> oneLikes = likes.get(name);
    // 如果map之前不存在这个key，则返回的映射内容为Null
    if (oneLikes == null) {
      // 如果是null，说明之前没有保存过这个映射关系，新建一个list，保存方法传入的subject
      oneLikes = new ArrayList<>();
      // 将列表的关联关系设置到map中
      likes.put(name, oneLikes);
    }

    // 如果用户喜欢的列表中，已经包含了这个内容，不需要做任何操作
    if (containsSubject(subject, oneLikes)) {
      return;
    }
    // 如果不包含，则加入到列表中
    oneLikes.add(subject);

    // if (likes.containsKey(name)) {
    //   List<String> one = likes.get(name);
    //   if (containsSubject(subject, one)) {
    //     return;
    //   }
    //   one.add(subject);
    // } else {
    //   List<String> one = new ArrayList<>();
    //   one.add(subject);
    //   likes.put(name, one);
    // }
  }

  // 判断用户喜欢的列表中，是否已经包含了传入的subject
  // false 没有包含  true 包含
  private boolean containsSubject(String subject, List<String> oneLikes) {
    for (String oneSubject : oneLikes) {
      if (oneSubject.equals(subject)) {
        return true;
      }
    }
    return false;
  }

  public boolean likeBoth(String name, String sub1, String sub2) {
    if (!likes.containsKey(name)) {
      throw new UnknownPersonException();
    }

    List<String> oneLikes = likes.get(name);
    // 先遍历已有的关联关系，遍历每个人喜欢的列表，如果这个列表里面包含了当前这个人的喜欢的内容
    // 就把这个列表放到一个大的集合中。最后判断 sub1 和 sub2 是不是同时被包含在这个大的集合中

    // 使用set保存最后的喜欢的列表，为了去重，使用set
    Set<String> finalLikes = new HashSet<>();

    Collection<List<String>> values = likes.values();

    for (List<String> value : values) {
      // 遍历每个人喜欢的列表
      for (String oneSubject : oneLikes) {
        //依次遍历这个人喜欢的东西
        //  如果这个人喜欢的东西包含在另一个人喜欢的列表中，就把这个列表加到大的集合中
        if (value.contains(oneSubject)) {
          finalLikes.addAll(value);
          break;
        }
      }
    }

    // 判断是否这两个项目同时包含在最后的列表中
    return finalLikes.containsAll(Arrays.asList(sub1, sub2));

  }


  /**
   * 根据人名返回可能会喜欢的列表
   *
   * @param name
   * @return
   */
  public List<String> recommendByPerson(String name) {
    List<String> personLike = likes.get(name);
    if (personLike == null) {
      throw new UnknownPersonException();
    }
    // 如果反复添加其他人的喜欢的列表到集合中，有可能会出现重复的
    // 使用set去除重复的内容
    // 初识内容，包括了这个人所喜欢的全部内容
    Set<String> recommendRlt = new HashSet<>(personLike);

    // 遍历其他人喜欢的列表，如果有包含在这个人喜欢的列表中，则把其他人喜欢的列表包含在最终的结果集中
    Set<Entry<String, List<String>>> entries = likes.entrySet();

    for (Entry<String, List<String>> entry : entries) {
      // 人名字
      String key = entry.getKey();
      // 如果是本人，则跳过这一次比较
      if (name.equals(key)) {
        continue;
      }
      // 这个人喜欢的列表
      List<String> value = entry.getValue();
      // 判断value和personLike 有没有交集
      if (intersection(value, personLike)) {
        recommendRlt.addAll(value);
      }
    }

    return new ArrayList<>(recommendRlt);
  }

  public List<String> recommendByProject(String subject) {
    Set<String> recommendRlt = new HashSet<>();
    for (List<String> value : likes.values()) {
      // 如果喜欢列表包含此项目的，把整个列表加入到最终的集合中
      if (value.contains(subject)) {
        recommendRlt.addAll(value);
      }
    }
    // 最终的结果中不包含传入的subject
    recommendRlt.remove(subject);
    return new ArrayList<>(recommendRlt);
  }

  // private boolean intersection(List<String> l1, List<String> l2) {
  //   List<String> copy1 = new ArrayList<>(l1);
  //   List<String> copy2 = new ArrayList<>(l2);
  //
  //   // 取copy1和copy2集合的交集，copy1中将保留交集的内容。
  //   copy1.retainAll(copy2);
  //   return !copy1.isEmpty();
  // }

  /**
   * 更通用的比较两个集合是否有交集的方法
   *
   * @param l1
   * @param l2
   * @param <T> 使用T 指定方法为泛型方法，编译器将在编译阶段，检查传入的两个集合的泛型，必须是一致的
   * @return
   */
  private <T> boolean intersection(Collection<T> l1, Collection<T> l2) {
    List<T> copy1 = new ArrayList<>(l1);
    List<T> copy2 = new ArrayList<>(l2);

    // 取copy1和copy2集合的交集，copy1中将保留交集的内容。
    copy1.retainAll(copy2);
    return !copy1.isEmpty();
  }

  // public static <T> T demo(T a, T b) {
  //   return a;
  // }

  //
  // public static void main(String[] args) {
  //   // 这样是合理的，因为编译器认为，传入的两个参数的数据类型都是Object，因此类型也是一样的
  //   demo(new UnknownPersonException(),
  //       new UnknownPersonException());
  // }

}
