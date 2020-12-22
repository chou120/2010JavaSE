public class WrapperClass {

  // 包装类
  public static void main(String[] args) {
    // int      long double boolean char      float byte short
    // Integer  Long Double boolean Character Float Byte Short
    Integer a = new Integer(1);
    Integer b = Integer.valueOf(1);

    // 基本数据类型和包装数据类型的互转
    int aInt = 5;
    // 自动装箱
    Integer aInteger = aInt;

    // 自动拆箱
    aInt = aInteger;

    Integer nullInteger = null;
    // 自动拆箱可能会引发空指针异常
    // aInt = nullInteger;

    // 数值比较的时候，包装类自动拆箱，可能会引发空指针异常
    // if (aInt == nullInteger) {
    //
    // }

    // 基本数据类型的值和 String之间的转换
    int i = Integer.parseInt("1234");
    System.out.println(i);
    // radix 表示 按照几进制的方式看待字符串
    int i1 = Integer.parseInt("8", Character.MAX_RADIX);
    System.out.println(i1);

    // 包装类转字符串
    System.out.println(Integer.toBinaryString(0xFF));
    System.out.println(Integer.toHexString(0xFF).toUpperCase());
    // Integer.toString();
    // aInteger.toString();
  }

}
