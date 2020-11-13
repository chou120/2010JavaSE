package club.banyuan.homework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/13 2:10 下午
 */
public class Demo6 {

  /**
   * 30以内的随机数,请输入任意一个数,循环10次,求这个数在随机数范围内出现的次数
   */

  public static void main(String[] args) {
//    int  num=12;
//    int  time=0;
//    for (int i = 0; i <10; i++) {
//      int  number=(int)(Math.random()*30);
//      //System.out.println(">>>>"+number);
//      if(number==num){
//        time++;
//      }
//    }
//    System.out.println(num+"出现了:"+time+"次");

    //BigInteger  in=new BigInteger("123245313123123211325465");

    getLength(512312);

  }


  public static String numberRevese(int number) {  //
    //1203   3021
    String str = "";
    int key = -1;
    int mod = -1;

//    while (true) {  //
//      key = number % 10;  //得到余数 也就是个位数
//      mod = number / 10;  //得到商
//      number = mod;  //把商重新赋值给number
//
//      str = str + key;
//
//    }
    int length = getLength(number);

    return str;
  }

  public static int getLength(int number) { // 512312
    //每个数取出来 存放到数组中  然后将数组倒序
    int log = (int) (Math.log(number) / Math.log(10)); //
    int[] ints = new int[log + 1];
    System.out.println(ints.length);
    for (int i = 0; i < ints.length; i++) {
      int key = number % 10;
      System.out.print(key);
      number = number / 10;
    }
    return 0;
  }


}
