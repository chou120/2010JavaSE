package club.banyuan.dataset;

public class Country implements Measure {

  private int population;

  public Country(int population) {
    this.population = population;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public double measure() {
    return population;
  }
}
