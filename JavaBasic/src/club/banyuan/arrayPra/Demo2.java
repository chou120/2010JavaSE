package club.banyuan.arrayPra;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/16 2:18 下午
 */
public class Demo2 {


  public static void main(String[] args) {


  }

  //定义一个数组,数组成员10个,找出数组中最大数连同下标一起输出

  //请问根据上面的条件  如果定义一个方法 那么此方法的返回值是什么数据类型？  String
  public static  String  getNumber(int [] arr){
    int  max=arr[0];
    int  index=-1;
    for (int i = 0; i <arr.length; i++) {
      if(max<arr[i]){
        max=arr[i];
        index=i;
      }
    }
    return  "最大值是:"+max+",下标为:"+index;
  }





  public static  String  getNumber(double [] arr){

    return  "";
  }

  public static  String  getNumber(float [] arr){
    return  "";
  }

  public static  String  getNumber(long [] arr){
    return  "";
  }

}
