package club.banyuan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupDemo {

  public static void main(String[] args) {
    String src = "  <meta charset=\"UTF-8\">\n"
        + "  <title>系统登录 - 超市账单管理系统</title>\n"
        + "  <link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\"/>\n"
        + "  <link rel=\"icon\" href=\"data:image/ico;base64,aWNv\">";

    // 正则表达式中使用括号对内容进行分组，使用组编号，可以提取出组内的字符串
    String regex = "<title>(.*)</title>";

    // 通过一个正则表达式生成Pattern 用户进行正则匹配
    Pattern pattern = Pattern.compile(regex);

    // 通过pattern matcher传入目标字符串，返回一个Matcher对象
    Matcher matcher = pattern.matcher(src);

    // 表示是否查找到匹配的字符串
    if (matcher.find()) {
      System.out.println(matcher.groupCount());
      System.out.println(matcher.group(0));
      System.out.println(matcher.group(1));
    }

    // 增加？ 使用勉强模式， 如果一行中 出现多个 "" ，逐个提取
    Pattern quotesPattern = Pattern.compile("\"(.*?)\"");

    Matcher quotesMather = quotesPattern.matcher(src);

    Pattern colonPattern = Pattern.compile("(.*):(.*);(.*)");

    while (quotesMather.find()) {
      System.out.println("====");
      String group = quotesMather.group(1);
      System.out.println(group);
      Matcher colon = colonPattern.matcher(group);
      if(colon.find()){
        System.out.println(colon.group(1));
        System.out.println(colon.group(2));
        System.out.println(colon.group(3));
      }
    }
  }
}
