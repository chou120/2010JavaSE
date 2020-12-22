package club.banyuan.serial.ext;

import java.io.Serializable;

public class Father implements Serializable {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
