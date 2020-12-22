public class ByteToInt {

  public static void main(String[] args) {
    // 1111 1111
    // 1111 1111 1111 1111 1111 1111 1111 1111
    // 0000 0000 0000 0000 0000 0000 1111 1111
    byte one = -1;
    int aInt = one & 0xFF;
    System.out.println(aInt);

  }
}
