package club.banyuan.programControl;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 3:32 下午
 */
public class MyScanner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
     if(i>12 || i < 1 ){
       System.out.println("输入的数据有误..重新输入..");
     }else if(i==12 || i==11 || i==1){
       System.out.println("冬季");
     }else if(i>=2 && i<=4){
       System.out.println("春季");
     }else if(i>=5 && i<=7){
       System.out.println("夏季");
     }else {
       System.out.println("秋季");
     }
  }
}
