package club.banyuan.serial.ext;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonSerialDemo {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<Father> fathers = new ArrayList<>();

    OneSon oneSon = new OneSon();
    oneSon.setOneSonField("one");
    oneSon.setName("one son");

    TwoSon twoSon = new TwoSon();
    twoSon.setTwoSonField("two");
    twoSon.setName("two son");

    fathers.add(oneSon);
    fathers.add(twoSon);

    System.out.println(fathers);

    // outputStream => writer
    // outputStream => 字节流到字符流的转换(OutputStreamWriter) => writer

    // inputStream => reader
    // InputStreamReader
    BufferedWriter writer = new BufferedWriter(
        // 字节流转字符流
        new OutputStreamWriter(
            new FileOutputStream(
                "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/Fathers.json")));

    // 需要序列化父类的子类，可以在序列化的文件中，增加子类的数据类型的标识，这样反序列化的时候，可以根据确定的类，序列化为子类的对象
    writer.write(JSONObject.toJSONString(fathers, SerializerFeature.WriteClassName));
    writer.close();

    BufferedReader reader = new BufferedReader(
        new InputStreamReader(
            new FileInputStream(
                "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/Fathers.json")));

    StringBuilder builder = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
      builder.append(line);
      line = reader.readLine();
    }

    List<Father> read = JSONObject.parseArray(builder.toString(), Father.class);

    System.out.println(read);


  }
}
