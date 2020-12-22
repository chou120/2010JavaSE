import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Backup {

  private static final String TARGET = "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/save";

  public static void main(String[] args) throws IOException {
    // 构造方法
    // File(文件路径)
    // File(父级文件路径，子文件名)
    // File(父级File对象一定是文件夹，子文件名)
    File target = new File(TARGET);

    // 返回当前文件的父级文件对象
    File parentFile = target.getParentFile();

    // 返回当前File对象的绝对路径，但是其中会包含.././ 之类的相对路径
    // 如果需要去除这些路径，则使用 getCanonicalPath
    System.out.println(parentFile.getAbsolutePath());
    System.out.println(parentFile.getCanonicalPath());

    File bakDir = new File(parentFile, "bak");
    System.out.println("==================");
    System.out.println(bakDir.isFile());
    System.out.println(bakDir.isDirectory());

    // bakDir.createNewFile() bak 就是文件
    // bakDir.mkdir() 就是文件夹

    // 判断该file对象是否有一个硬盘上对应的文件或文件夹
    if (bakDir.exists()) {
      // 删除文件或文件夹
      // 删除的时候，如果当前的对象表示的是文件夹，需要保证文件夹下面没有文件，才允许被删除
      bakDir.delete();
    }

    // 创建文件夹
    // mkdirs 级联创建文件夹
    bakDir.mkdir();

    String format = getDateString();
    File newFile = new File(bakDir, format);

    // newFile.mkdir();
    System.out.println(newFile.getAbsolutePath());
    System.out.println(newFile.mkdir());

    System.out.println(format);

    // target  /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/save
    // newFile  /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/bak/20200817154619

    // source /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/save/save.1
    // target /Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/bak/20200817154619/save.1

    // 显示当前文件夹下的所有文件或文件夹，每个都以file对象表示
    File[] files = target.listFiles();
    for (File file : files) {
      File bakFile = new File(newFile, file.getName());
      // 将file 复制到 bakFile上
      Files.copy(file.toPath(), bakFile.toPath());
    }


  }

  /**
   * @return
   */
  private static String getDateString() {
    // 年月日时分秒
    // 以当前的时间创建一个Date对象 ，用来标识当前的日期和时间
    Date date = new Date();
    // 用来将date对象转换为 字符串用来作为文件夹的名称
    // SimpleDateFormat相当于模子，在这里指定字符串格式
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    // 传入date对象，返回对应的字符串
    String format = simpleDateFormat.format(date);
    return format;
  }
}
