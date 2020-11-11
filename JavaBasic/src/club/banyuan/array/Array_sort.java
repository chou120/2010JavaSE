package club.banyuan.array;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 2:46 下午
 */
public class Array_sort {

  /**
   * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
   * <p>
   * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。 在这一点，最后的元素应该会是最大的数。
   * <p>
   * 针对所有的元素重复以上的步骤，除了最后一个，即需要进行length-1次。
   * <p>
   * 第一次是对n个数进行n-1次比较，进行到最后第n个的一个是最大的；
   * <p>
   * 第二次是对n-1个数进行n-2次比较，进行到最后第n-1个的一个是最大的； 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
   *
   * @param args
   */

  public static void main(String[] args) {

    int[] arr = {34, 5, 621, 452, 13, 551, 12};

    printArray(arr);
    System.out.println("》》》》》》》》》》");
//
//    for (int i = 0; i < arr.length; i++) {  //比几轮
//      for (int j = 0; j< arr.length-1-i; j++) {  //每一轮减几次
//          if(arr[j]>arr[j+1]){
//            int  temp=arr[j];
//            arr[j]=arr[j+1];
//            arr[j+1]=temp;
//          }
//      }
//    }
    /**
     * 有兴趣去把二分查找和快速排序看看
     */

    /**
     * 求对以下三个数组进行排序
     * int [] arr1={12,341,123,5,2,11};
     *
     * int [] arr2={8,13,7,5,21,3};
     *
     * int [] arr3={5,98,44,9,2,11};
     *
     * 并且得到排序之后的结果
     *
     */

    int[] arr1 = {12, 341, 123, 5, 2, 11};

    sortArray(arr1);
    int[] arr2 = {8, 13, 7, 5, 21, 3};
    sortArray(arr2);

    int[] arr3 = {5, 98, 44, 9, 2, 11};

    sortArray(arr3);
    printArray(arr3);

    int i = sumArray(arr3);
    int i1 = sumArray(arr2);

    System.out.println(i + i1);

    double sum = sum(12.0, 34.5, 6.6);
    System.out.println(sum);

    /**
     * 方法:
     *    有返回值方法
     *
     *    无返回值方法
     */

    /**
     * 求任意两个数进行交换
     */
    int  a=4,b=5;
    change(a,b);

    System.out.println("a="+a+",b="+b);

    //对数组进行交换
    int [] arrChange={23,45};

      arr_Change(arrChange);

      printArray(arrChange);
  }

  /**
   * 对数组里面的数据进行交换功能
   * @param arrChange
   */
   public static void arr_Change(int[] arrChange) { //传递的是地址值
     int temp=arrChange[0];
     arrChange[0]=arrChange[1];
     arrChange[1]=temp;
  }
  public  static  void change(int  x,int y){ //传递的是数据值
    int temp=x;
    x=y;
    y=temp;
    System.out.println("change x="+x+",y="+y);
  }
  /**
   * 编写一个方法,求任意三个数字和
   */

  /**
   * 方法重载:方法名相同,参数列表不同,跟返回值无关
   * @param x
   * @param y
   * @param z
   * @return
   */

  public static double sum(double x, double y, double z) {
    return x + y + z;
  }
  public static int sum(int x, int y, int z) {
    return x + y + z;
  }
  public static String  sum(int x, char y, int z,String  string) {
    return x + y + z+string;
  }
  public static int sum(char y, int z) {
    return  y + z;
  }

  /**
   * 方法: 完成某一项功能的代码块
   * <p>
   * 格式 访问修饰符  返回数据的数据类型   方法名(参数列表){ 代码块; [return 数据]; }
   *
   * @param arr 数组
   */

  public static int sumArray(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    //System.out.println("和是:"+sum);  //方法如果有数据结果,一般情况不会在方法里面显示输出 只会把该结果返回给调用者
    return sum;
  }


  public static void sortArray(int[] arr) { //对数组排序
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }


  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "\t");
    }
    System.out.println();
  }


}
