import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.function.Function;

public class Decode {

  // /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/02.CaesarCipher/alice.code.decode
  static String encodeFilePath = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/02.CaesarCipher/alice.code";
  static String decodeFilePath = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/02.CaesarCipher/alice.code.decode";

  public static void main(String[] args) throws IOException {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    String inputFilePath = encodeFilePath;
    String outputFilePath = decodeFilePath;

    System.out.println("输入文件：" + inputFilePath);
    System.out.println("输出文件：" + outputFilePath);
    // TODO
    //完成此部分代码，调用 caesarDecode 对传入的inputFilePath文件进行解密
    //将解密后的文本输出到 outputFilePath 文件中
    //尝试将alice.code进行解密

    // Messenger.message(inputFilePath, outputFilePath, false);
    Messenger.message(inputFilePath, outputFilePath, Decode::caesarDecode);
    System.out.println("解密成功！");
  }

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

