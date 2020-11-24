package club.banyuan.cake;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/24 9:29 上午
 */
public class CakeTool {

  private static Cake[] cakes = new Cake[10];
  private  static  int key=0;

  private CakeTool() {
  }

  //   0   0   0   0   0   0  0  0  0   0
  //   0   1   2   3   4   5  6  7  8   9
  public static void add(Cake cake) { //  OrderCake
    for (int i = 0; i <cakes.length; i++) {
      if(cakes[i]==null && i%2==0 && cake instanceof ReadyMadeCake){ //  instanceof 判断的是什么数据类型的对象
          cakes[i]=cake;
          break;
      }
      if(cakes[i]==null && i%2!=0 && cake instanceof OrderCake){
        cakes[i]=cake;
        break;
      }
    }
  }

  public  static  void  sum(){
    //求满足  ReadyMadeCake蛋糕的总价和所有的数量

    double   sum=0;
    double   total=0;
    for (int i = 0; i <cakes.length; i++) {
      if(cakes[i]!=null &&  i%2==0 ){
          sum+=cakes[i].calcPrice();
        System.out.println("--------"+((ReadyMadeCake)cakes[i]).getQuantity());
          total+=((ReadyMadeCake)cakes[i]).getQuantity();
      }
    }

    System.out.println("所有的ReadyMadeCake蛋糕的总价格为:"+sum+",总质量为:"+total);
  }


  //找到最高售价的蛋糕,并且判断是按斤卖还是按数量卖的
  public   static   void  findMaxPrice(){
    double max=0;
    int  index=-1;
    Cake  cake=null;
    for (int i = 0; i <cakes.length; i++) {
      if(cakes[i]!=null &&  max<cakes[i].calcPrice()){
        max=cakes[i].calcPrice();  //找到最大蛋糕的价格,并且得到下标
        index=i;
      }
    }
    cake=cakes[index];
    if(cake instanceof  ReadyMadeCake){
      System.out.println("按数量卖的");
    }else {
      System.out.println("按斤卖..");
    }


  }




  public  static  void   print(){
    for (int i = 0; i <cakes.length; i++) {
      if(cakes[i]!=null){
        System.out.println("下标为:"+i+",对应的蛋糕为:"+cakes[i]);
      }
    }
  }


}


class  Test{

  public static void main(String[] args) {
     OrderCake orderCake1 = new OrderCake(01, 8, 6);
     OrderCake orderCake2 = new OrderCake(02, 9, 5);
     OrderCake orderCake3 = new OrderCake(03, 10, 4);

     ReadyMadeCake readyMadeCake1 = new ReadyMadeCake(04, 7, 10);
     ReadyMadeCake readyMadeCake2 = new ReadyMadeCake(05, 8, 9);
     ReadyMadeCake readyMadeCake3 = new ReadyMadeCake(06, 9, 15);

      CakeTool.add(orderCake1);
      CakeTool.add(orderCake2);
      CakeTool.add(orderCake3);
      CakeTool.add(readyMadeCake1);
      CakeTool.add(readyMadeCake2);
      CakeTool.add(readyMadeCake3);


      CakeTool.print();

      CakeTool.sum();

      CakeTool.findMaxPrice();

  }
}
