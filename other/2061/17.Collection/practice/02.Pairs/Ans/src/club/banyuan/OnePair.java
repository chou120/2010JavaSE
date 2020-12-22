package club.banyuan;

import java.util.Objects;

public class OnePair<T,T2> {

  private final T first;
  private final T2 second;

  public OnePair(T first, T2 second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public T2 getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "<" + first.toString() + ", " + second.toString() + ">";
  }

  // 如果equals 返回true， hashcode一定相同
  // hashcode不同， equals一定返回false
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnePair<?, ?> onePair = (OnePair<?, ?>) o;
    return Objects.equals(first, onePair.first) &&
        Objects.equals(second, onePair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }
}