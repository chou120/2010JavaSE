package club.banyuan;


public class User {

  private String name;
  private String pwd;

  public User() {
  }

  // 使用json反序列化时，必须保证对象要提供给一个无参的构造方法
  public User(String name, String pwd) {
    this.name = name;
    this.pwd = pwd;
  }

  // 默认的序列化时候，是调用get方法，实现的序列化
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

  // json序列化的时候，调用了对象的get方法，需要保证想要序列化的属性，必须有对应的get方法
  // public String getNotExist() {
  //   return "呵呵";
  // }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
