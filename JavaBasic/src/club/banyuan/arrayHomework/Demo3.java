package club.banyuan.arrayHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 9:27 上午
 */
public class Demo3 {

  /*
    编写一个main方法用来测试上述两个方法，定义一个数组，
      内容 {13,26,-3,4,54,26,37,18,69,-10}，编写一个print方法，
        使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行
   */

  public static void main(String[] args) {
    int[] arr = {13, 26, -3, 4, 54, 26, 37, 18, 69, -10};
    String print = print(arr);
    System.out.println("拼接之后的结果为:" + print);
  }

  /**
   * [0]=13 [1]=26 [2]=-1 [3]=4 [4]=54
   * [5]=26 ....
   * @param arr
   * @return
   */

  public static String print(int[] arr) {
    String st1="[";
    String st2="]";
    String str="";
    for (int i = 0; i < arr.length; i++) {
      if((i+1)%5==0){
        str=str+st1+i+st2+"="+arr[i]+"\n";
        continue;
      }
      str=str+st1+i+st2+"="+arr[i]+"\t";
    }
    //main(new String[]{"12","13"});
    return str;  //将返回值  返回给调用者
  }

  public  static  void   info(int [] arr){
    //print(arr);
    return; //
  }
}
