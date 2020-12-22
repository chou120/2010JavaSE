import java.util.Arrays;
// java.lang包是默认导入

public class StringDemo {

  /**
   * 字符串的操作API，都要接受新的返回值作为操作的结果，并不会影响到调用方法的字符串对象的值
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "12345678";

    // 去首位空格
    System.out.println("  123  1234  ".trim());

    // 是否包含指定的字符串
    System.out.println("12345678".contains("234"));

    s.replace("1", "3");

    // 替换字符串
    System.out.println("12345678".replace("123", "a"));
    System.out.println("12345123".replace("123", "a"));
    System.out.println("12345123".replaceFirst("123", "a"));
    System.out.println("12345123".replaceAll("123", "a"));

    System.out.println("1234567890".startsWith("123"));
    System.out.println("11234567890".startsWith("123", 1));

    // 字符串切割
    String[] split = "1990-01-05".split("-");
    System.out.println(split[0]);
    System.out.println(split[1]);
    System.out.println(split[2]);

    System.out.println(Arrays.toString("1990--01-05".split("-")));

    // 拆分字符串
    System.out.println("012345678".substring(2));
    // 从下表第二个位置截取直到下标为5停止，不包含5，[2,5)
    System.out.println("012345678".substring(2, 5));

    String subStr = "123456;";
    System.out.println(subStr.substring(0, subStr.length() - 1));

    char[] chars = "abcde".toCharArray();
    System.out.println(Arrays.toString(chars));

    System.out.println(new String(chars));

    System.out.println("abcde" == new String("abcde".toCharArray()));
    System.out.println("abcde" == new String("abcde"));
    System.out.println("abcde" == "abcde");
    String src = "c";
    System.out.println("abcde" == "ab" + src + "de");
    System.out.println("abcde" == "abc" + "de");

    System.out.println("abcde".equals("ab" + src + "de"));

    System.out.println("ABC".equalsIgnoreCase("abc"));
    System.out.println("ABC".equals("abc"));

    s.toLowerCase();
    s.toUpperCase();

    System.out.println("a123456a".indexOf('a'));
    System.out.println("a123456a".lastIndexOf('a'));
    System.out.println("a123456a".lastIndexOf("1234"));
    // 找不到返回-1
    System.out.println("a123456a".lastIndexOf("abcd"));
  }
}
