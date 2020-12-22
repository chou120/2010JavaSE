import java.io.File;
import java.io.IOException;

public class FileEmptyPath {

  // /abc/123/def/1.txt
  public static void main(String[] args) throws IOException {

    File txt = new File("/Users/liyi/123/def/1.txt");
    System.out.println(txt.getParentFile());
    // System.out.println(txt.getParentFile().mkdirs());

    // abstract pathname =  File object/ instance
    // pathname = String
    // abstract pathname / pathname  => 硬盘上的文件或文件夹
    // "" => abstract pathname => workingdir/空文件
    File file = new File("");
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getCanonicalPath());
    System.out.println(file.isDirectory());
    System.out.println(file.isFile());
    System.out.println(file.length());
    System.out.println(file.getName());
    System.out.println(file.exists());

    // 空文件的父级都是null, getParent 使用传入的pathName 截取文件分隔符，剩余的部分作为父级路径
    // 因此传入的路径如果为相对路径，可能截取不到父级路径。
    System.out.println(file.getParent());
    System.out.println(file.getParentFile());
    // System.out.println(file.getParentFile().isDirectory());
    // System.out.println(file.getParentFile().getAbsolutePath());

    File f2 = new File("../abcd");
    System.out.println(f2.getAbsolutePath());
    System.out.println(f2.getCanonicalPath());
    System.out.println(f2.isDirectory());
    System.out.println(f2.isFile());

    System.out.println(f2.getParentFile().getParentFile());
    System.out.println(f2.getParent());
    System.out.println(f2.exists());

  }
}
