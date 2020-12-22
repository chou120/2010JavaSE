package club.banyuan.dataset;

public class DataSet {

  double total;
  int count;
  Measure max;

  public void add(Measure x) {
    total += x.measure();
    count++;
    if (max != null && max.measure() < x.measure()) {
      max = x;
    } else if (max == null) {
      max = x;
    }
  }

  public double getAverage() {
    if (count == 0) {
      return 0.0;
    }
    return total / count;
  }

  public Measure getMaximum() {
    return max;
  }


}