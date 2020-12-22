package club.banyuan;

public class Commission extends Hourly {

  private double salesAmount;
  private double rate;
  // 该雇员的总销售额（类型为double），
  // 该雇员的佣金率（佣金率数据类型为double表示百分比佣金，用于计算该员工的销售收入（0.2表示该员工的销售收入为20％的佣金））。

  public Commission(String eName, String eAddress, String ePhone, String socSecNumber,
      double rate) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
  }

  public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate,
      double rate1) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    this.rate = rate1;
  }

  public double getSalesAmount() {
    return salesAmount;
  }

  public void setSalesAmount(double salesAmount) {
    this.salesAmount = salesAmount;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  @Override
  public String toString() {
    return super.toString() + "\n销售总额：" + salesAmount;
  }

  public void addSales(double totalSales) {
    salesAmount += totalSales;
  }

  @Override
  public double pay() {
    double pay = super.pay() + salesAmount * rate;
    salesAmount = 0;
    return pay;
  }
}
