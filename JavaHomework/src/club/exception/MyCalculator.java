package club.exception;

import java.util.Scanner;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/1 9:38 上午
 */
public class MyCalculator {

  public static int parseAndCompute(String input)
      throws IllegalInputException, DivideByZeroException, QuitException { //得到的是输入的字符串  数字1 + 数字2
    String[] str = input.split(" ");
    //1s + 89   "1s" "12"   //正常的是情况下 str长度是三个   0   1(quit)   2(- 3)  3   - 3  ---> 3 3
    System.out.println(">>>>>>"+str.length);
    switch (str.length) {
      case 0:
        throw new IllegalInputException("非法参数0.....");
      case 1:
        if (str[0].equals("quit")) {
          throw new QuitException("Quitting");
        }
        throw new IllegalInputException("非法参数1");
      case 2:
        throw new IllegalInputException("非法计算格式", "非法操作");
      case 3:
        int first = 0;
        int second = 0;
        try {
          first = Integer.parseInt(str[0]);
          second = Integer.parseInt(str[2]); //输入的字符串里面有非数字怎么办 "o"
        } catch (NumberFormatException e) {
          throw new IllegalInputException("非法字符", "数字转换异常");
        }
        switch (str[1]) {
          case "+":
            return first + second;
          case "-":
            return first - second;
          case "*":
            return first * second;
          case "/":
            try {
              return first / second; //second==0
            } catch (ArithmeticException e) {
              throw new DivideByZeroException("商为0");
            }
          default:
            throw new IllegalInputException("非法参数", "非法输入");
        }
      case 4:
        throw new IllegalInputException("非法长度", "非法输入");
    }
    return 0;
  }
}

class  Test{

  public static void main(String[] args) {

    Scanner  scanner=new Scanner(System.in);
    while(true){
      String   str=scanner.nextLine();  //next 空格后面不读取   nextLine  整个一行都读取  直到遇到回车键 \n
      try {
        int  result=  MyCalculator.parseAndCompute(str);
        System.out.println("结果为:"+result);
      } catch (IllegalInputException e) {
        e.printStackTrace();
      } catch (DivideByZeroException e) {
        e.printStackTrace();
      } catch (QuitException e) {
        e.printStackTrace();
      }
      if(str.equals("quit")){
        break;
      }

    }

  }
}
