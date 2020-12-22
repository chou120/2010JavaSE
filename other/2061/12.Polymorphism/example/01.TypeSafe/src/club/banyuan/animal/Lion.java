package club.banyuan.animal;

public class Lion extends Animal {

  @Override
  public String getType() {
    return "狮子";
  }

  public void lionMethod() {
    System.out.println("lion method");
  }
}
