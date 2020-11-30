package club.banyuan.demo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 10:35 上午
 */
public enum Day {
  //枚举常量对象 建议使用大写,逗号隔开
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

  //私有化构造器
  private Day() {

  }

//  valueOf 默认提供  用于返回一个枚举类对象实例，因为枚举类中有限个枚举对象，根据传入的对象名称来返回对应的对象，如果没有找到对应的名称，则会抛出异常
//  public  static  Day  valueOf(String  name){
//    Day[] values = Day.values();
//    for (int i = 0; i <values.length; i++) {
//      if(name.equals(values[i].name())){
//        return  values[i];
//      }
//    }
//    return null;
//  }


  @Override
  public String toString() {
    return super.toString();
  }
}

class TestEnum {

  public static void main(String[] args) {
    Day day = Day.THURSDAY;  //当成静态常量调用
    System.out.println(day);

//    switch (day){
//
//      case THURSDAY:
//        System.out.println("今天是:"+day);
//        break;
//      case SATURDAY:
//
//      case WEDNESDAY:
//
//    }

    // EnumDemo.getInfo(Day.MONDAY);

    Day[] values = Day.values();
    for (Day value : values) {
      System.out.println(value + "在" + value.ordinal() + "位置");
    }

     Day day1 = Day.valueOf("SUNDAY");
    System.out.println("day1>>>>"+day1);

     int i = Day.TUESDAY.compareTo(Day.SATURDAY);
    System.out.println(i);



  }
}