public class MyStringBuilder {

  private String value = "";

  public MyStringBuilder append(String str) {
    value += str;
    return this;
  }

  public MyStringBuilder append(String str, MyStringBuilder builder) {
    value += str;
    System.out.println(this == builder);
    return builder;
  }

  public String toString() {
    return value;
  }

  public static void main(String[] args) {
    MyStringBuilder stringBuilder = new MyStringBuilder();
    stringBuilder.append("123").append("abc");

    MyStringBuilder otherBuilder = stringBuilder.append("123", stringBuilder);
    System.out.println(otherBuilder == stringBuilder);
    otherBuilder.append("1234");

    System.out.println(stringBuilder.toString());
  }
}
