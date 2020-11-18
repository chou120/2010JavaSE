package club.banyuan.oopHomework08;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/18 9:09 上午
 */
public class Demo {


  public static void main(String[] args) {
    Fridge fridge = new Fridge();

    Elephant elephant = new Elephant();
    //fridge.setElephant(elephant);

   // Elephant remove = fridge.remove();  //返回移除的大象对象
   // System.out.println(remove); //
    //System.out.println(fridge.getElephant()); //输出冰箱里面的大象对象
    //fridge.store(new Elephant());
    fridge.store(new Lion());  //因为已经塞过东西了
    System.out.println(fridge.getLion());
     Lion lion = createLion(80);
     fridge.store(lion);

  }

  static Lion createLion(int heightInCM){
     Lion lion = new Lion();
     //把传递过来的数据塞给狮子
    lion.setHeightInCM(heightInCM);
    //返回一个狮子对象
    return lion;
  }


}
