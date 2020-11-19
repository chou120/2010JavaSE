package club.banyuan.constructor09;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/19 10:17 上午
 */
public class PersonService {

  private  Person [] peoples=new Person[20];

//  {   构造代码块
//    for (int i = 0; i < peoples.length; i++) {
//       /*Person person = new Person();
//       person.setAge(i);
//       person.setAddress("嫌弃"+i);
//       person.setName("不显示"+);*/
//      peoples[i]=new Person("嫌弃"+i, i, "嫌弃不"+i);
//    }
//  }

  private  String  name;
  {  //构造代码块在构造函数之前执行  不管调用哪个构造函数 构造代码块都会执行
    System.out.println("构造代码....");
  }
  public    PersonService(){  //构造方法代码

    System.out.println("创建对象,并且对数组初始化....构造方法代码");
    for (int i = 0; i < peoples.length; i++) {
      peoples[i]=new Person("嫌弃"+i, i, "嫌弃不"+i);
    }
  }

  public    PersonService(String  name){  //构造方法代码

    System.out.println("有参构造函数...");
  }
}

class  TestPersonService{

  public static void main(String[] args) {
    new  PersonService();
    new  PersonService("哈哈哈");

  }
}