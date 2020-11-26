package club.banyuan.string;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 3:41 下午
 */
public class StringDemo {

  public static void main(String[] args) {
    String str = new String("张帆在挣南京上班挣钱养挣家");
    System.out.println(str.length());
    char c = str.charAt(1);
    System.out.println(c);

    System.out.println(str.equals("张帆在挣南京上班挣钱养挣家"));

//    System.out.println(str.startsWith("张"));
//
//    String[] s = str.split("\\.");
//    System.out.println(Arrays.toString(s));

//    final boolean matches = "挣".matches(str);
//    System.out.println(matches);

    final String trim = str.trim();
    System.out.println("=" + trim + "=");

    String replace = str.replace("挣", "花");
    System.out.println(replace);

    final boolean flag = replace.contains("花钱");
    System.out.println(">>>>>" + str);
    System.out.println(flag);

    final String s = str.replaceAll("挣", "#");

    System.out.println(s);
    //139****8989

    System.out.println(getPhone("13412341234"));

    str = "akbeknjkda";
    String str1 = "acdew";
    System.out.println(str.compareTo(str1));

    char[] chars = str.toCharArray();
    System.out.println(Arrays.toString(chars));

    System.out.println("转换成大写:" + str.toUpperCase());
    System.out.println("第一次出现的位置:" + str.indexOf("k"));
    System.out.println(str.lastIndexOf("k"));
    System.out.println(str.equalsIgnoreCase("akBeknjkda"));

    str = "跑马的汉字";
    byte[] bytes = str.getBytes();

    byte[] gbks = str.getBytes(Charset.forName("GBK"));
    String s1 = new String(gbks,Charset.forName("GBK")); //GB2312   big5  ISO8859-1

    System.out.println(s1);

   // String.valueOf()=====new  String()




  }
  public static String getPhone(String phone) {
    if (phone == null) {
      return null;
    }
    if (phone.length() != 11) {
      System.out.println("手机格式不对");
      return null;
    }
    if (phone.startsWith("1")) { // 132****3423
      String substring1 = phone.substring(0, 3);
      String substring2 = phone.substring(7, phone.length());
      return substring1 + "****" + substring2;

    }
    return null;
  }


}
