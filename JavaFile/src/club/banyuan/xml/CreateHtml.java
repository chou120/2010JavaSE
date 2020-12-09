package club.banyuan.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.HTMLWriter;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 10:34 上午
 */
public class CreateHtml {

  public static void main(String[] args) {
    File file = new File("beautyGirl.html");
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    Document document = DocumentHelper.createDocument();
    Element html = document.addElement("html").addAttribute("lang", "en");
    Element head = html.addElement("head");
    head.addElement("meta").addAttribute("charset", "UTF-8");
    head.addElement("title").setText("你好,妹子!!!");
    Element body = html.addElement("body");

    String background = "background-image: url('img/3674d4af97ed9dd7c21fc603b8d4f1b2.jpg');border: 1px sold red;width:400px;height: 300px;opacity: 0.2";
    Element table = body.addElement("table").addAttribute("style", background);
    Element th = table.addElement("th");
    th.addElement("td").setText("姓名");
    th.addElement("td").setText("年龄");
    th.addElement("td").setText("地址");
    th.addElement("td").setText("联系方式");

    Element tr = table.addElement("tr");
    tr.addElement("td").setText("张三");
    tr.addElement("td").setText("22");
    tr.addElement("td").setText("栖霞区");
    tr.addElement("td").setText("12345678901");
    HTMLWriter htmlWriter=null;
    try {
      htmlWriter=new HTMLWriter(new FileOutputStream(file));
      htmlWriter.write(html);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(htmlWriter!=null){
          htmlWriter.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    /**
     * 将集合中的对象写入HTML文件中,以表格的方式显示出来
     */

  }
}
