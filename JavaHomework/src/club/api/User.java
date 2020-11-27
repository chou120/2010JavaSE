package club.api;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 9:23 上午
 */
public class User {

  private  String name;
  private  String address;

  public User(String name, String address) {
    this.name = name;
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
