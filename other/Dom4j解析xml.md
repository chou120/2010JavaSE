```java
<dependency>
    <groupId>dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>1.6.1</version>
</dependency>
```

 优点：dom4j使Java生成和解析XML灵活性变高，并且代码易于维护

 

API操作类：

Document：表示xml文档信息，是一个树形结构

Eelment：表示xml的元素节点，提供一些操作其子元素方法的，如文本、属性、名称空间等

Attribute：表示元素节点中的属性

 

二）dom4j生成xml
实现步骤：

第一步：创建一个Document实例

`Document doc = DocumentHelper.createDocument();`

 

第二步：先添加一个根结点，然后再添加子结点，构造成一个树形结构

`Element root = doc.addElement("root");`

 

第三步：添加xml文件样式（也可自定义样式），并输出xml文件到指定的路径下

`OutputFormat format = OutputFormat.createPrettyPrint();`

`XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);`
`writer.write(doc);`



public class CreateDom4j {

    public static void main(String[] args) {
        // 执行dom4j生成xml方法
        createDom4j(new File("E:\\dom4j.xml"));
    }
    
    public static void createDom4j(File file) {
        try {
            // 创建一个Document实例
            Document doc = DocumentHelper.createDocument();
    		
            // 添加根节点
            Element root = doc.addElement("root");
    		
            // 在根节点下添加第一个子节点
            Element oneChildElement= root.addElement("person").addAttribute("attr", "root noe");
            oneChildElement.addElement("people")
                    .addAttribute("attr", "child one")
                    .addText("person one child one");
            oneChildElement.addElement("people")
                    .addAttribute("attr", "child two")
                    .addText("person one child two");
    		
            // 在根节点下添加第一个子节点
            Element twoChildElement= root.addElement("person").addAttribute("attr", "root two");
            twoChildElement.addElement("people")
                    .addAttribute("attr", "child one")
                    .addText("person two child one");
            twoChildElement.addElement("people")
                    .addAttribute("attr", "child two")
                    .addText("person two child two");
    		
            // xml格式化样式
            // OutputFormat format = OutputFormat.createPrettyPrint(); // 默认样式
    		
            // 自定义xml样式
            OutputFormat format = new OutputFormat();
            format.setIndentSize(2);  // 行缩进
            format.setNewlines(true); // 一个结点为一行
            format.setTrimText(true); // 去重空格
            format.setPadText(true);
            format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
    		
            // 输出xml文件
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(doc);
            System.out.println("dom4j CreateDom4j success!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
`dom4j解析xml`
实现步骤：

第一步：创建一个SAXReader解析器

`SAXReader reader = new SAXReader();`

 第二步：解析xml文件，重新构建成一个Document对象

`Document doc = reader.read(file);`

第三步：处理Document对象信息，在控制台打印


    public class ParseDom4j {
    public static void main(String[] args) {
        // 执行dom4j解析xml方法
        parseDom4j(new File("E:\\dom4j.xml"));
    }
    
    public static void parseDom4j(File file) {
        try {
            // 创建一个SAXReader解析器
            SAXReader reader = new SAXReader();
    		
            // 读取xml文件,转换成Document结点
            Document doc = reader.read(file);
     
            // 递归打印xml文档信息
            StringBuffer buffer = new StringBuffer();
            parseElement(doc.getRootElement(), buffer);
            System.out.println(buffer.toString());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void parseElement(Element element, StringBuffer buffer) {
        buffer.append("<"+element.getName());
        List<Attribute> attrs = element.attributes();
        if (attrs != null) {
            for (Attribute attr : attrs) {
                buffer.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
            }
        }
        buffer.append(">");
        
        Iterator<Node> iterator = element.nodeIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof Element) {
                Element eleNode = (Element) node;
                parseElement(eleNode, buffer);
            }
            if (node instanceof Text) {
                Text text = (Text) node;
                buffer.append(text.getText());
            }
            if (node instanceof CDATA) {
                CDATA dataNode = (CDATA) node;
                buffer.append(dataNode.getText());
            }
            if (node instanceof Comment) {
                Comment comNode = (Comment) node;
                buffer.append(comNode.getText());
            }
        }
        buffer.append("</"+element.getName()+">");
    }
    }

