package club.banyuan.dataset;

import java.util.Date;

public class Main {

  public static void main(String[] args) {
    DataSet dataSet = new DataSet();
    dataSet.add(new Country(10));
    dataSet.add(new Country(20));
    dataSet.add(new Country(30));

    System.out.println(dataSet.getAverage());
    System.out.println(((Country) dataSet.getMaximum()).getPopulation());

    DataSet ds = new DataSet();
    ds.add(new Elephant(2000));
    ds.add(new Elephant(3000));
    ds.add(new Elephant(2500));
    System.out.println(ds.getAverage());
    System.out.println(((Elephant)ds.getMaximum()).getWeightKG());
    // dataSet.add(new Country(20));
    // dataSet.add(new Country(30));

    DataSet dc = new DataSet();
    dc.add(new Circle(5));
    dc.add(new Circle(6));
    dc.add(new Circle(7));
    System.out.println(dc.getAverage());
    System.out.println(((Circle)dc.getMaximum()).area());
  }
}
