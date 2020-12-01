package club.banyuan.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 10:31 上午
 */
public class MyCollection {

  /**
   * 数组: 一段连续的存储空间,存放的是相同数据类型数据,数组的长度一旦定义就不能变
   * <p>
   * 集合: 可以存放相同的数据,可以改变长度 1024GB =1TB    1PB =1024TB   2^10
   */
  public static void main(String[] args) {
    Collection con = new ArrayList<>();

    User user = new User("沾上干", 12);
    con.add("1231");
    con.add(123);
    con.add('a');
    con.add(89.9);
    con.add(true);
    con.add(user);

    Collection con2 = new ArrayList<>();
    con2.add("1231312231");
    con2.add(1243);
    con2.add('b');
    con2.add(89.9);
    con2.add(true);
    con2.add(new User("沾上干", 12));

    //System.out.println(con);
    Object[] objects = con.toArray();

//    for (int i = 0; i <con.size(); i++) {
//      System.out.println(objects[i]);
//    }
//    for (Object object : objects) {
//      System.out.println(object);
//    }

//    for (Object o : con) {
//      System.out.println(">>>>"+o);
//    }
//     Iterator iterator = con.iterator(); //用来迭代集合里面的数据  迭代 == 遍历
//     while (iterator.hasNext()){
//        Object next = iterator.next();
//       System.out.println(">>>>"+next);
//     }

//    con.addAll(con2);
//
//    System.out.println(con);
//
//    con.removeAll(con2);
//    System.out.println(con);

    //con.remove(user);
   // System.out.println(con.contains(89.9));
//    for (Object o : con) {
////      User  u=(User)o;  //ClassCastException
////      System.out.println(u.getName());
//      if(o instanceof User){
//        User  user1=(User)o;
//        System.out.println(user1.getName());
//      }
//    }

    //在做添加的时候给出限制,只能添加一种数据
    Collection<User> con1 = new ArrayList<User>();  //泛型写法
    con1.add(new User("asda ", 21));  //添加不同数据类型时候直接报错
    for (User user1 : con1) {
      System.out.println(user1);
    }





  }
}

class User {

  private String name;
  private Integer age;

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
}
