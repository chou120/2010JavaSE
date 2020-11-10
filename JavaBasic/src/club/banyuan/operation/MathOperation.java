package club.banyuan.operation;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 9:57 上午
 */
public class MathOperation {

  /**
   * +，-，*，/，%，++，--，+，-
   * <p>
   * =，+=，-=，*=，/=，%=，&=，|=，^=,<<=,>>=,>>>=
   */

  public static void main(String[] args) {
    int num = 12;
    int num2 = 13; //格式化  command+option+L
    System.out.println(num + num2);
    System.out.println(num - num2);

    double dou = 49;
    System.out.println(num * dou); //48.0
    System.out.println(-dou / num); //3.0

    System.out.println("1+1=" + (1 + 1));  //1+1=2
    System.out.println("1+1=" + 1 + 1); // 1+1=2
    System.out.println(1 + 1 + "=1+1"); // 2=1+1
    System.out.println((1 + 1) + "=1+1" + 2); // 2=1+12
    System.out.println("a+b=" + (char) ('A' + 'B')); // 2=1+12

    System.out.println(dou % num); //  1.0

    /**
     *   7896 求每个位上的数相加的和
     */

    int number = 7896;
    int qianWei = number / 1000; // 7
    int baiWei = number / 100 % 10; //8
    int shiWei = number / 10 % 10; // 9
    int geWei = number % 10;  //6

    System.out.println(qianWei + baiWei + shiWei + geWei);

    /**
     * ++   ++在前 本身先自加1再参与运算  ++在后先参与运算 在本身自加
     * --   同上
     */
    int x = 2;
    int y = 1;
    // x=++x;  // x=x+1;
    // x=x++; //  x=2
    // x = ++y;  //y=2  x=2;
    // x = y++;  //y=2  x=1
    System.out.println("y=" + (y++));//2  2  1   1
    System.out.println(y);

    //x=x++ + --x + x-- + ++x;

    x += 1; //x=x+1;
    x %= 2;//x=x%2;

    System.out.println("x=" + x);


  }
}
