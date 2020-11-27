package club.api;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 9:38 上午
 */
public class ReserveDemo {


  public static void main(String[] args) {
    String   str="To be or not to be";
    String[] s = str.split(" ");
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i <s.length; i++) {
       String reverse = stringBuffer.reverse(s[i]);
       stringBuffer.append(reverse+" ");
    }
    System.out.println(stringBuffer.toString());
  }
}
