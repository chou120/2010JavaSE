package club.banyuan.entity;

import java.util.Objects;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/14 1:41 下午
 */
public class User {
private   String  name;
private  String pwd;

  public User() {
  }

  public User(String name, String pwd) {
    this.name = name;
    this.pwd = pwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name) &&
        Objects.equals(pwd, user.pwd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, pwd);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
