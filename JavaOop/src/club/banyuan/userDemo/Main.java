package club.banyuan.userDemo;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 11:07 上午
 */
public class Main {

  public static void main(String[] args) {

    while (true) {
      System.out.println("欢迎进入半圆电子商城");
      System.out.println("1.用户选项");
      System.out.println("2.查看商品详情");
      System.out.println("3.退出");

      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入操作的选项:");
      String next = scanner.next();

      switch (next) {
        case "1":
          //用户登录或者是用户的注册
          UserService userService = new UserService();

          System.out.println("欢迎进入用户操作界面");
          System.out.println("请输入操作选项:");
          String string = scanner.next();
          if (string.equals("1")) {
            //TODO 登录方法
            User user = new User();
            user.setUsername("张三0");
            user.setPassword("123450");
            boolean flag = userService.login(user);
           // System.out.println("登录是否成功:" + flag);
            if(flag){
              //TODO 调用显示所有商品的详情
               ProductService productService = new ProductService();
               productService.showAll();
            }

          } else {
            //TODO  注册方法
          }

          break;
        case "2":

          break;

        case "3":

          break;
        default:
          System.out.println("其他操作...");
          break;
      }

    }


  }

}
