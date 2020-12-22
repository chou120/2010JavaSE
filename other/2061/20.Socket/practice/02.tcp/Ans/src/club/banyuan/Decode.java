package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Decode {

  // /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code.decode
  static String encodeFilePath = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/02.CaesarCipher/alice.code";
  static String decodeFilePath = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/02.CaesarCipher/alice.code.decode";

  public static char caesarDecode(char ch) {
    if (Character.isUpperCase(ch)) {
      return (char) ((ch - Encode.FIRST_UPPER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - Encode.FIRST_LOWER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_LOWER);
    } else {
      return ch;
    }
  }

}

