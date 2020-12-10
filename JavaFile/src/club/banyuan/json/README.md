一.系列化：

什么是序列化？

把java对象转化为二进制字节码在网络上传输。

缺点：发送端是java语言。接收端也必须是java语言，必须依赖java开发环境。

优点：数据转化为二进制字节，传输快，不浪费资源。

二.xml:

什么是xml？

XML 是各种应用程序之间进行数据传输的工具.

缺点：冗余标签太多，传输时浪费资源。

优点：发送端时java ,接收端可以时任何js,python,ruby。。。不受环境限制。

三.json

什么是json?

传输数据的一种格式

优点：比起xml，数据更精简，还能和js配对使用。基本上统治了浏览器。

格式
json字符串  String  str="\"key1\":存放的数据值1,\"key1\":\"存放的数据值2\"";  
如果写的key-value满足某个对象存放数据的需求
具体某个对象     对象=JSONObject.parseObject(str,某个类文件);

{"key1":存放的数据值1,"key1":存放的数据值2,....}

String   jsonString=JSONObject.toJSONString(对象);[集合对象,数组对象,其他对象]



集合
     
      FileReader  filereader=new  FileReader();
      char[] chars=new char[1024];
      
      string=filereader.read(chars); //一次性读取可能会有多余的空格  最好是一个个的读取
        
     List<类>  list=JSONObject.parseArray(string,类文件);    [{},{},{}]                          

        















