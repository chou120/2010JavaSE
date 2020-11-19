package club.banyuan.bank;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 3:53 下午
 */
public class User {

  /**
   * 用户在银行开户的时候,用户信息全部存储到数据库中,用的信息存储的 顺序由number来判定,number越小约在前面 每个用户的 编号会在前一个用户的 number 基础之上自加
   * number++
   */

  private String name;
  private String IdCard;
  private String iphone;
  private double salary = 10000;

  //用户信息在数据库中的编号
  private  int  userNumber;

  public User() {
      userNumber=Bank.number++;
  }

  public User(String name, String idCard, String iphone, double salary) {
    this.name = name;
    IdCard = idCard;
    this.iphone = iphone;
    this.salary = salary;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdCard() {
    return IdCard;
  }

  public void setIdCard(String idCard) {
    IdCard = idCard;
  }

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", IdCard='" + IdCard + '\'' +
        ", iphone='" + iphone + '\'' +
        ", salary=" + salary +
        ", userNumber=" + userNumber +
        '}';
  }
}
