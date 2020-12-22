package club.banyuan.sync;

import java.util.ArrayList;

public class SyncList extends ArrayList<String> {

  @Override
  public synchronized boolean add(String s) {
    return super.add(s);
  }
}
