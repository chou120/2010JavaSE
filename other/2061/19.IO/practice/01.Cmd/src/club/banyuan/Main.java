package club.banyuan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

  // cp 路径1 路径2
  // rm 路径

  public static void main(String[] args) {
    if (args.length <= 0 || args.length > 3) {
      System.out.println("输入不合法：" + Arrays.toString(args));
      return;
    }

    String cmd = args[0];
    try {
      switch (cmd) {
        case "ls":
          ls(args);
          break;
        case "cp":
          cp(args);
          break;
        case "rm":
          rm(args);
          break;
        default:
          System.out.println("输入不合法：" + Arrays.toString(args));
          break;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage() + ":" + Arrays.toString(args));
    }
  }

  private static void rm(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("参数不合法");
    }

    rm(args[1]);
  }

  private static void rm(String path) {
    File target = new File(path);
    // 如果是文件，则直接删除文件
    if (target.isFile()) {
      target.delete();
    } else if (target.isDirectory()) {
      // 如果是文件夹，需要先删除文件夹里面的内容，再删除文件夹本身
      rmDir(target);
    }
  }

  private static void rmDir(File target) {
    if (target == null) {
      return;
    }
    File[] files = target.listFiles();
    if (files == null || files.length == 0) {
      return;
    }

    for (File one : files) {
      // 文件夹下面有可能再嵌套文件夹，因此如果嵌套了文件夹
      // 继续调用删除这个文件夹的方法
      if (one.isDirectory()) {
        rmDir(one);
      }
      // 如果是文件一定要调用，如果是文件夹，上面的代码删除了文件夹里面的内容，这里要把文件夹本身删除掉
      one.delete();
    }
    // 上述代码删除了target里面的所有文件和文件夹，这里需要把target本身删除掉
    target.delete();
  }

  private static void cp(String[] args) throws IOException {
    if (args.length != 3) {
      throw new IllegalArgumentException("参数不合法");
    }

    String from = args[1];
    String to = args[2];
    cp(from, to);
  }

  private static void cp(String from, String to) {
    File sourceFile = new File(from);
    if (!sourceFile.isFile()) {
      throw new IllegalArgumentException("源文件不合法");
    }

    File targetFile = new File(to);

    try {
      Files.copy(sourceFile.toPath(), targetFile.toPath());
    } catch (IOException e) {
      throw new IllegalArgumentException("复制文件异常，请检查路径");
    }
  }


  // ls
  // ls 路径
  // ls -l
  // ls 路径 -l
  private static void ls(String[] args) {
    switch (args.length) {
      case 1:
        ls("./");
        break;
      case 2:
        if ("-l".equals(args[1])) {
          lsl("./");
        } else {
          ls(args[1]);
        }
        break;
      case 3:
        validateLsParam(args[2]);
        lsl(args[1]);
        break;
      default:
        // 最外层处理的长度不合法的情况，这里不需要再次进行处理
        break;
    }
  }

  private static void validateLsParam(String arg) {
    if (!"-l".equals(arg)) {
      throw new IllegalArgumentException("参数不合法");
    }
  }

  private static void lsl(String path) {
    File dir = validateDir(path);
    File[] files = dir.listFiles();

    Arrays.sort(files, new Comparator<File>() {
      @Override
      public int compare(File o1, File o2) {
        // 文件夹排到文件上面
        if (o1.isDirectory() && o2.isFile()) {
          return -1;
        } else if (o1.isFile() && o2.isDirectory()) {
          return 1;
        }

        // 如果是文件夹的话，根据名字排序
        if (o1.isDirectory()) {
          return o1.getName().compareTo(o2.getName());
        } else {
          // 如果是文件的话，根据大小排序
          return (int) (o1.length() - o2.length());
        }

      }
    });
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    for (File one : files) {
      String date = dateFormat.format(one.lastModified());
      String folder = one.isDirectory() ? "d" : "-";
      String length = one.isDirectory() ? "0" : (one.length() + "");
      // 文件还是文件夹    大小    日期     名字
      System.out.printf("%-3s%10s\t%20s\t%-10s", folder, length, date, one.getName());
      System.out.println();
    }
  }

  private static File validateDir(String path) {
    File dir = new File(path);
    if (!dir.isDirectory()) {
      throw new IllegalArgumentException("路径不合法");
    }
    return dir;
  }

  private static void ls(String path) {
    File dir = validateDir(path);

    for (File file : dir.listFiles()) {
      System.out.print(file.getName() + " ");
    }

  }
}
