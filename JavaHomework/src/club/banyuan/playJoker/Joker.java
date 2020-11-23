package club.banyuan.playJoker;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 10:17 上午
 */
public class Joker {
  private static final String[] color={"♠","♣","♥","♦"}; //花色
  private static final String [] jokerNumber={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};//牌数 A    2    3  等
  private static final String[] jokers={"大王","小王"};

  //初始化牌
  private   static  String[] getJokers(){
    int   key=0;
    String [] str=new String[54];
    for (int i = 0; i <color.length; i++) {
      for (int j = 0; j <jokerNumber.length; j++) {
          str[key++]=color[i]+jokerNumber[j];
      }
    }
    str[str.length-2]=jokers[0];
    str[str.length-1]=jokers[1];
    return  str;
  }

  //然后对牌进行打乱
  public  static  String[]  randomJoker(){
    String[] joker = getJokers();
    for (int i = joker.length; i >=1; i--) {
      swap(joker, i-1, (int)(Math.random()*joker.length));
    }
    return  joker;
  }

  public static void  swap(String []str,int i,int j){
    String  temp=str[i];
    str[i]=str[j];
    str[j]=temp;
  }



}
