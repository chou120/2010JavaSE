package club.banyuan.string2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 4:32 下午
 */
public class StringDemo {

  public static void main(String[] args) {
    String  str1=new  String("1");  //常量位于常量池中
    String  str2=new  String("1"); //
    System.out.println(str1.equals(str2)); // true
    System.out.println(str1==str2); //false
    System.out.println(str1.hashCode()+":"+str2.hashCode());

    String str3="小红";
    String str4="小红";
    System.out.println(str3.equals(str4));
    System.out.println(str3==str4);


    String  str5="张三丰";
    String  str6="耍太极";

    String str7="张三丰耍太极";

    String   str8=str6+str5;

    System.out.println((str5+str6)==str7);
    System.out.println((str5+str6).equals(str7));
    System.out.println(   str7.equals(str5+str6)    );
    System.out.println(str7.hashCode()+":"+(str5+str6).hashCode());

    System.out.println(str8==str7);
    System.out.println(str8.hashCode()+":::"+str7.hashCode());


    String str9="张三丰张三丰耍太极耍太极";
    System.out.println(str9.hashCode()+"::::"+(str5+str5+str6+str6).hashCode());




  }
}
