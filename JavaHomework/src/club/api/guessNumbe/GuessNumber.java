package club.api.guessNumbe;

import club.api.StringBuffer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 9:41 上午
 */
public class GuessNumber {

  private static int currentNumber = 0;   //用来统计正确数字个数
  private static int currentPosition = 0; //统计正确位置个数
  private static final int[] ARR = new int[4];
  private static final StringBuffer  STRING_BUFFER= new StringBuffer();
  //初始化一个随机数出来
  static {
    Arrays.fill(ARR, -1);  // 对数组填充 -1
    for (int i = 0; i < 4; i++) {
      int index = (int) (Math.random() * 10);//
      boolean flag = true;  //判断是否满足条件
      for (int j = 0; j < ARR.length; j++) {    //  2  4  6     2
        if (index == ARR[j]) {   //判断随机数是否和数组中有重复
          i--;//外层循环要自减一次
          flag = false;
          break;
        }
      }
      if (flag) {
        ARR[i] = index;
        STRING_BUFFER.append(index);  //将随机数追加到StringBuffer
      }
    }
    System.out.println("随机生成的数据为:"+STRING_BUFFER.toString());
  }

  public void compareNumber(String line) {
    //由于以下变量是静态  如果一个程序没有结束,继续执行,以下变量的值会在原有的基础上增加(或者减少)
    currentPosition=0;
    currentNumber=0;

    for (int i = 0; i < ARR.length; i++) {
      for (int j = 0; j < line.length(); j++) {    //  "1234"   "1"  '1' 49  '0' 48
        final char c = line.charAt(j); //截取单个的字符
        if (ARR[i] == c - '0') { //将单个字符-'0' 得到整形 数字   通过ASCII码操作
          if (i == j) {
            currentPosition++;
          }
            currentNumber++;
        }
      }
    }
  }

  public boolean checkString(String line) {
    if (line.length() != 4) {
      System.out.println("你输入的数据长度不满足条件...");
      return false;
    }
    char[] chars = line.toCharArray();
    for (char aChar : chars) {
      //判断是否重复的思路:在字符串中找到是否有两个不同的下标位置
      int start = line.indexOf(aChar);  //1254
      int end = line.lastIndexOf(aChar);
      if (start != end) {
        return false;
      }
    }
    return true;
  }

  public static int getCurrentNumber() {
    return currentNumber;
  }

  public static int getCurrentPosition() {
    return currentPosition;
  }

  public void  show(){
    System.out.println("当前正确的数据有"+currentNumber+"个,有"+currentPosition+"正确的位置");
  }


  /**
   *
   * 5396
   *
   * 3569
   *
   * 3596
   * 3596
   *
   * 猜一猜4个不重复的数字，请输入4个数字：
   * 1234
   * 包含了1个正确的数字
   * 这些数字位置错误
   *
   * 请输入4个数字：
   * 2314
   * 包含了1个正确的数字
   * 1个数字的位置正确
   *
   * 请输入4个数字：
   * 5367
   * 包含了3个正确的数字
   * 2个数字位置正确
   *
   * 请输入4个数字：
   * 5396
   * 回答正确
   */


}

class Test{

  public static void main(String[] args) {
     GuessNumber guessNumber = new GuessNumber();

    Scanner  scanner=new Scanner(System.in);
    while (true){
      System.out.println("请输入数据:");
      String  number=scanner.next();
       boolean b = guessNumber.checkString(number);
       if(!b){
         System.out.println("有重复数据...");
          continue;
       }else {
         guessNumber.compareNumber(number);
         guessNumber.show();
         if(GuessNumber.getCurrentNumber()==4 && GuessNumber.getCurrentPosition()==4){
           System.out.println("猜对了...");
           break;
         }
       }
    }
  }
}
