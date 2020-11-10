package club.banyuan.conversion;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/10 9:31 上午
 */
public class Demo {

  public static void main(String[] args) {
    System.out.println(0B100101); //计算机不认识
    System.out.println(017); //  1*8^1+7*8^0=8+7=15

    System.out.println(0x17); // 23
    /**
     *   0000 0000 0000 0000 0000 0000 0010 0101
     *   1*2^5+0*2^4+0*2^3+1*2^2+0*2^1+1*2^0
     *   =32+0+0+4+0+1
     *   =37
     *
     *   同理  八进制   十六进制
     *
     *
     *  0~9 A~F   f=15
     *  F+1=10
     *
     *
     *  1101101
     *  8421算法
     *            1111  1111  1111  1111  1111  1111  1111 1111
     * 二进制数                                        0110 1101
     *
     * 八进制                                               155
     *
     * 十六进制                                              6D
     *
     */

    System.out.println(Integer.toOctalString(0B110_1101));
    System.out.println(Integer.toHexString(0B110_1101));

    /**
     * 0B101101+0B11011   -->  8  16
     */




  }
}
