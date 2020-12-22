package club.banyuan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CipherServer {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      System.out.println("等待客户端接入");
      Socket socket = serverSocket.accept();
      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + "：接入");

      InputStream inputStream = socket.getInputStream();
      // 先读一个byte，判断是加密还是解密
      int codeFlag = inputStream.read();

      // 在读4个byte，判断后续需要读取的文件长度
      byte[] lenBytes = new byte[4];
      inputStream.read(lenBytes);

      // 获取到文件的长度
      int fileLength = ByteToInt.toInt(lenBytes);

      byte[] fileData = new byte[fileLength];
      inputStream.read(fileData);

      String target = new String(fileData);

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
      } else {
        System.out.println("加解密标识异常:" + codeFlag);
        continue;
      }

      OutputStream outputStream = socket.getOutputStream();

      // 先写4byte，表示字符长度
      byte[] rltBytes = rlt.toString().getBytes();
      outputStream.write(ByteToInt.toBytes(rltBytes.length));

      // 再写长度这么多的byte
      outputStream.write(rltBytes);

      socket.close();

    }


  }
}
