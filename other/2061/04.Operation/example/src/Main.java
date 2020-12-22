public class Main {

  public static void main(String[] args) {
    int a = 1;
    // 表达式的值为1
    // 给a的值+1
    // 用1给a赋值
    a = a++;

    // int temp = a;
    // a = a + 1;
    // a = temp;

    // 1
    System.out.println(a);

    double double1 = 1.1, double2 = 1.2;
    // double1 - double2 < 0.0000001 && double1 -double2 > -0.0000001
    // int aInt = 5;
    // if (2 <= aInt && aInt <= 10) {
    //   // if (2 <= aInt <= 10) {
    //
    // }

    // int[] aIntArr = new int[2];
    // if (aIntArr = null) {
    //
    // }

    // 0.000123
    // 1.1234
    // 1.12345600
    // long aInt = 123456789L;
    // float aFloat = aInt;
    // System.out.println(aFloat);

    // short shortTwo = 10;
    // short shortThree = 100;
    // // shortTwo = (short)(shortThree + shortTwo);
    // shortTwo += shortThree;
    //
    // long aLong = 0xFFFFFFFFL;
    // int aInt = (int) aLong;
    // System.out.println(aLong);
    // System.out.println(aInt);
    //
    // float aFloat = 1.1F;
    // int otherInt = (int) aFloat;
    // System.out.println(otherInt);
    //
    // System.out.println(5 / 2);

    System.out.println("字符串：" + 15); // 字符串：15
    System.out.println("字符串：" + 'a'); // 字符串：a
    System.out.println("字符串：" + true); // 字符串：true
    System.out.println("字符串：" + 3.14); // 字符串：3.14

    System.out.println("字符串：" + 1 + 2); // 字符串：12
    System.out.println(1 + 2 + "字符串"); // 字符串：12

  }

  boolean test(int a) {

    // return a % 2 == 0 ? true : false;
    return a % 2 == 0;

    // return a % 2 == 0;

    // if (a % 2 == 0) {
    //   return true;
    // } else {
    //   return false;
    // }
  }
}
