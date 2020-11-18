package club.banyuan.userDemo;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 10:56 上午
 */
public class User {

  /**
   * 需求: 1. 首选登录 public  boolean  login(User  user){
   * <p>
   * } 2.如果登录成功就显示所有的商品的详细 public   Product [] showAll(){
   * <p>
   * }
   * <p>
   * 3.提供一个购买商品的功能 public  void   buy(String productId){ //
   * <p>
   * }
   */
  private String userId;
  private String username;
  private String password;
  private String checkPassword;//二次密码验证
  private String userAddress;
  private String iphone;
  //用户的银行账号
  private  Product[] products; // null


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCheckPassword() {
    return checkPassword;
  }

  public void setCheckPassword(String checkPassword) {
    this.checkPassword = checkPassword;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", checkPassword='" + checkPassword + '\'' +
        ", userAddress='" + userAddress + '\'' +
        ", iphone='" + iphone + '\'' +
        ", products=" + Arrays.toString(products) +
        '}';
  }
}
