package club.banyuan.service;

import club.banyuan.entity.User;
import club.banyuan.util.PropUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/14 1:42 下午
 */
public class UserService {

  public User login(User user) throws IOException {
    //如果传递过来的数据 在数据库(json文件)能找到,意味着能成功登录  否则返回一个空
    //首先要将json数据读取出来
    List<User> load = load();

    for (User user1 : load) {
         if(user.equals(user1)){
            return  user1;
         }
    }
    return null;
  }

  public List<User> load() throws IOException {

    String prop = PropUtil.getProp("page.data");
    File file = new File(prop);

    FileReader fileReader = new FileReader(file);
    char[] chars=new char[(int)file.length()];

    int key=0;

    int read = fileReader.read();
    while (read!=-1){
      chars[key++]=(char)read;
      read = fileReader.read();
    }
    String s = new String(chars, 0, key);
    //将json字符串转换成对象
   return JSONObject.parseArray(s, User.class);
  }

  public static void main(String[] args) throws IOException {

    UserService userService = new UserService();
    System.out.println(userService.login(new User("zhangsan", "123456" )));


  }

}
