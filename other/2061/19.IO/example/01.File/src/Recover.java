import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Recover {


  public static void main(String[] args) throws IOException {
    File bakDir = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/bak");
    File[] files = bakDir.listFiles();
    if (files == null || files.length == 0) {
      return;
    }

    // 排序，根据日期的大小进行排序，降序排序
    Arrays.sort(files, (o1, o2) -> {
      String name = o1.getName();
      String name2 = o2.getName();
      return (int) (Long.parseLong(name2) - Long.parseLong(name));
      // return name.compareTo(name2);
      // // 将字符串反转为Date的对象
      // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
      //
      // try {
      //   Date d1 = simpleDateFormat.parse(name);
      //   Date d2 = simpleDateFormat.parse(name2);
      //   return d2.compareTo(d1);
      // } catch (ParseException e) {
      //   e.printStackTrace();
      // }
      // return 0;
    });

    File recover = files[0];

    File saveDir = new File("/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/save");

    for (File file : recover.listFiles()) {
      File origin = new File(saveDir, file.getName());
      if (origin.exists()) {
        origin.delete();
      }
      Files.copy(file.toPath(), origin.toPath());
    }


  }
}
