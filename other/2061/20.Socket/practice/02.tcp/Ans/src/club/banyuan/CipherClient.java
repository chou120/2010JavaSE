package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CipherClient {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1.加密 \n 2.解密");
      byte codeFlag = 0;
      String input = scanner.nextLine();
      if ("1".equals(input)) {
        codeFlag = 1;
      } else if ("2".equals(input)) {
        codeFlag = 2;
      } else {
        System.out.println("输入不合法");
        continue;
      }

      System.out.println("输入文件路径：");
      String filePath = scanner.nextLine();
      File file = new File(filePath);
      if (!file.isFile()) {
        System.out.println("文件不合法");
        continue;
      }

      try {
        InputStream fileInputStream = new FileInputStream(file);
        byte[] data = fileInputStream.readAllBytes();
        String dataStr = new String(data);
        // 源文件中使用 \r 作为换行符，导致 println 输出一行的长度过长，替换为 \n 让内容能够在控制台正确的换行
        dataStr = dataStr.replaceAll("\r", System.lineSeparator());
        data = dataStr.getBytes();
        Socket socket = new Socket("127.0.0.1", 5000);
        OutputStream outputStream = socket.getOutputStream();
        // 先向服务器发送1个byte，表示加密还是解密
        outputStream.write(codeFlag);

        outputStream.write(ByteToInt.toBytes(data.length));

        outputStream.write(data);

        InputStream inputStream = socket.getInputStream();
        byte[] lenBytes = new byte[4];
        inputStream.read(lenBytes);
        int len = ByteToInt.toInt(lenBytes);
        byte[] codeData = new byte[len];
        inputStream.read(codeData);

        String codeMsg = new String(codeData);
        System.out.println(codeMsg);

        socket.close();
        fileInputStream.close();

      } catch (IOException e) {
        e.printStackTrace();
      }


    }
  }
}
