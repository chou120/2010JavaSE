package club.banyuan.test;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 4:24 下午
 */
public class User {
  //注解的作用就是给出一个提示

  @TestUserAnnotation(reg = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$",msg = "字母开头，允许5-16字节，允许字母数字下划线")
  private   String username;

  @TestUserAnnotation(reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$",msg = "必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间")
  private   String password;

  public User() {

  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
