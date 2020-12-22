package club.banyuan;

import java.util.Objects;

public class User implements Comparable<User>{

  private String name;
  private String pwd;

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

  @Override
  public int compareTo(User o) {
    System.out.println("被调用了");
    return name.compareTo(o.getName());
  }
}
