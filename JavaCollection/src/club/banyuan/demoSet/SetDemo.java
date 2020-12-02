package club.banyuan.demoSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/2 1:37 下午
 */
public class SetDemo {

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("王子仁");
    set.add("刘芳宇");
    set.add("陈聪");
    set.add("高剑通");   //存储的顺序不一定就是添加的顺序
    //set.add("陈聪");   不允许有重复值,如果有重复值那就使用后面的替代前面
//
//    List<String>  list=new ArrayList<>();
//    list.add("aaa");
//    list.add("bbb");
//    list.add("ccc");
//    list.add("aaa");
//    list.add("ddd");
//
//    for (String s : list) {
//      set.add(s);
//    }
//
//    System.out.println(set);
//
//    //有一组数据   int  [] in={12,4,42,3,12,3,4,56};
//    Integer  [] in={12,4,42,3,12,3,4,56};
//    final List<Integer> ints = Arrays.asList(in);
//
//    //  contains
//    Set<Integer> setInteger=new HashSet<>();
//    for (Integer anInt : ints) {
//      setInteger.add(anInt);
//    }
//    Integer[] ins={};
//
//    final Integer[] integers = setInteger.toArray(ins);
//
//    System.out.println(">>>>>>"+Arrays.toString(integers));

    HashSet<String> set1 = new HashSet<>(); //HashMap

    LinkedHashSet<String> stringLinkedHashSet = new LinkedHashSet<>();

    /**
     * 链表保证数据有序
     * 哈希表保证数据唯一
     */

    stringLinkedHashSet.add("王子仁");
    stringLinkedHashSet.add("刘芳宇");
    stringLinkedHashSet.add("陈聪");
    stringLinkedHashSet.add("陈慧琳");
    stringLinkedHashSet.add("高剑通");
    stringLinkedHashSet.add("陈慧琳");

    System.out.println(stringLinkedHashSet);

    TreeSet<Integer> treeSet = new TreeSet<>();
    treeSet.add(213);
    treeSet.add(23);
    treeSet.add(13);
    treeSet.add(26);
    treeSet.add(20);
    treeSet.add(78);
    treeSet.add(13);
    // 红黑树+hash表

    // System.out.println(treeSet+">>>>"+treeSet.floor(89));
    // treeSet.comparator();
    final Integer first = treeSet.first();
    //  System.out.println(">>>>>"+first);

    final Iterator<Integer> integerIterator = treeSet.descendingIterator();
    while (integerIterator.hasNext()) {
      System.out.println(">>>>>" + integerIterator.next());
    }

    final Integer lower = treeSet.lower(20);
    System.out.println("........"+lower);

    final SortedSet<Integer> integers = treeSet.tailSet(23);

    System.out.println("-------"+integers);


    TreeSet<User>  treeSet1=new TreeSet<User>();
    treeSet1.add(new User("张三", 28));
    treeSet1.add(new User("张三", 27));
    treeSet1.add(new User("李四五", 25));
    treeSet1.add(new User("找了六七", 13));
    treeSet1.add(new User("姗姗啊", 33));
    treeSet1.add(new User("姗姗啊", 33));

    System.out.println(treeSet1);

    List<String>  stringList=new ArrayList<>();
    stringList.add("沾上干1");
    stringList.add("沾上干2");
    stringList.add("沾上干3");
    stringList.add("沾上干4");
    stringList.add("沾上干5");


    List<String>  stringList2=new ArrayList<>();
    stringList2.add("沾上干1");
    stringList2.add("沾上干7");
    stringList2.add("沾上干6");
    stringList2.add("沾上干4");
    stringList2.add("沾上干5");

    Set<List<String>> set2=new HashSet<>();
    set2.add(stringList);
    set2.add(stringList2);

    System.out.println("=========");
    System.out.println(set2);





  }
}
class User  implements   Comparable<User>{
  private String name;
  private Integer age;

  public User() {
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public int compareTo(User o) {
    int  length=this.getName().length()-o.getName().length();
    int  number=length==0?this.getName().compareTo(o.getName()):length;
    int  result= number==0? this.getAge()-o.getAge() :number;
    return result;
  }
}