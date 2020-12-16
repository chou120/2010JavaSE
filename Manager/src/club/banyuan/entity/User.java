package club.banyuan.entity;

import club.banyuan.service.TestUserAnnotation;
import java.util.Objects;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/14 1:41 下午
 */
public class User {

  private int id;
  @TestUserAnnotation(reg = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$",msg = "字母开头，允许5-16字节，允许字母数字下划线")
  private String name;
  @TestUserAnnotation(reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$",msg = "必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间")
  private String pwd;

  private String pwdConfirm;

  private int userType;  //  int

  /**
   /*
   前后端的数据不全  UserTypeStr 不是前端传递过来的 序列化的时候找不到该字段 我们需要自己去处理
   让UserTypeStr是字符串

   JSON序列化只会调用属性的无参get方法
   反序列化的时候会调用有参的set方法

   此方法只是为了让数据在前端进行显示使用  所以不需要再添加其他属性
   *
   * @return
   *
   */
  public  String  getUserTypeStr(){
    if(userType==1){
      return "经理";
    }else  if(userType==0){
      return "普通用户";
    }else{
      return "Unknown";
    }
  }

  public int getUserType() {
    return userType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPwdConfirm() {
    return pwdConfirm;
  }

  public void setPwdConfirm(String pwdConfirm) {
    this.pwdConfirm = pwdConfirm;
  }


  public void setUserType(int userType) {
    this.userType = userType;
  }

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
