package club.banyuan.service;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 1:51 下午
 */
public class User {

  private  String  name;
 // private  Character sex; //  int  ---->>> Integer
  private  String  gender;//

  private  Gender  sex;//性别


  public User() {

  }

  public Gender getSex() {
    return sex;
  }

  public void setSex(Gender sex) {
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", sex=" + sex +
        '}';
  }
}
