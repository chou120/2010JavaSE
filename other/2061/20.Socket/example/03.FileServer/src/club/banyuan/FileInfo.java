package club.banyuan;

public class FileInfo {

  private String name;
  private long length;

  public FileInfo() {
  }

  public FileInfo(String name, long length) {
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  @Override
  public String toString() {
    return "FileInfo{" +
        "name='" + name + '\'' +
        ", length=" + length +
        '}';
  }
}
