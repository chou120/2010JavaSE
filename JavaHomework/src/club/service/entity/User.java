package club.service.entity;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 6:28 下午
 */
public class User {

  private static String userId="0";
  private String name;
  private String password;
  private String phone;

  public User() {
  }

  public User(String name, String password, String phone) {
     int i = Integer.parseInt(userId);
     i++;
    userId=""+i;

    this.name = name;
    this.password = password;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
