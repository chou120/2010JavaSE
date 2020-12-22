public class Pig {

  boolean isAlive = true;

  public void drink(boolean isPoison) {
    if (isPoison) {
      isAlive = false;
    }
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }
}
