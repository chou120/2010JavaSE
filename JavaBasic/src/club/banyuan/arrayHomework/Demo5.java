package club.banyuan.arrayHomework;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/12 10:02 上午
 */
public class Demo5 {

  /**
   * 有1.5元钱兑换1分，2分，5分硬币100枚，每种面值至少一个，请输出所有的兑换方案，并统计方案的总数
   */
  public static void main(String[] args) {

    System.out.println(money());

  }

  public  static  int  money(){
    int count=0;
    for (int i = 1; i <=150; i++) {  // 1 150  75   30
      for (int j = 1; j <=150/2; j++) {  //2
        for (int k = 1; k <=150/5; k++) { //5
          if(i+j+k==100 && i+2*j+5*k==150){
            count++;
          }
        }
      }
    }
    return   count;
  }
}
