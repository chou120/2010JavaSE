package club.banyuan.service;

import club.banyuan.entity.User;
import club.banyuan.sessionDemo.MySession;
import club.banyuan.util.PropUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/14 1:42 下午
 */
public class UserService {

  //提前读取json 存放到list集合中
  private static List<User> list = new ArrayList<>();

 /*
 static {  5 注释静态加载
    try {
      list=load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  */

  public static List<User> getList() {
    return list;
  }

  public static void setList(List<User> list) {
    UserService.list = list;
  }

  public User login(User user) throws IOException {
    //如果传递过来的数据 在数据库(json文件)能找到,意味着能成功登录  否则返回一个空
    //首先要将json数据读取出来
    List<User> load = load();
    for (User user1 : load) {
      if (user.equals(user1)) {
        //将登录的数据存到session中
        list=load; //登录的时候才去加载数据   4
        MySession.map.put("user", user);
        return user1;
      }
    }
    return null;
  }

  public String addUser(User user) {
    //由于id编号问题,不是程序员手动添加的我们可以使用工具类
    //而且id是int类型 在每次添加id的时候,让其自增,我们也可以在最大的编号基础之上+1
    //获取最大id的用户

    /**
     * 如果id编号是字符串类型的 可以使用  UUID
     */

    /**
     * 先读取到这个json文件里面的所有的数据(集合),然后对集合做添加操作,再将集合添加到json文件里面去
     */

    //现在获取 用户最大编号  筛选出最大编号的用户
    User user1 = list.stream().max((o1, o2) -> o1.getId() - o2.getId()).get();
    user.setId(user1.getId() + 1);

    //在添加或者修改之前进行验证  用户名是否 数据库中的用户名一样 如果一样就不给添加(或者抛一个异常),
    for (User user2 : list) {
      if (user2.getName().equals(user.getName())) {
        return "账户已存在";
      }
    }

    if(user.getPwd().length()!=6){
      return "密码长度不合法";
    }

    //要二次验证输入的密码 密码的长度是6~8  密码只能是数字或者字母[a-z A-Z 0-9]
    if (!user.getPwd().equals(user.getPwdConfirm())) {
        return "两次密码输入的不一样";
    }
    list.add(user);
    save();
    return "添加成功";
  }

  private void save() {
    //将集合中的数据存放到json文件中
    try (FileWriter fileWriter = new FileWriter(new File(PropUtil.getProp("page.data")))) {
      String jsonString = JSONObject.toJSONString(list);
      fileWriter.write(jsonString);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static List<User> load() throws IOException {

    String prop = PropUtil.getProp("page.data");
    File file = new File(prop);

    FileReader fileReader = new FileReader(file);
    char[] chars = new char[(int) file.length()];

    int key = 0;

    int read = fileReader.read();
    while (read != -1) {
      chars[key++] = (char) read;
      read = fileReader.read();
    }
    String s = new String(chars, 0, key);
    //将json字符串转换成对象

    return JSONObject.parseArray(s, User.class);
  }


  public boolean deleteUserById(User user3) {
    Stream<User> userStream = list.stream().filter(user -> user3.getId() == user.getId());
    User user = userStream.findFirst().get();
    boolean remove = list.remove(user);
    save();
    return remove;
  }

  public User getById(User user) {

    for (User user1 : list) {
      if (user1.getId() == user.getId()) {
        // String jsonString = JSONObject.toJSONString(user1);
        return user1;
      }
    }
    return null;
  }


  public static void main(String[] args) throws IOException {

    UserService userService = new UserService();
    System.out.println(userService.login(new User("zhangsan", "123456")));

  }

  public void updateUserById(User updateUser) {
    //对原有的数据进行更新吧  id=12
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == updateUser.getId()) {
        list.set(i, updateUser);
        save();
      }
    }
  }
}
