package club.banyuan.gn;

public class MainRefine {

  public static void main(String[] args) {
    GuessNum guessNum = GuessNum.genGuessNumByRandom();
    while (true) {
      System.out.println("请输入数字：");
      GuessNum inputNum = GuessNum.genGuessNumByInput();
      CompareResult compare = guessNum.compare(inputNum);
      if (compare.isCorrect()) {
        System.out.println("回答正确！");
        break;
      } else {
        compare.printInfo();
      }
    }
  }
}
