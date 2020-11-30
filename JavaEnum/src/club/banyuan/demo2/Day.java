package club.banyuan.demo2;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 11:05 上午
 */
public enum Day {

  //下面代码前面没有任何其他代码
  MONDAY("周一"), TUESDAY("周二"), WEDNESDAY("周三"),
  THURSDAY("周四"), FRIDAY("周五"), SATURDAY("周六"), SUNDAY("周日"),
  DESCRIPTION("帅哥靓女");

  private String name;
 // private  int  number;

   Day(String name){  //默认就是私有
    this.name=name;
   // this.number=number;
  }

  public String getName() {
    return name;
  }

}
class  Test{
  public static void main(String[] args) {
     Day[] values = Day.values();
    /**
     * for(数据类型   变量名 : 数组名或者集合名 ){
     *    // 数据类型 指的是数组里面元素的数据类型或者是集合里面元素的数据类型
     *   //   变量名一般接收的的数组里面的元素或者是集合里面的元素
     * }
     */
   // new Day("sadassa");


    for (Day value : values) {
      System.out.println("-------->>>>>>>"+value.getName());
    }
  }
}