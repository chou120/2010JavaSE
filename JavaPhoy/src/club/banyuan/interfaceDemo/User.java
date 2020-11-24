package club.banyuan.interfaceDemo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 11:19 上午
 */
public class User {


  private  String username;
  private  String  pwd;

  public User() {
  }

  public User(String username, String pwd) {
    this.username = username;
    this.pwd = pwd;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
