package club.banyuan.operation;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 11:22 上午
 */
public class BitOperation {

  public static void main(String[] args) {

    /**
     *   &
     *
     *   |
     *
     *   ~
     *
     *   ^
     */

    int  num1=5; //     0000 0101
    int  num2=7; //     0000 0111
                  //    0000 0101

    System.out.println(num1 & num2);

    System.out.println(num1 | num2);


  }

}
