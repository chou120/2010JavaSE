package club.banyuan;

public class Fraction {

  // 分子
  private int molecule;
  // 分母
  private int denominator;

  public Fraction() {
  }

  public Fraction(int molecule, int denominator) {
    int divisor = greatestCommonDivisor(molecule, denominator);
    this.molecule = molecule / divisor;
    this.denominator = denominator / divisor;
  }

  public int getMolecule() {
    return molecule;
  }

  public void setMolecule(int molecule) {
    this.molecule = molecule;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }

  /**
   * 求最大公约数实现一
   *
   * @param a
   * @param b
   * @return
   */
  private int greatestCommonDivisor(int a, int b) {
    int mod = a % b;
    if (mod == 0) {
      return b;
    } else {
      return greatestCommonDivisor(b, mod);
    }
  }

  /**
   * 求最大公约数实现二
   *
   * @param a
   * @param b
   * @return
   */
  private int greatestCommonDivisorCommon(int a, int b) {
    int min = Math.min(Math.abs(a), Math.abs(b));
    for (int i = min; i > 0; i--) {
      if (a % i == 0 && b % i == 0) {
        return i;
      }
    }
    return 1;
  }

  public double toDouble() {
    return (double) molecule / denominator;
  }

  // 分子1 / 分母1  + 分子2 / 分母2
  // 分子 = 分子1 * 分母2 + 分子2 * 分母1
  // 分母 = 分母1 * 分母2
  public Fraction plus(Fraction r) {
    int molecule = this.molecule * r.getDenominator() + r.getMolecule() * denominator;
    int denominator = this.denominator * r.getDenominator();
    return new Fraction(molecule, denominator);
  }

  public Fraction multiply(Fraction r) {
    int molecule = this.molecule * r.getMolecule();
    int denominator = this.denominator * r.getDenominator();
    return new Fraction(molecule, denominator);
  }

  public void print() {
    System.out.println(molecule + "/" + denominator);
  }

  public static void main(String[] args) {
    Fraction fraction = new Fraction();
    System.out.println(fraction.greatestCommonDivisor(18, 15));
    System.out.println(fraction.greatestCommonDivisorCommon(18, 15));

    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(3, 5);
    Fraction multiply = f1.multiply(f2);
    multiply.print();
    f1.print();
    f2.print();

    Fraction plus = f1.plus(f2);
    plus.print();
    System.out.println(plus.toDouble());

  }
}
