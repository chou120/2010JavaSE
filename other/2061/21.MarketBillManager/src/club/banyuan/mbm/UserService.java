package club.banyuan.mbm;

import club.banyuan.mbm.util.Constant.Prop;
import club.banyuan.mbm.util.PropUtil;
import club.banyuan.mbm.util.ValidateUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class UserService {

  // 字母开头，只能包含数字字母下划线，6~20位
  // private static final String REGEX_USER_NAME = "[a-zA-Z]\\w{5,19}";
  // 为每个用户分配一个唯一id
  private int idCount = 1;
  private List<User> userList = new CopyOnWriteArrayList<>();
  private static final UserService INSTANCE = load();

  // 6~20位的任意字符
  // private static final String REGEX_PWD = ".{6,20}";

  /**
   * 单例模式，保证UserService在程序运行期间只有这一个对象
   */
  private UserService() {
  }

  public static UserService getInstance() {
    return INSTANCE;
  }

  // 向列表中添加用户
 synchronized public void addUser(User user) {
    // 校验前台提交的用户数据
    // 添加用户的时候，校验用户的密码和确认密码一致
    // 添加的用户名，不能和已有的用户名重复
    if (!user.getPwd().equals(user.getPwdConfirm())) {
      // 密码不一致
      throw new BadRequestException("密码和确认密码不一致");
    }
    ValidateUtil.validate(user);

    // if (!user.getPwd().matches(REGEX_PWD)) {
    //   throw new BadRequestException("密码不合法");
    // }
    //
    // if (!user.getName().matches(REGEX_USER_NAME)) {
    //   throw new BadRequestException("用户名不合法");
    // }

    Optional<User> any = userList.stream().filter(t -> t.getName().equals(user.getName()))
        .findAny();
    if (any.isPresent()) {
      // 用户名不合法
      throw new BadRequestException("用户名已存在");
    }

    // 为用户生成一个唯一的id
    user.setId(idCount++);
    userList.add(user);
    save();
  }

  // 删除用户
  synchronized public void deleteUser(int id) {
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
    save();
  }

  public User getUser(int id) {
    for (User user : userList) {
      if (user.getId() == id) {
        return user;
      }
    }
    throw new BadRequestException("用户不存在 id:" + id);
  }

  // TODO 需要对用户进行校验，校验用户名存在的时候，需要注意
  synchronized public void updateUser(User user) {

    if (!user.getPwd().equals(user.getPwdConfirm())) {
      // 密码不一致
      throw new BadRequestException("密码和确认密码不一致");
    }

    ValidateUtil.validate(user);

    // if (!user.getPwd().matches(REGEX_PWD)) {
    //   throw new BadRequestException("密码不合法");
    // }
    //
    // if (!user.getName().matches(REGEX_USER_NAME)) {
    //   throw new BadRequestException("用户名不合法");
    // }

    User old = getUser(user.getId());
    old.setName(user.getName());
    old.setPwd(user.getPwd());
    old.setUserType(user.getUserType());
    old.setPwdConfirm(user.getPwdConfirm());
    save();
  }

  public int getIdCount() {
    return idCount;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public void setIdCount(int idCount) {
    this.idCount = idCount;
  }

  // 保存到指定路径下
  private void save() {
    String rlt = JSONObject.toJSONString(this);
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        PropUtil.getProp(Prop.USER_STORE))) {
      fileOutputStream.write(rlt.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 反序列化回来
  private static UserService load() {
    try (FileInputStream inputStream = new FileInputStream(PropUtil.getProp(Prop.USER_STORE))) {

      return JSONObject.parseObject(inputStream, StandardCharsets.UTF_8, UserService.class);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return new UserService();
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

  public static void main(String[] args) {
    UserService userService = new UserService();
    User user = new User();
    user.setPwd("123456");
    user.setPwdConfirm("123456");
    user.setName("a");
    user.setUserType(0);
    userService.addUser(user);
  }
}
