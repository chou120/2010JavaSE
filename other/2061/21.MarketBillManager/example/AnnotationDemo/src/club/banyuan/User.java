package club.banyuan;

public class User {

  private int id;
  // 用户名名字的匹配规则
  @MyAnnotation(regex = "[a-zA-Z]\\w{5,19}", msg = "用户名不合法，必须是非数字开头的6~20个字符")
  private String name;
  // 用户密码的匹配规则
  @MyAnnotation(regex = "\\S{6,20}", msg = "密码不合法，必须是长度6~20的非空字符串")
  private String pwd;
  private String pwdConfirm;
  private int userType;
  private String userTypeStr;


  public String getPwdConfirm() {
    return pwdConfirm;
  }

  public void setPwdConfirm(String pwdConfirm) {
    this.pwdConfirm = pwdConfirm;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public String getUserTypeStr() {
    if (userType == 1) {
      return "经理";
    } else {
      return "普通用户";
    }
  }

  public void setUserTypeStr(String userTypeStr) {
    this.userTypeStr = userTypeStr;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
}
