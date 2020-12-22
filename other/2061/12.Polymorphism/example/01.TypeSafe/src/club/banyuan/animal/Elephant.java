package club.banyuan.animal;

public class Elephant extends Animal {

  @Override
  public String getType() {
    return "大象";
  }

  public void elephantMethod() {
    System.out.println("elephant method called");
  }
}
