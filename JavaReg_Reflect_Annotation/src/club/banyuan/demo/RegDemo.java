package club.banyuan.demo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/16 1:34 下午
 */
public class RegDemo {


  public static void main(String[] args) {

    // [abc] [^abc] [a-z] [a-zA-Z0-9]

    String str = "abc";
    String reg = "[abc]{3}";

    str = "rgj";
    reg = "[^abc]{3}";

    str = "tuyhb";
    reg = "^z[a-z]{4}";  //^X 以X为开头  X表示字符

    String password = "";  //空格表示空字符串
    reg = "([a-zA-Z0-9]?)";  // 表示在格式范围内匹配一个或者0个

    password = "adty5";
    reg = "[a-zA-Z0-9]*";

    password = "a";
    reg = "[a-zA-Z0-9]+";

    password = "d&fs_d$c%a ( 9)a-s*d、=a+s";

    reg = ".+";

    reg = "\\d{6,10}";
    reg = "\\D{6,10}";  //
    password = "wfeva在";
    password = "bgvfas9gsa jn";
    reg = "[a-z]{4}\\S\\w{5}\\s[a-z]{2}";

/*
    电话号码由数字和“-”组成

    1. 如果包含区号，那么区号为三位或四位，首位是0
    2. 区号用“-”和其他数字分割
    3. 除了区号，电话号码为7到8位
    4. 手机号码为11位
    5. 11位手机号码的前2位为“13”，“14”，“15”，“17”，“18”

    */

    String phone = "0556-6789567"; //
    reg = "^[0](\\d{2}-\\d{8}|\\d{3}-\\d{7})";

    phone = "(+86)13567894567";
    reg = "^1[345789]\\d{9}"; // ^1[345789]\d{9} 一个字符正则表达式必须以1开头

    reg = "\\(\\+86\\)?[1][345789]\\d{9}";  // (+86)



   /* ### 身份证号码的正则

    1. 长度：15位或者18位
    2. 如果是15位，则都是数字
    3. 如果是18位，最后一位可能为数字或字母X

    */

    reg = "\\d{15}|\\d{17}[X0-9]";

    System.out.println("12342112343341234o".matches(reg));

  }
}
