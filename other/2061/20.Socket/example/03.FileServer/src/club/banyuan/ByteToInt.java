package club.banyuan;

public class ByteToInt {

  public static int toInt(byte[] bytes) {
    if (bytes == null || bytes.length != 4) {
      throw new IllegalArgumentException("byte数组长度不为4");
    }
    int rlt = 0;

    // 1001 0010 1101 0111 1001 1111 1000 1000
    for (int i = 0; i < bytes.length; i++) {
      rlt <<= 8;
      // 0000 0000 0000 0000 0000 0000 0000 0000
      //                               1001 0010
      // 0000 0000 0000 0000 0000 0000 1001 0010
      rlt |= bytes[i];
      // 0000 0000 0000 0000 1001 0010 0000 0000
      //                               1101 0111
      // 0000 0000 0000 0000 1001 0010 1101 0111
    }
    return rlt;
  }


  public static byte[] toBytes(int aInt) {
    byte[] rlt = new byte[4];
    for (int i = 0; i < rlt.length; i++) {
      rlt[i] = (byte) (aInt >> (8 * (rlt.length - i - 1)));
      System.out.println(aInt);
    }
    return rlt;
  }


  public static void main(String[] args) {
    // 0000 0000 0000 0000 0000 0000 0001 0000
    byte[] bytes = new byte[4];
    // bytes => int

    // int a = 55;
    // byte[] bytes1 = toBytes(55);
    // System.out.println(toInt(bytes1));

    String name = "c.pdf";


  }
}
