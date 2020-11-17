package club.banyuan.oop;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 9:40 上午
 */
public class DemoTest {

  public static void main(String[] args) {

    String [] str=new String[6];
    for (int i = 0; i < str.length-1; i++) {
      System.out.println("请输入第"+(i+1)+"个字符串:");
      str[i]="还有谁"+i;
    }

    //str={"张三丰","大四喜","二锅头"};  //str 和  str1 指向的是内存同一块  字符串数组
    System.out.println(str.hashCode()); //932607259
    String [] st={""};  //1740000325     1740000325
    System.out.println(st.hashCode());//1740000325
    str=st;




  }


}
