package club.banyuan.serverFile;

import java.io.Serializable;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/10 7:41 下午
 */
public class FileData {

  private String fileName;//文件名
  private int  fileLength;//文件大小

  public FileData() {
  }

  public FileData(String fileName, int fileLength) {
    this.fileName = fileName;
    this.fileLength = fileLength;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getFileLength() {
    return fileLength;
  }

  public void setFileLength(int fileLength) {
    this.fileLength = fileLength;
  }

  @Override
  public String toString() {
    return "FileData{" +
        "fileName='" + fileName + '\'' +
        ", fileLength=" + fileLength +
        '}';
  }
}
