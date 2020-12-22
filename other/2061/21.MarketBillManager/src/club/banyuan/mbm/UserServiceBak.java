package club.banyuan.mbm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceBak {

  // 为每个用户分配一个唯一id
  private static int idCount = 1;
  private List<User> userList = new ArrayList<>();

  // {
  //   User u1 = new User();
  //   u1.setName("a");
  //   u1.setPwd("123456");
  //   u1.setUserType(1);
  //
  //   User u2 = new User();
  //   u2.setName("b");
  //   u2.setPwd("123456");
  //   u2.setUserType(0);
  //
  //   userList.add(u1);
  //   userList.add(u2);
  // }

  // 向列表中添加用户
  public void addUser(User user) {
    // 为用户生成一个唯一的id
    user.setId(idCount++);
    userList.add(user);
  }

  // 删除用户
  public void deleteUser(int id) {
    // OK
    // Iterator<User> iterator = userList.iterator();
    // while (iterator.hasNext()) {
    //   if (iterator.next().getId() == id) {
    //     iterator.remove();
    //   }
    // }

    // 简写
    userList.removeIf(user -> user.getId() == id);

    // 错误代码
    // for (User user : userList) {
    //   if (user.getId() == id) {
    //     userList.remove(user);
    //   }
    // }
  }

  public User getUser(int id) {
    for (User user : userList) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  public void updateUser(User user) {
    User old = getUser(user.getId());
    if (old != null) {
      old.setName(user.getName());
      old.setPwd(user.getPwd());
      old.setUserType(user.getUserType());
      old.setPwdConfirm(user.getPwdConfirm());
    }
  }

  public static int getIdCount() {
    return idCount;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public static void setIdCount(int idCount) {
    UserServiceBak.idCount = idCount;
  }

  // 保存到指定路径下
  public void save() {

  }

  // 反序列化回来
  public static void load() {

  }

  public User userLogin(User user) {
    for (User one : userList) {
      if (one.getName().equals(user.getName()) && one.getPwd().equals(user.getPwd())) {
        return one;
      }
    }
    return null;
  }

  public List<User> getUserList(User user) {
    // trim 取出字符串首尾空格后，如果长度为0，则查询所有
    if (user == null || user.getName() == null || user.getName().trim().length() == 0) {
      return getUserList();
    }

    // List<User> rlt = new ArrayList<>();
    // for (int i = 0; i < userList.size(); i++) {
    //   User one = userList.get(i);
    //   if (one.getName().contains(user.getName())) {
    //     rlt.add(one);
    //   }
    // }
    //
    // return rlt;

    // String name = user.getName();
    // List<User> collect = userList.stream().filter(new Predicate<User>() {
    //   @Override
    //   public boolean test(User user) {
    //     return user.getName().contains(name);
    //   }
    // }).collect(Collectors.toList());
    return userList.stream().filter(t -> t.getName().contains(user.getName()))
        .collect(Collectors.toList());

  }
}
