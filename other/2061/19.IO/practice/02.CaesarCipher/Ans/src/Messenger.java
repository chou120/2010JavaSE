import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class Messenger {

  public static void message(String target, String to, boolean isEncode) {
    try (
        BufferedReader reader = new BufferedReader(new FileReader(target));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to))
    ) {
      String line = reader.readLine();
      while (line != null) {
        char[] chars = line.toCharArray();
        // 逐个字符进行解密
        for (int i = 0; i < chars.length; i++) {
          if (isEncode) {
            chars[i] = Encode.caesarEncode(chars[i]);
          } else {
            chars[i] = Decode.caesarDecode(chars[i]);
          }
        }
        // 将解密后的内容写入到输出流
        writer.write(chars);
        // 因为读取的时候将换行符丢掉了，因此需要增加一个换行符
        writer.newLine();
        // 读取下一行
        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  public static void message(String target, String to, Function<Character, Character> processor) {
    try (
        BufferedReader reader = new BufferedReader(new FileReader(target));
        BufferedWriter writer = new BufferedWriter(new FileWriter(to))
    ) {
      String line = reader.readLine();
      while (line != null) {
        char[] chars = line.toCharArray();
        // 逐个字符进行解密
        for (int i = 0; i < chars.length; i++) {
          chars[i] = processor.apply(chars[i]);
        }
        // 将解密后的内容写入到输出流
        writer.write(chars);
        // 因为读取的时候将换行符丢掉了，因此需要增加一个换行符
        writer.newLine();
        // 读取下一行
        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
