package club.banyuan.gn;

public class Main {

  public static void main(String[] args) {

    GuessNum guessNum = new GuessNum();
    guessNum.fillByRandom();
    GuessNum inputNum = new GuessNum();
    while (true) {
      System.out.println("请输入数字：");
      inputNum.fillByInput();
      CompareResult compare = guessNum.compare(inputNum);
      if (compare.isCorrect()) {
        System.out.println("回答正确！");
        break;
      } else {
        compare.printInfo();
      }
    }

    // // 随机生成的正确的数字
    // int correctNum;
    //
    // // 用户输入的数字
    // int userInput;
    //
    // // 位置正确的个数
    // int posCorrect;
    //
    // // 数字正确
    // int numCorrect;

  }

  // // 接收用户输入的数字
  // public static int getInput() {
  //   return 0;
  // }
  //
  // // 比较数据
  // public static void compare(int correct, int input) {
  //
  // }
  //
  // // 生成随机数，正确的答案
  // public static int getCorrectNum() {
  //   return 0;
  // }
}
