package club.banyuan;

public class Main {

  public static void main(String[] args) {
    Provider provider = new Provider(1, "小米", "are you ok");

    String s = JsonUtil.toJsonString(provider);
    System.out.println(s);

    String str = "{\"name\":\"小米\",\"id\":1,\"desc\":\"are you ok\"}";

    Provider rlt = JsonUtil.parseObject(str, Provider.class);
    System.out.println(rlt);
  }
}
