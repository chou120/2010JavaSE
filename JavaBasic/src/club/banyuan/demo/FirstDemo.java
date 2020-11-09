package club.banyuan.demo;
/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/9 11:43 上午
 */

/**
 * 该类使用来对数字进行操作的描述
 */

public class FirstDemo {

  /**
   * 访问修饰符  class   类名 {    }
   * <p>
   * 驼峰命名: 类名:字母开头,首字母一定要大写  第二个单词开始 每个单词首字母都要大写  单词与单词之间可以使用 _ $ 还可以用数字 方法名 如上 变量名 如上
   * 变量名第一个单词首字母可以小写 可_  $ 不能数字开头
   *
   * @param args
   */

  public static void main(String[] args) {  //从外部接收数据

    System.out.println("hahsahas");
    System.out.println('a');
    System.out.println('女');
    System.out.println("张风帆");
    System.out.println(12.78);
    System.out.println(12);
    System.out.println('\u1100');

    /*
      以上写法叫字面量写法   常量不能变
     */

    /**
     * 变量:内存中的一段存储空间
     *
     * 1一个字节等8位      -128~127
     */

    int num;  //在内存中开辟一个（int）整形空间
    num = 2147483647;   //对存储空间进行赋值

    char ch = '男';  // 会涉及到编码格式   utf-8  3个字节
    double dou = 12.01; //8   19
    float flo = 12.78F; //4    8

    System.out.println("num=" + num + "max值:" + Integer.MAX_VALUE
        + ",min=" + Integer.MIN_VALUE);

    byte by = 12;
    System.out.println("by=" + by);

    short sho = 45;
    System.out.println("sho=" + sho);

    boolean flag = true;   //一个字节   一位
    System.out.println("flag=" + flag);

    long lo = 123L;  //如果不加L表示把整形数字赋值给长整型  long

    System.out.println("lo=" + lo);

    //int int=12;  关键字不能作为名字

    String str = "张三丰";
    String string = "哈撒给";  //不是关键字   可以做变量名
    char sx = '你';

    /**
     * 除了基本数据类型  其他的都是引用数据类型
     */

    char sex = '0'; //48
    System.out.println("sex=" + sex +
        "转换为二进制=" + Integer.toBinaryString(sex) +
        "转换为十六进制=" + Integer.toHexString(sex) +
        "转换为八进制=" + Integer.toOctalString(sex));

    System.out.println(sex + ">>>>" + (sex + 1)); //优先转换成ASCII 48
    System.out.println(">>>>" + (char) (sex + '1')); // '0' 48   '1' 49

    /**
     * 小转大  默认转  自动类型转换
     *
     * 大类型转小的数据类型  需要强制类型转换
     *
     *  强制类型转换
     * (char)('0'+'1')='a'
     */

    double dou1 = 89.99999;
    int number1 = (int) dou1;
    System.out.println(number1);

    number1 = 123;
    dou1 = number1;
    System.out.println(dou1); //123
    System.out.println(129 + dou1); //252.0

    float float1 = 12.89F;
    //dou1=float1;
    float1 = (float) dou1;  //重新赋值
    System.out.println(float1); //123.0

    // byte   short     int
    byte byt1 = 127;
    byte byt2 = 3;
    byte byt3 = (byte) (byt1 + byt2); //请问为什么会错

    System.out.println(byt3);  //15   ?

    System.out.print("你\t好"+"我\n不好"); // println()

    int  num1 =1;//变量在使用前一定要初始化值
    num1=num1+1;

    //System.out.println(num1);

    char  c='m' ;


  }


}


