package club.banyuan;

import java.io.Serializable;

// 使用对象序列化的对象，必须实现 Serializable 接口
public class User implements Serializable {

  // 通过序列化版本号，减少反序列化出现异常的情况
  private static final long serialVersionUID = -1773590199049414937L;
  private String name;
  private String pwd;

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
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        '}';
  }
}
