package club.banyuan;

public class Main {

  public static void main(String[] args) {
    Gender gender = Gender.valueOfType("男");
    System.out.println(gender);

    Gender gender1 = Gender.valueOfType("不存在");
    if (gender1 != null) {
      System.out.println(gender1.getType());
    }

    System.out.println(gender1);

    Gender gender2 = Gender.valueOf("MALE");
    System.out.println(gender2);

    Gender gender3 = Gender.valueOf("1234");
    System.out.println(gender3);
  }
}
