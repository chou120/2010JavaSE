package club.banyuan.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 2:24 下午
 */
public class DateDemo {


  public static void main(String[] args) throws ParseException {

    Date date = new Date();
//    System.out.println(System.currentTimeMillis());
    System.out.println(date.getTime());  // 2020年11月26号 14:30:26

//    date.setTime(2000);
//    System.out.println(System.currentTimeMillis());
//    System.out.println(date.getTime());

//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss SSS");
//    String format = simpleDateFormat.format(date);
//    System.out.println(format);
//
//    String str = "19900301";
//    simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//    Date parse = simpleDateFormat.parse(str);
//    System.out.println(parse);

    //计算自己从出生到现在过了几年几月几日

//     String info = info("19900301");  //2020  - 1990 30  11-3  8月  25
//    System.out.println(info);

    Calendar calendar = Calendar.getInstance();//
    //  calendar.set(Calendar.YEAR+2, 3, 5);
    calendar.add(Calendar.YEAR, -5);
    calendar.add(Calendar.MONTH, -3); //August

    System.out.println(calendar.getTime());
    System.out.println(calendar.getWeekYear());




  }

  public static String info(String dateString) throws ParseException {  //19900301
    //解析
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date parse = simpleDateFormat.parse(dateString);
    long birthday = parse.getTime();  //得到的是出生日期和计算机元年日期的间隔时间----毫秒值
    //获取当前系统时间到计算机元年时间间隔  毫秒值
    long time = System.currentTimeMillis();

    long timeMillis = time - birthday; //相差的毫秒值

    long year = timeMillis / 1000 / 3600 / 24 / 365;
    long month = timeMillis / 1000 / 3600 / 24 / 30 % 12;  //374%12  余2
    long date = timeMillis / 1000 / 3600 / 24;

    return "当前时间距我出生过去了:" + year + "年," + month + "月," + date + "天";

  }
}
