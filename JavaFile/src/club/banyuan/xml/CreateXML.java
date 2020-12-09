package club.banyuan.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 10:14 上午
 */
public class CreateXML {

  public static void main(String[] args) {
    //创建一个xml文件并且将数据写入
    File file = new File("bySelf.xml");
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //准备要写入的内容  其实就是各个根节点和子节点以及文本
    /**
     * <work  id="1">
     *    <name>内容</name>
     *    <job>工种</job>
     *    <age>年龄</age>
     *    <salary>工资</salary>
     * </work>
     * 创建3个
     */
    // 创建一个Document实例
    Document doc = DocumentHelper.createDocument();  //创建一个文档对象
    Element root = doc.addElement("root");

    Element work = root.addElement("work");
    Element newWork = work.addAttribute("id", "1");
    newWork.addElement("name").setText("张三");
    newWork.addElement("age").setText("32");
    newWork.addElement("job").setText("电焊工");
    newWork.addElement("salary").setText("5678");


    //以什么样的格式写入xml
    OutputFormat compactFormat = OutputFormat.createCompactFormat();
    XMLWriter xmlWriter = null;
    try {
      xmlWriter = new XMLWriter(new FileOutputStream(file), compactFormat);
      xmlWriter.write(doc);  //将   document  写入

      //将集合中对象(User[属性:编号,姓名,年龄,身高,住址]) 4个或者五个对象  写入指定的xml文件中


    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        xmlWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }
}
