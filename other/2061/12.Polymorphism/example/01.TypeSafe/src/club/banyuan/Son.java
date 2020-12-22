package club.banyuan;

public class Son extends Father {

  public String field = "son";


  @Override
  public void fatherMethod() {
    System.out.println("override by son");
  }

  public static void main(String[] args) {
    Father father = new Son();
    father.fatherMethod();

    System.out.println(father.field);


  }
}
