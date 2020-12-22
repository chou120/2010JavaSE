package club.banyuan.refine;

public class EnumDemo {

  public static void main(String[] args) {
    System.out.println(GenderEnum.MALE.name());
    System.out.println(GenderEnum.MALE.ordinal());
    System.out.println(GenderEnum.MALE == GenderEnum.FEMALE);
    System.out.println(GenderEnum.MALE.compareTo(GenderEnum.FEMALE));
    System.out.println(GenderEnum.MALE.compareTo(GenderEnum.ALIENS));

    // 如果枚举类中成员没有被final修饰，可以通过set方法进行修改
    // GenderEnum.MALE.setType("abc");

    System.out.println(GenderEnum.MALE.getType());
  }
}
