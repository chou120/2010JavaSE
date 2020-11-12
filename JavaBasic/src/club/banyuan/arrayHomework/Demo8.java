package club.banyuan.arrayHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 11:10 上午
 */
public class Demo8 {

  /**
   * 编写一个方法，输入一个 单位是byte的字节数， 返回一个字符串，后面使用合适的单位进行标识
   *
   * @param args
   */

  public static void main(String[] args) {

    System.out.println(formateByte(1532300001));

  }

  public static String formateByte(long bytes) {

    /**
     * 转换结果如下
     * 123  => 123.0 B         1000000000B==1000000kB == 1000MB == 1GB
     * 15323 => 15.323 KB
     * 15323000 => 15.323 MB
     * 1532300001 => 1.532300001 GB
     */
    String str = "";
    if (bytes < 1000) {
      str = str + bytes / 1.0 + "B";
    } else if (bytes < 1000000) {
      str = str + bytes / 1000.0 + "KB";
    } else if (bytes < 1000000000) {
      str = str + bytes / 1000000.0 + "MB";
    } else if (bytes < 1000000000000L) {
      str = str + bytes / 1000000000.0 + "GB";
    }

    return str;
  }

}
