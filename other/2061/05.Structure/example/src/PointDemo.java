public class PointDemo {

  public static void main(String[] args) {
    printGradeTable();
    // System.out.printf("%.1f\n", getGrade(50));
    // System.out.printf("%.1f\n", getGrade(59.5));
    // System.out.printf("%.1f\n", getGrade(79.5));
    // System.out.printf("%.1f\n", getGrade(100));
    // System.out.printf("%.1f\n", getGrade(90));
  }

  static double getGrade(double point) {
    if (point <= 49.5) {
      return 1.0;
    } else if (point <= 59.5 && point >= 50) {
      return 1.3;
    }
    if (point >= 105) {
      return 5.0;
    }

    int step = (int) ((point - 60) / 5);
    double rlt = 1.7;
    for (int i = 0; i < step; i++) {
      rlt = grow(rlt);
    }
    // switch (step) {
    //   case 0:
    //     return 1.7;
    //   case 1:
    //     return 2.0;
    //   case 2:
    //     return 2.3;
    //   case 3:
    //     return 2.7;
    //   case 4:
    //     return 3.0;
    //   case 5:
    //     return 3.3;
    //   case 6:
    //     return 3.7;
    //   case 7:
    //     return 4.0;
    //   case 8:
    //     return 4.7;
    // }
    return rlt;
  }

  static double grow(double grade) {
    if (grade - 4.0 > -0.000001 && grade - 4.0 < 0.000001) {
      return 4.7;
    }
    double decimals = grade - (int) grade;
    if (decimals - 0.3 > -0.000001 && decimals - 0.3 < 0.000001) {
      return grade + 0.4;
    } else {
      return grade + 0.3;
    }
  }

  // 2 ~ 10
  // 60 + (i - 2) * 5 ~ 60 + (i - 2) * 5 + 4.5

  // 2  60 - 64.5
  // 3  65 - 69.5

  static void printGradeTable() {
    double grade = 1.0;
    for (int i = 0; i < 12; i++) {
      if (i == 0) {
        System.out.printf("%.1f\t0 - 49.5\n", grade);
      } else if (i == 1) {
        System.out.printf("%.1f\t50 - 59.5\n", grade);
      } else if (i == 11) {
        System.out.printf("%.1f\t105 - 120\n", grade);
      } else {
        System.out
            .printf("%.1f\t" + (60 + (i - 2) * 5) + " - " + (60 + (i - 2) * 5 + 4.5) + "\n", grade);
      }
      grade = grow(grade);
    }

  }


  static boolean isPass(double point) {
    return false;
  }
}
