package club.banyuan.array;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 11:09 上午
 */
public class MyArray2 {

  public static void main(String[] args) {
    //对数组 进行增删改查操作
    String [] str=new  String[5];
    final Scanner scanner = new Scanner(System.in);
    for (int i = 0; i <str.length; i++) {
      str[i]=scanner.next();  //获取字符串(不包含空格)
    }

    for (int i = 0; i <str.length; i++) {
      System.out.print(str[i]+"\t");
    }

    //对数组指定位置添加数据 并且保证原有的几个数据不变
    //     1   2   3    4   5
      //   1   2   3    89  4  5
    // 涉及到 数组长度变化    从插入位置开始后面数据的位置都变化
    System.out.println("请输入插入数据的位置:");
    int  index=scanner.nextInt(); // index 表示的是数组的中的位置  位置-1=下标
    System.out.println("请输入要插入的数据:");
    String  st=scanner.next();

    if(index > str.length || index < 0){  //保证插入的数据要在数组内
      System.err.println("你输入的位置有误...");
    }
    String [] strCopy=new String[str.length+1];  //添加一个数据就扩容一个长度
    for (int i = 0; i < index; i++) { //4  index位置前面的数据
      strCopy[i]=str[i];
    }
    for (int i = index; i < strCopy.length; i++) { //index位置后面的数据
      strCopy[i]=str[i-1];
    }
    strCopy[index-1]=st; //index位置  也就是下标为 index-1 的
    str=strCopy;  //重新赋值给数组 str  是为了保证str数组原有的数据不变而且在原有的基础之上添加了新的数据
    System.out.println(">>>>>>>>>");
    for (int i = 0; i <str.length ; i++) {
      System.out.print(str[i]+"\t");
    }

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *
     *             对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     *
     *             针对所有的元素重复以上的步骤，除了最后一个，即需要进行length-1次。
     *
     *             第一次是对n个数进行n-1次比较，进行到最后第n个的一个是最大的；
     *
     *             第二次是对n-1个数进行n-2次比较，进行到最后第n-1个的一个是最大的；
     *
     *             ......
     *
     *             持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     *              //冒泡排序算法
     *         int[] numbers=new int[]{1,5,8,2,3,9,4};
     *         //需进行length-1次冒泡
     *         for(int i=0;i<numbers.length-1;i++)
     *         {
     *             for(int j=0;j<numbers.length-1-i;j++)
     *             {
     *                 if(numbers[j]>numbers[j+1])
     *                 {
     *                     int temp=numbers[j];
     *                     numbers[j]=numbers[j+1];
     *                     numbers[j+1]=temp;
     *                 }
     *             }
     *         }
     *         System.out.println("从小到大排序后的结果是:");
     *         for(i=0;i<numbers.length;i++)
     *             System.out.print(numbers[i]+" ");
     *     }
     *
     *
     */

  }

}
