package club.banyuan.gen;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 11:14 上午
 */
public class TestPoint {

  public static void main(String[] args) {
//    Point point = new Point();
//    point.setX(34);
//    point.setY("张三丰");  //存放数据类型不同
//
//    Integer x = (Integer)point.getX();
//    Integer y = (Integer)point.getY();  //不知道出错  如果将程序运行的报错从运行时异常提升到编译时异常
//
//
//    System.out.println(y+x);

//    Point<String, Integer> stringIntegerPoint = new Point<>();
//    stringIntegerPoint.setX("zhangsanf");
//    stringIntegerPoint.setY(123);
//
//    final String x = stringIntegerPoint.getX();
//    final Integer y = stringIntegerPoint.getY();

    final Point<String, User> objectObjectPoint = new Point<>();
    objectObjectPoint.setX("刘备");
    objectObjectPoint.setY(new User("孙尚香", 34));
    User y = objectObjectPoint.getY();
    System.out.println(objectObjectPoint.toString());


  }
}
