package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileInfos {

  // 目录下的文件列表名称
  private List<String> fileNames = new ArrayList<>();

  // 准备要下载的文件名
  private String targetFileName;

  // 下载的文件长度
  private long targetFileLength;

  // 将对象转换为JSON字符串，将字符串的byte数组，前面再拼接4byte长度内容，之后的结果返回
  public byte[] parseBytes() {
    String s = JSONObject.toJSONString(this);
    byte[] data = s.getBytes();
    byte[] head = ByteToInt.toBytes(data.length);
    byte[] rlt = Arrays.copyOf(head, data.length + head.length);
    System.arraycopy(data, 0, rlt, head.length, data.length);
    return rlt;
  }

  public static FileInfos parse(InputStream inputStream) throws IOException {
    byte[] jsonLenByte = new byte[4];
    int count = inputStream.read(jsonLenByte);
    if (count != jsonLenByte.length) {
      throw new IOException("读取长度异常");
    }
    int len = ByteToInt.toInt(jsonLenByte);
    byte[] data = new byte[len];
    count = inputStream.read(data);
    if (count != data.length) {
      throw new IOException("读取长度异常");
    }
    return JSONObject.parseObject(data, FileInfos.class);
  }

  public void addFileName(String fileName) {
    fileNames.add(fileName);
  }

  public static void main(String[] args) throws IOException {
    FileInfos fileInfos = new FileInfos();
    fileInfos.setFileNames(new ArrayList<>());
    fileInfos.getFileNames().add("1234");
    fileInfos.getFileNames().add("2234");
    fileInfos.getFileNames().add("3234");
    fileInfos.setTargetFileLength(1234);
    fileInfos.setTargetFileName("1234");

    byte[] byes = fileInfos.parseBytes();

    System.out.println(fileInfos);

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byes);

    FileInfos parse = FileInfos.parse(byteArrayInputStream);
    System.out.println(parse);
  }

  public List<String> getFileNames() {
    return fileNames;
  }

  public void setFileNames(List<String> fileNames) {
    this.fileNames = fileNames;
  }

  public String getTargetFileName() {
    return targetFileName;
  }

  public void setTargetFileName(String targetFileName) {
    this.targetFileName = targetFileName;
  }

  public long getTargetFileLength() {
    return targetFileLength;
  }

  public void setTargetFileLength(long targetFileLength) {
    this.targetFileLength = targetFileLength;
  }

  @Override
  public String toString() {
    return "FileInfos{" +
        "fileNames=" + fileNames +
        ", targetFileName='" + targetFileName + '\'' +
        ", targetFileLength=" + targetFileLength +
        '}';
  }
}
