// package club.banyuan;
//
// import java.util.Iterator;
//
// public class PairIterator<K, V> implements Iterator<OnePair<K, V>> {
//
//   private int index = -1;
//   private Pairs<K, V> pairs;
//
//   public PairIterator(Pairs<K, V> pairs) {
//     this.pairs = pairs;
//   }
//
//   @Override
//   public boolean hasNext() {
//     return index + 1 < pairs.getCount();
//   }
//
//   /**
//    * 返回迭代器中的下一个对象
//    */
//   @Override
//   public OnePair<K, V> next() {
//     if (!hasNext()) {
//       throw new IndexOutOfBoundsException("没有下一个元素");
//     }
//
//     return pairs.getValue()[++index];
//   }
//
//   /**
//    * 从集合中移除next（）返回的上一个对象。
//    */
//   @Override
//   public void remove() {
//     if (pairs.getCount() - 1 - index >= 0) {
//       System.arraycopy(pairs.getValue(), index + 1, pairs.getValue(), index, pairs.getCount() - 1 - index);
//     }
//     int count = pairs.getCount() - 1;
//     pairs.setCount(count);
//     pairs.getValue()[count] = null;
//   }
// }