import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class FileDemo {

  public static void main(String[] args) throws IOException {
    File save = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/save");
    // File 对象可以代表文件夹，也可以代表对象
    System.out.println("isDirectory:" + save.isDirectory());
    System.out.println("isFile:" + save.isFile());

    File[] files = save.listFiles();
    for (File one : files) {
      System.out.println(one.getName());
      System.out.println(one.length());
      System.out.println(one.getAbsolutePath());
      Date date = new Date(one.lastModified());

      System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    // java中的相对路径，相对于java启动时的 命令行的工作路径
    File f1 = new File("../");
    System.out.println(f1.getAbsolutePath());
    System.out.println(f1.getCanonicalPath());

    File newFile = new File(save.getParent(), "bak");

    System.out.println(newFile.getAbsolutePath());
    // 文件是否存在
    System.out.println(save.exists());
    System.out.println(newFile.exists());

    if (newFile.exists()) {
      boolean delete = newFile.delete();
      System.out.println("delete:" + delete);
    }

    boolean mkdir = newFile.mkdir();
    System.out.println(mkdir);

  }
}
