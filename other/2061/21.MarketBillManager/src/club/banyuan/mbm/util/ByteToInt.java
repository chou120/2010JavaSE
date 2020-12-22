package club.banyuan.mbm.util;

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
      // 对于负值的情况，需要先把byte转int，转int之后，高位补的全部是1，需要先把高位都清空
      rlt |= bytes[i] & 0xFF;
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
    }
    return rlt;
  }
}
