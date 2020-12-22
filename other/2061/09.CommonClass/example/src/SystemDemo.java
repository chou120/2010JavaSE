public class SystemDemo {

  public static void main(String[] args) {
    // 获取 当前时间的时间戳
    // 从1970-1-1 0点
    System.out.println(System.currentTimeMillis());

    System.out.println(System.lineSeparator());
    int[] a = new int[10];
    int[] b = new int[10];
    // 从a 数组，复制数据到b数组
    // 从a数组第0个位置起始，复制数据到b数组，从b数组第0个位置起始填充，一共复制10个
    System.arraycopy(a, 0, b, 0, 10);

    // 从a数组复制元素，从下标是3的元素开始复制，一共复制3个，写入到b数组，从下标为1的位置开始写入
    System.arraycopy(a, 3, b, 1, 3);

    //System.exit(0);

    int size = 0xFFFFFF;
    int[] src = new int[size];
    // 初始化src ，0~n的数据
    for (int i = 0; i < size - 1; i++) {
      src[i] = i;
    }

    int[] dest = new int[size];
    long time = System.currentTimeMillis();
    copyArrayUseSystem(src,dest);
    long endtime = System.currentTimeMillis() - time;
    System.out.println(endtime);
    long time2 = System.currentTimeMillis();
    copyArrUseFor(src,dest);
    long endtime2 =System.currentTimeMillis() - time2;
    System.out.println(endtime2);



  }

  public static void copyArrUseFor(int[] from, int[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }

  public static void copyArrayUseSystem(int[] from, int[] to) {
    System.arraycopy(from, 0, to, 0, from.length);
  }
}
