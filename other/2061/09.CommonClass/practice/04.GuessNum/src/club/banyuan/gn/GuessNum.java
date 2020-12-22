package club.banyuan.gn;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNum {

  private int[] num = new int[4];

  // 比较两个数字，记录位置正确和数字正确的数值
  public CompareResult compare(GuessNum guessNum) {
    int posCorrect = 0;
    int numCorrect = 0;

    // 逐位比较，如果相同，则posCorrect+1，
    // 如果不同，需要判断是否包含，如果包含，则numCorrect+1

    for (int i = 0; i < 4; i++) {
      if (num[i] == guessNum.num[i]) {
        numCorrect++;
        posCorrect++;
      } else {
        for (int j = 0; j < 4; j++) {
          if (guessNum.num[i] == num[j]) {
            numCorrect++;
            break;
          }
        }
      }
    }
    return new CompareResult(posCorrect, numCorrect);
  }

  // 比较两个数字，记录位置正确和数字正确的数值
  public CompareResult compareRefine(GuessNum guessNum) {
    int posCorrect = 0;
    int numCorrect = 0;

    // 逐位比较，如果相同，则posCorrect+1，
    // 如果不同，需要判断是否包含，如果包含，则numCorrect+1

    for (int i = 0; i < 4; i++) {
      if (num[i] == guessNum.num[i]) {
        numCorrect++;
        posCorrect++;
      } else if (contains(num, 4, guessNum.num[i])) {
        numCorrect++;
      }
    }
    return new CompareResult(posCorrect, numCorrect);
  }

  private boolean contains(int[] target, int len, int source) {
    for (int j = 0; j < len; j++) {
      if (target[j] == source) {
        return true;
      }
    }
    return false;
  }

  /**
   * 随机填充数组，生成一个每位不重复的4位的随机数
   */
  public void fillByRandom() {
    int[] template = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Random random = new Random();
    int length = template.length;
    for (int i = 0; i < 4; i++) {
      // 下一次随机不会随机到数组最末一位的下标
      int index = random.nextInt(length);
      num[i] = template[index];
      // 数组后面的数据，移动到index的位置上，然后后面的位置不再算作长度的一部分
      template[index] = template[length - 1];
      length--;
    }
  }


  // 从键盘接收一串字符，校验这串字符必须全部是数字，长度必须是4
  // 如果输入不合法则重新输入，输入合法，将数组填充
  // 不允许输入重复的数字
  public void fillByInput() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String s = sc.nextLine();
      // 校验长度合法性
      if (s.length() != 4) {
        System.out.println("输入不合法，请重新输入");
        continue;
      }
      char[] c = s.toCharArray();
      int i;
      // 每一位必须是数字字符，如果不是，则重复循环
      for (i = 0; i < 4; i++) {
        if (c[i] >= '0' && c[i] <= '9' && !contains(num, i, c[i] - '0')) {
          num[i] = c[i] - '0';
        } else {
          break;
        }
      }
      // 如果连续4次校验通过，则输出正确，退出循环
      if (i == 4) {
        break;
      } else {
        System.out.println("输入不合法，请重新输入");
      }
    }
  }

  public void fillByInputRefine() {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    if (s.length() != 4) {
      fillByInputRefine();
      return;
    }
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (c[i] >= '0' && c[i] <= '9') {
        num[i] = c[i] - '0';
      } else {
        fillByInputRefine();
        return;
      }
    }
  }

  public static GuessNum genGuessNumByInput() {
    GuessNum guessNum = new GuessNum();
    guessNum.fillByInput();
    return guessNum;
  }

  public static GuessNum genGuessNumByRandom() {
    GuessNum guessNum = new GuessNum();
    guessNum.fillByRandom();
    return guessNum;
  }
}
