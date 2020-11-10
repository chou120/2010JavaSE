package club.banyuan.programControl;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 3:38 下午
 */
public class Demo2 {
  /**
   * switch (数据项){
   case 数据1:
   代码1;
   break;
   case 数据2:
   代码2;
   break;
   case 数据3:
   代码3;
   break;
   ...
   default:
   不满足以上条件执行此处代码
   break;

   }*/
  public static void main(String[] args) {

    Scanner  scanner=new Scanner(System.in);
    System.out.println("请输入数据:");
   // char number=scanner;
  //  char   x='a';
     String x = scanner.next(); //获取字符串数据

    switch (x){  //整形 字符串 字符型 括号里面从jdk1.5之后可以放 枚举
      case "jax":
        System.out.println("一个能打的都没有");
        break;
      case "剑圣":
        System.out.println("你的贱还是你的贱...");
        break;
      case "剑姬":
        System.out.println("在座的各位都是垃圾...");
        break;
      default:
        System.out.println("我错了...");
        break;
    }

    /*switch (number){
      case 1:
        System.out.println("在座的各位都是栋梁...");
        //break;
      case 2:
        System.out.println("在座的各位都是住在下水道...");
        break;
      case 3:
        System.out.println("在座的各位都是垃圾...");
        //break;
      default:
        System.out.println("我错了...");
        break;
    }*/








  }


}
