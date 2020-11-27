package club.api.stringBuffer;

import club.api.User;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 9:28 上午
 */
public class StringBufferDemo {


  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer("奥术大师");
    System.out.println(stringBuffer.length()); //内容的长度
    System.out.println(stringBuffer.capacity());  //理想的长度

    stringBuffer.append("asdad");
    stringBuffer.append("张三");
    stringBuffer.append("李四");

    System.out.println(stringBuffer);

    stringBuffer.delete(1, 5);

    System.out.println("删除之后数据:" + stringBuffer);

    String substring = stringBuffer.substring(2, 5);
    System.out.println("截取到的数据为:" + substring + ",截取之后本身的数据为:" + stringBuffer);

    stringBuffer.insert(2, new User("李四", "小哈哈哈是"));

    System.out.println(stringBuffer);

    String substring1 = stringBuffer.substring(3);
    System.out.println(substring1);
    System.out.println(stringBuffer);


  }
}
