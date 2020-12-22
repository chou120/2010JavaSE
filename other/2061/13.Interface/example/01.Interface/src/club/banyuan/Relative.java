package club.banyuan;

public class Relative {

  private Father father;

  public String getFamilyName() {
    return father.getFamilyName();
  }

  public void setFamilyName(String familyName) {
    this.father.setFamilyName(familyName);
  }
}
