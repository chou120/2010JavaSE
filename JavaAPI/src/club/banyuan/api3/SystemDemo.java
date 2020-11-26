package club.banyuan.api3;

import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 2:02 下午
 */
public class SystemDemo {

  public static void main(String[] args) {
//    long timeMillis = System.currentTimeMillis();//s
//    System.out.println(timeMillis); //从1970年一月一号8:00
//
//    long start = System.nanoTime();
////    System.out.println(l);
//    for (int i = 0; i < 10000; i++) {
//      System.out.println(i);
//    }
//
//    long end = System.nanoTime();
//    System.out.println(end - start);  // 1 1000微秒  1 1000纳秒
//
    int[] arr1 = {5, 31, 1, 1412, 1, 312};
    int[] arr2 = {5, 3, 1, 112};

    System.arraycopy(arr1, 2, arr2, 2, 1);
    System.out.println(Arrays.toString(arr2));

    String[] str = {"as", "gfsd", "zzzd", "asdas", "hkhka"};

    // Arrays.sort(arr1);
    //  Arrays.sort(str);
    System.out.println(Arrays.toString(str));

    //Arrays.fill(arr1, 1, 3, 4);
    System.out.println(Arrays.toString(arr1));
    final int i = Arrays.binarySearch(arr1, 1);
    System.out.println("1在数组中:" + i);

    int mismatch = Arrays.mismatch(arr1, arr2);
    System.out.println(mismatch);


  }
}
