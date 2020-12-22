package club.banyuan;

import java.util.Iterator;
import java.util.function.Consumer;

public class IteratorImpl implements Iterator<String> {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public String next() {
    return null;
  }

  @Override
  public void forEachRemaining(Consumer<? super String> action) {
    while (hasNext()) {
      action.accept(next());
    }
  }
}
