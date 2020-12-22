package beijing;

public class BeijingFather {

  public String publicField = "publicField";
  private String privateField = "privateField";

  String defaultField = "defaultField";
  protected String protectedField = "protectedField";

  public void publicMethod() {
    System.out.println(publicField);
  }

  private void privateMethod() {
    System.out.println(privateField);
  }

  void defaultMethod() {
    System.out.println(defaultField);
  }

  protected void protectedMethod() {
    System.out.println(protectedField);
  }

}
