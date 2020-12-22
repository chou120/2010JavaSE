package club.banyuan.refine;

import club.banyuan.ByteToInt;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CipherClientRefine {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      Socket socket = null;
      FileInputStream fileInputStream = null;
      try {
        Byte codeFlag = getCodeFlag(scanner);
        File file = getInputFile(scanner);

        socket = new Socket("127.0.0.1", 5000);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        fileInputStream = new FileInputStream(file);

        sendFileContentForCoding(codeFlag, fileInputStream, outputStream);
        String codeMsg = getCodedFileContent(inputStream);
        System.out.println(codeMsg);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } finally {
        closeResource(socket, fileInputStream);
      }
    }
  }

  /**
   * 关闭资源
   *
   * @param closeable 可变长参数，可以传入多个 Closeable接口
   */
  private static void closeResource(Closeable... closeable) {

    for (Closeable one : closeable) {
      try {
        one.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static String getCodedFileContent(InputStream inputStream) throws IOException {
    byte[] lenBytes = new byte[4];
    inputStream.read(lenBytes);
    int len = ByteToInt.toInt(lenBytes);
    byte[] codeData = new byte[len];
    inputStream.read(codeData);

    String codeMsg = new String(codeData);
    return codeMsg;
  }

  private static void sendFileContentForCoding(Byte codeFlag, InputStream fileInputStream,
      OutputStream outputStream) throws IOException {
    int dataLength = fileInputStream.available();
    // 先向服务器发送1个byte，表示加密还是解密
    outputStream.write(codeFlag);

    outputStream.write(ByteToInt.toBytes(dataLength));

    byte[] dataBuf = new byte[1024];
    int read = fileInputStream.read(dataBuf, 0, Math.min(dataLength, dataBuf.length));
    while (read > 0) {
      outputStream.write(dataBuf, 0, read);
      dataLength -= read;
      read = fileInputStream.read(dataBuf, 0, Math.min(dataLength, dataBuf.length));
    }
  }

  private static File getInputFile(Scanner scanner) {
    System.out.println("输入文件路径：");
    String filePath = scanner.nextLine();
    File file = new File(filePath);
    if (!file.isFile()) {
      throw new IllegalInputException("文件不合法");
    }
    return file;
  }

  private static Byte getCodeFlag(Scanner scanner) {
    System.out.println("1.加密 \n2.解密");
    byte codeFlag = 0;
    String input = scanner.nextLine();
    if ("1".equals(input)) {
      codeFlag = 1;
    } else if ("2".equals(input)) {
      codeFlag = 2;
    } else {
      throw new IllegalInputException();
    }
    return codeFlag;
  }
}
