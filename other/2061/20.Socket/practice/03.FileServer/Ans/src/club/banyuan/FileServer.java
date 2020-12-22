package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileServer {

  public static void main(String[] args) throws IOException {

    int port = PropUtil.getIntProp("port");
    ServerSocket serverSocket = new ServerSocket(port);

    while (true) {
      Socket socket = null;
      try {
        System.out.println("等待客户端接入");
        socket = serverSocket.accept();

        FileInfos fileInfos = getFileList();

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        // 写文件列表
        outputStream.write(fileInfos.parseBytes());
        // 接收用户想要下载的文件
        FileInfos clientReq = FileInfos.parse(inputStream);

        sendFile(clientReq, outputStream);

      } catch (IOException e) {
        System.out.println(e.getMessage());
      } finally {
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }

    }

  }

  private static void sendFile(FileInfos clientReq, OutputStream outputStream) {
    // 客户端想要下载的文件名
    String targetFileName = clientReq.getTargetFileName();

    String folder = PropUtil.getProp("folder");
    File file = new File(folder);
    File[] files = file.listFiles();
    for (File one : files) {
      if (one.getName().equals(targetFileName) && one.isFile()) {
        FileInputStream fileInputStream = null;
        try {
          fileInputStream = new FileInputStream(one);
          int available = fileInputStream.available();
          clientReq.setTargetFileLength(available);

          outputStream.write(clientReq.parseBytes());

          byte[] buf = new byte[1024];
          int count = fileInputStream.read(buf);
          while (count > 0) {
            outputStream.write(buf, 0, count);
            System.out.println(Arrays.toString(buf));
            count = fileInputStream.read(buf);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            fileInputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

        // 写完文件，直接退出
        return;
      }
    }
    // TODO  exception

  }

  private static FileInfos getFileList() {
    String folder = PropUtil.getProp("folder");
    File file = new File(folder);
    File[] listFiles = file.listFiles();
    FileInfos fileInfos = new FileInfos();
    // 遍历文件夹，将文件名添加到列表中
    if (listFiles != null && listFiles.length != 0) {
      for (File one : listFiles) {
        if (one.isFile()) {
          fileInfos.addFileName(one.getName());
        }
      }
    }

    return fileInfos;
  }
}
