package club.banyuan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SplitFileDemo {

  /**
   * @param sourceFile   目标文件
   * @param size         拆分文件大小 byte为单位
   * @param targetFolder 生成的拆分文件路径，如果传入的路径不存在，则创建这个路径
   *                     拆分文件的命名规则，原始文件名.编号。
   *                     例如 WIN.mp3 拆分后，变为 WIN.mp3.1  WIN.mp3.2 ....
   */
  void split(File sourceFile, int size, File targetFolder) {
    try (BufferedInputStream inputStream = new BufferedInputStream(
        new FileInputStream(sourceFile))) {

      // 给文件名字增加编号
      int fileCount = 1;

      // 循环直到待拆分的文件流中不再有未被处理的数据
      while (inputStream.available() > 0) {
        // 创建一个用来保存部分数据的文件对象，文件名以.数字结尾，数字应该逐个递增
        File oneFile = new File(targetFolder, sourceFile.getName() + "." + fileCount);
        fillFile(inputStream, size, oneFile);
        fileCount++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 从inputStream读取 oneFileLeft 这么多的数据，写入到 oneFile中
   *
   * @param inputStream
   * @param oneFileLeft
   * @param oneFile
   * @throws IOException
   */
  private void fillFile(BufferedInputStream inputStream, int oneFileLeft, File oneFile)
      throws IOException {
    try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
        new FileOutputStream(oneFile))) {
      byte[] buf = new byte[1024];
      // 记录每次从流中读取到的数据的长度
      // Math.min 表示 剩余的长度小于buf的长度时，只需要读取剩余长度的数据即可，因为要保证写入的文件的长度不超过oneFileLeft
      int count = inputStream.read(buf, 0, Math.min(oneFileLeft, buf.length));
      // 如果文件被装满，或者inputStream中没有多余的数据，就结束循环
      while (count > 0 && oneFileLeft > 0) {
        bufferedOutputStream.write(buf, 0, count);
        // 写入指定长度数据后，文件剩余长度应该相应的减少
        oneFileLeft -= count;
        count = inputStream.read(buf, 0, Math.min(oneFileLeft, buf.length));
      }
    }
  }

  /**
   * 将制定文件夹下的拆分文件合并为一个文件，将文件保存到指定的路径下
   *
   * @param sourceFolder 拆分文件所处的路径，其下的文件命名规则，同split拆分出来的文件名一致
   * @param targetFolder 合并之后的文件保存的路径，如果路径不存在，则创建这个目录
   */
  void combine(File sourceFolder, File targetFolder) {
    // 从sourceFolder 中确定文件名字，和文件数量
    String[] list = sourceFolder.list();
    int fileCount = 0;
    String fileName = null;
    for (String s : list) {
      // 统计文件夹中文件的数量
      if (!s.startsWith(".")) {
        fileCount++;
        if (fileName == null) {
          fileName = s.substring(0, s.lastIndexOf("."));
        }
      }
    }

    if (fileName == null) {
      throw new IllegalArgumentException("文件夹中没有合适的文件");
    }

    // 最后合并的文件，文件名字是sourceFolder中文件名字移除掉尾部. 前面的名称
    File combineFile = new File(targetFolder, fileName);

    try (BufferedOutputStream outputStream = new BufferedOutputStream(
        new FileOutputStream(combineFile))) {

      // 待合并的每个文件的后缀数字，每次读取一个文件后，该数字要+1
      int fileNameIndex = 1;
      // 循环直到待合并的文件总数归零
      while (fileCount > 0) {
        // 创建一个待合并文件对象
        File oneFile = new File(sourceFolder, fileName + "." + fileNameIndex);

        combineOneFile(outputStream, oneFile);
        // 处理了一个文件，则将待合并的文件数量减少
        fileCount--;
        // 文件后缀的数字要增加
        fileNameIndex++;
      }

    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("合并文件失败" + e.getMessage());
    }

  }

  /**
   * 开启待合并的文件的输入流，读取其中的全部内容，写入到给定的输出流中
   * 相当于将oneFile 内容合并到了 outputStream所代表的的文件中
   *
   * @param outputStream
   * @param oneFile
   * @throws IOException
   */
  private void combineOneFile(BufferedOutputStream outputStream, File oneFile)
      throws IOException {
    byte[] buf = new byte[1024];
    try (BufferedInputStream inputStream = new BufferedInputStream(
        new FileInputStream(oneFile));) {
      int read = inputStream.read(buf);
      while (read > 0) {
        outputStream.write(buf, 0, read);
        read = inputStream.read(buf);
      }
      outputStream.flush();
    }
  }


  public static void main(String[] args) {

    // String s = "WIN.mp3.3";
    // System.out.println(s.substring(0, s.lastIndexOf(".")));
    File sourceFile = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/doc/WIN.mp3");
    File targetFolder = new File(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/03.SplitFile/combine");
    // new SplitFileDemo().split(sourceFile, 2000, targetFolder);
    //
    File combineTarget = new File(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/practice/03.SplitFile/target");
    new SplitFileDemo().combine(targetFolder, combineTarget);
  }
}
