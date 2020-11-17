package club.banyuan.practice;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/17 11:15 上午
 */
public class Subject {

  private  String  subjectName; //科目名称
  private  double  subScore; //科目成绩
  private  String  SubId; //科目编号

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public double getSubScore() {
    return subScore;
  }

  public void setSubScore(double subScore) {
    this.subScore = subScore;
  }

  public String getSubId() {
    return SubId;
  }

  public void setSubId(String subId) {
    SubId = subId;
  }

  @Override
  public String toString() {
    return "Subject{" +
        "subjectName='" + subjectName + '\'' +
        ", subScore=" + subScore +
        ", SubId='" + SubId + '\'' +
        '}';
  }
}

