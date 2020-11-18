package club.banyuan.userDemo;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 11:12 上午
 */
public class UserService {

  private   User[] users=new User[5];
  {
    for (int i = 0; i <users.length; i++) {
      User user = new User();
      user.setUsername("张三"+i);
      user.setPassword("12345"+i);
      users[i]=user;
    }
  }

  //用户登录
  public   boolean login(User  user){
    //user 对象在数据库是否存在
    for (int i = 0; i <users.length; i++) {
      if(user.getUsername().equals(users[i].getUsername())){
        return true;
      }
    }
    return false;
  }

  //用户注册




  //用户的商品添加操作
  public  void  addProduct(Product product,User user){  //
      //在做添加操作的时候 能不能先判断 数组是否存在 如果不在就创建数组
    Product[] products = user.getProducts();  //不进行数组的判断为空 是因为在用户登录的时候就已经存在可以存放数据的容器了
    //扩容
    products=Arrays.copyOf(products, products.length+1);
    products[products.length-1]=product;

    user.setProducts(products);
  }

  //显示用户购物车里面所有的商品
  public void  printnInfo(User user){
    for (int i = 0; i < user.getProducts().length; i++) {
      System.out.println(user.getProducts()[i]);
    }
  }


}
