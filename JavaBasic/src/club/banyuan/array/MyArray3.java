package club.banyuan.array;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/11 1:48 下午
 */
public class MyArray3 {

  public static void main(String[] args) {
    //char  [] ch={12,34,'a'};
    int[] arr = new int[]{12, 3, 4, 12, 57, 12131, 55};

    /**
     * 遍历
     * for(数组里面元素的数据类型   变量名:数组或者集合名){
     *
     * }
     */
//    for (int i : arr) {
//      System.out.println(i);
//    }

//    int len=5;
//    int  [] arr1=new int[len];
//    arr1=new  int[9];
//

    /**
     * 二维数组:
     *
     */
    int[][] arrArr = new int[5][5];

//    System.out.println(arrArr[0][0]);
//    System.out.println(arrArr[0][1]);
//    System.out.println(arrArr[0][2]);
//    System.out.println(arrArr[0][3]);
//    System.out.println(arrArr[0][4]);

//    for (int i = 0; i <arrArr.length; i++) {  //i表示第几层
//      for (int j = 0; j <arrArr.length; j++) { //j表示每层有几个数据
//          arrArr[i][j]=(int)(Math.random()*50);
//      }
//    }
//
//    for (int i = 0; i < arrArr.length; i++) {
//      for (int j = 0; j <arrArr.length; j++) {
//        System.out.print(arrArr[i][j]+"\t");
//      }
//      System.out.println();
//    }

    int[][] ints = new int[4][];
    ints[0] = new int[3];
    ints[1] = new int[4];
    ints[2] = new int[5];
    ints[3] = new int[6];

    for (int i = 0; i < ints.length; i++) {  //i表示第几层
      for (int j = 0; j < ints[i].length; j++) { //j表示每层有几个数据
        ints[i][j] = (int) (Math.random() * 50);
      }
    }

    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        System.out.print(ints[i][j] + "\t");
      }
      System.out.println();
    }
    String[][] strArr = {
        {"张三", "栖霞下水道", "23"},
        {"李四", "玄武下水道", "24"},
        {"刘芳宇", "秦淮区巷子里", "22"}
    };

    for (String[] strings : strArr) {
      for (String string : strings) {
        System.out.print(string + "\t");
      }
      System.out.println();
    }
  }
}
