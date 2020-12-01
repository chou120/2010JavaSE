package club.banyuan.gen;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 11:11 上午
 */
public class Point<K,V> {

  private  K  x;
  private  V  y;

  public Point() {
  }

  public Point(K x, V y) {
    this.x = x;
    this.y = y;
  }

  public K getX() {
    return x;
  }

  public void setX(K x) {
    this.x = x;
  }

  public V getY() {
    return y;
  }

  public void setY(V y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  //  private Double aDouble;
//  private Double bDouble;

//
//  private  String  x;
//  private  String  y;
//
//  public String getX() {
//    return x;
//  }
//
//  public void setX(String x) {
//    this.x = x;
//  }
//
//  public String getY() {
//    return y;
//  }
//
//  public void setY(String y) {
//    this.y = y;
//  }

  // private Integer x;
//  private Integer y;
//
//  public Point(Integer x, Integer y) {
//    this.x = x;
//    this.y = y;
//  }
//
//  public Integer getX() {
//    return x;
//  }
//
//  public void setX(Integer x) {
//    this.x = x;
//  }
//
//  public Integer getY() {
//    return y;
//  }
//
//  public void setY(Integer y) {
//    this.y = y;
//  }
//
//  @Override
//  public String toString() {
//    return "Point{" +
//        "x=" + x +
//        ", y=" + y +
//        '}';
//  }
}
