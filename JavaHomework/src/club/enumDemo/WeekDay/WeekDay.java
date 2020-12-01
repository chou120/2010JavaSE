package club.enumDemo.WeekDay;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 9:19 下午
 */
public enum WeekDay {
//  使用MONDAY，TUESDAY ...直到星期日的常量创建一个公共枚举类Weekday。
//  枚举应具有实例方法boolean isWeekDay()和实例方法boolean isHoliday()。
//  isHoliday()方法应返回isWeekDay()相反的值
//
//  编写一个程序演示如何使用此枚举，该程序具有一个以Weekday作为参数并根据Weekday是否为假日打印消息的方法。
//  我们建议main方法循环遍历Weekday枚举中的所有值，并将它们作为参数发送给该方法。
//  提示：Java中的每个枚举都有一个静态values()方法，该方法返回枚举中值的数组，因此可以为此使用for-each-loop（增强的for循环）。
//  提示：每个枚举都有一个toString()实现，该实现返回在枚举中声明的常量名称，可以重写该方法返回自定义的值例如“星期五”

  MONDAY("星期一",false), TUESDAY("星期2",false), WEDNESDAY("星期3",false),
  THURSDAY("星期4",false), FRIDAY("星期5",false), SATURDAY("星期6",true),
  SUNDAY("星期日",true);
  private String name;
  private boolean flag;

  WeekDay(String name,boolean flag) {
    this.name = name;
    this.flag=flag;
  }

  public boolean isHoliday() {
    return true;
  }

  public boolean isWeekDay() {
    return false;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public static void getWeekDay(WeekDay weekDay) {
      if (weekDay.flag) {  //
        System.out.println("-----"+weekDay.toString()+",是假日");
      }else {
        System.out.println(">>>>>"+weekDay.toString()+"不是假日");
      }
  }
}
class  Test{
  public static void main(String[] args) {
    final WeekDay[] values = WeekDay.values();
    for (WeekDay value : values) {
      WeekDay.getWeekDay(value);
    }

   // System.out.println("+-*".length());

  }
}
