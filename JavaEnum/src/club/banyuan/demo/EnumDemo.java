package club.banyuan.demo;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/30 10:29 上午
 */
public class EnumDemo {

  public static final int MONDAY =1;
  public static final int TUESDAY=2;
  public static final int WEDNESDAY=3;
  public static final int THURSDAY=4;
  public static final int FRIDAY=5;
  public static final int SATURDAY=6;
  public static final int SUNDAY=7;

  public  static  void  getInfo(Day   day){

    switch (day){

      case THURSDAY:
        System.out.println("今天是:"+day);
        break;
      case SATURDAY:

      case WEDNESDAY:

    }

  }

}
