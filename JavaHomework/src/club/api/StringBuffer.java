package club.api;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 9:08 上午
 */
public class StringBuffer {


  private String strings = "";

  public void append(String str) {
    strings += str;
  }

  public void append(char str) {
    strings += str;
  }

  public void append(Object object) {
    //
    strings += String.valueOf(object);
  }


  public String toString() {
    return strings;
  }

  void clear() {
    strings = "";
  }

  /**
   * 将之前的输入内容反转
   */
  String reverse() {  //  asdf   fdsa
    char[] chars = strings.toCharArray();
    char[] newChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      newChars[chars.length - 1 - i] = chars[i];
    }
    strings = new String(newChars);
    return strings;
  }

  /**
   * 将指定位置的字符串反转 from 从0起始 to 不包含在内 即[from,to) 例如 abcdefg => reverse(1,3) => acbdefg
   * <p>
   * fhjb  dajnb   hdj
   */
  public String reverse(int from, int to) {
    if (from > to || to > strings.length()) {
      System.out.println("输入位置不正确....");
      return null;
    }
    String str1 = strings.substring(0, from);
    String str2 = strings.substring(to, strings.length());

    String str3 = strings.substring(from, to);

    return str1 + reverse(str3) + str2;
  }


  String reverse(String string) {  //  asdf   fdsa
    char[] chars = string.toCharArray();
    char[] newChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      newChars[chars.length - 1 - i] = chars[i];
    }
    string = new String(newChars);
    return string;
  }

}


class Test {

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append('a');
    stringBuffer.append("哈的");
    stringBuffer.append("奥术大师");
    stringBuffer.append("分数高低");

    System.out.println(stringBuffer.toString());

//    String reverse = stringBuffer.reverse();
//    System.out.println(reverse);

    String reverse1 = stringBuffer.reverse(2, 6);
    System.out.println(reverse1);

    stringBuffer.append(new User("张三","asdaskhas"));
    System.out.println(stringBuffer.toString());


  }
}