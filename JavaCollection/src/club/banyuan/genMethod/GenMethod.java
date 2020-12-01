package club.banyuan.genMethod;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 2:19 下午
 */
public class GenMethod {

//  public  void   show(String string){
//    System.out.println(string);
//  }
//  public  void   show(User user){
//    System.out.println(user);
//  }
//  public  void   show(Integer[] string){
//    System.out.println(string);
//  }

//    public  void   show(Object  object){
//      System.out.println(object);
//    }


  public <T> void show(T t) {
    System.out.println(t);
  }

  public   <T extends Number,K extends Number>   Number  max(T t,K k){
    
      if(t instanceof  Integer && k instanceof Integer){
           if(t.intValue()>k.intValue()){
             return t;
           }else{
             return k;
           }
      }
        return  0;
  }

  public <T> void print(T t) {
    System.out.println(t);
  }

}

class  Test{

  public static void main(String[] args) {
     GenMethod genMethod = new GenMethod();
     genMethod.print("sadas");
     genMethod.show(123.4);

    System.out.println(  genMethod.max(34, 67));


  }
}
