package club.banyuan.bank;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 3:50 下午
 */
public class Bank {

  public static int number = 9527;//定义一个类变量
  private String name;
  private double rate = 0.6; //利率
  private String time;
  private User[] users;
  private int  key=0;
  //
  public Bank() {
      users=new User[2];

  }



  //判断是否需要进行扩容
  public  boolean  bigBig(){
    for (int i = 0; i < users.length; i++) {
      if(users[i]==null){
        return false; //如果最后一个等于空就不需要进行扩容
      }
    }
    return true;  //否则需要扩容
  }
  //添加用户操作
  public   void  addUser(User  user){
      if(bigBig()){  // true
        users = Arrays.copyOf(this.users, users.length + 1);
      }
      users[key++]=user; //

  }

  public Bank(String name, double rate, String time, User[] users) {
    this.name = name;
    this.rate = rate;
    this.time = time;
    this.users = users;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public User[] getUsers() {
    return users;
  }

  public void setUsers(User[] users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Bank{" +
        "name='" + name + '\'' +
        ", rate=" + rate +
        ", time='" + time + '\'' +
        ", user=" + Arrays.toString(users) +
        '}';
  }
}
