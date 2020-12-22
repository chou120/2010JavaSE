package club.banyuan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class FileClient {

  public static void main(String[] args) {
    int port = PropUtil.getIntProp("port");
    Socket socket = null;
    try {
      socket = new Socket("127.0.0.1", port);
      InputStream inputStream = socket.getInputStream();
      OutputStream outputStream = socket.getOutputStream();

      FileInfos fileInfos = getAndPrintInfos(inputStream);

      FileInfos downloadReq = chooseDownloadFile(fileInfos);
      outputStream.write(downloadReq.parseBytes());

      saveFile(inputStream);

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

  private static void saveFile(InputStream inputStream) throws IOException {
    FileInfos downloadFileInfo = FileInfos.parse(inputStream);
    long targetFileLength = downloadFileInfo.getTargetFileLength();

    String saveFolder = PropUtil.getProp("saveFolder");
    File folder = new File(saveFolder);
    if (!folder.isDirectory()) {
      folder.mkdirs();
    }

    File downloadFile = new File(folder, downloadFileInfo.getTargetFileName());

    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(downloadFile);
      byte[] buf = new byte[1024];
      int count = inputStream.read(buf, 0, (int) Math.min(buf.length, targetFileLength));

      while (count > 0) {
        fileOutputStream.write(buf, 0, count);
        targetFileLength -= count;
        count = inputStream.read(buf, 0, (int) Math.min(buf.length, targetFileLength));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

  // 循环直到输入的下载文件名正确
  private static FileInfos chooseDownloadFile(FileInfos fileInfos) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("选择想要下载的文件：");
    String input = scanner.nextLine();
    if (fileInfos.getFileNames().contains(input)) {
      fileInfos.setTargetFileName(input);
      return fileInfos;
    } else {
      return chooseDownloadFile(fileInfos);
    }
  }

  private static FileInfos getAndPrintInfos(InputStream inputStream) throws IOException {
    FileInfos fileInfos = FileInfos.parse(inputStream);
    System.out.println("文件列表");
    for (String fileName : fileInfos.getFileNames()) {
      System.out.println(fileName);
    }
    return fileInfos;
  }
}


