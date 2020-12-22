package club.banyuan.refine;

import club.banyuan.ByteToInt;
import club.banyuan.Decode;
import club.banyuan.Encode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CipherServerRefine {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      System.out.println("等待客户端接入");
      Socket socket = null;
      try {
        socket = serverSocket.accept();
        printClientInfo(socket);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 先读一个byte，判断是加密还是解密
        int codeFlag = getCodeFlag(inputStream);
        String target = getCodingContent(inputStream);
        String rlt = codeContent(codeFlag, target);
        sendCodedContent(rlt, outputStream);

      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }


  }

  private static void sendCodedContent(String rlt, OutputStream outputStream) throws IOException {
    // 先写4byte，表示字符长度
    byte[] rltBytes = rlt.getBytes();
    outputStream.write(ByteToInt.toBytes(rltBytes.length));

    // 再写长度这么多的byte
    outputStream.write(rltBytes);
  }

  private static int getCodeFlag(InputStream inputStream) throws IOException {
    int codeFlag = inputStream.read();
    if (codeFlag != 1 && codeFlag != 2) {
      throw new IllegalInputException("加解密标识异常:" + codeFlag);
    }
    return codeFlag;
  }

  private static String codeContent(int codeFlag, String target) {
    StringBuilder rlt = new StringBuilder();
    // 1： 加密， 2：解密，其他的认为是不合法
    if (codeFlag == 1) {
      for (char c : target.toCharArray()) {
        rlt.append(Encode.caesarEncode(c));
      }
    } else if (codeFlag == 2) {
      for (char c : target.toCharArray()) {
        rlt.append(Decode.caesarDecode(c));
      }
    } // 异常场景在上面已经处理过了，这里codeFlag只能有两种情况
    return rlt.toString();
  }

  private static String getCodingContent(InputStream inputStream) throws IOException {
    // 在读4个byte，判断后续需要读取的文件长度
    byte[] lenBytes = new byte[4];
    inputStream.read(lenBytes);

    // 获取到文件的长度
    int fileLength = ByteToInt.toInt(lenBytes);

    byte[] fileData = new byte[fileLength];
    inputStream.read(fileData);

    String target = new String(fileData);
    return target;
  }

  private static void printClientInfo(Socket socket) {
    String hostAddress = socket.getInetAddress().getHostAddress();
    System.out.println(hostAddress + "：接入");
  }
}
