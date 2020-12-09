package club.banyuan.xml;


import java.io.File;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/9 9:25 上午
 */
public class XMLDemo2 {

  /*
     读取出xml文件中 有效数据
     操作xml文件的解析器
          1、DOM解析；2、SAX解析；3、JDOM解析；4、DOM4J解析。其中前两种属于基础方法，是官方提供的平台无关的解析方式；后两种属于扩展方法，它们是在基础的方法上扩展出来的，只适用于java平台。

   */

  public static void main(String[] args) {
    //对 info.xml  路径有嘛？
//    第一步：创建一个SAXReader解析器
//
//    `SAXReader reader = new SAXReader();`
//
//    第二步：解析xml文件，重新构建成一个Document对象
//
//    `Document doc = reader.read(file);`
//
//    第三步：处理Document对象信息，在控制台打印

    File file = new File("JavaFile/info.xml");
    SAXReader reader = new SAXReader();
    Document document = null;
    try {
      document = reader.read(file);

      Element rootElement = document.getRootElement(); //获取到根节点   root
      //    System.out.println(rootElement.getName());
      /*List<Element> elements = rootElement.elements();
      for (Element element : elements) {
         List<Element> elements1 = element.elements();
        for (Element element1 : elements1) {
          System.out.println(element1.getName()+"文本内容为:"+element1.getText());
        }
      }*/
      // Element student = rootElement.element("student");
      System.out.println();
//      String s = rootElement.element("student").attributeValue("id");
//      List<Element> elements = rootElement.elements();
//      for (Element element : elements) {
//         String id = element.attributeValue("id");
//         if(id.equals("2")){
//           System.out.println(id);
//         }
//      }
      System.out.println();

       List student = rootElement.elements("student");
      for (Object o : student) {
        Element element=(Element)o;
         Attribute id = element.attribute("id");
        System.out.println(id.getName()+"---"+id.getValue());
      }
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
}
