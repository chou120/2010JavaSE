public class Node<T> {

  private Node<T> prev;
  private Node<T> next;

  private T value;

  public Node() {
  }

  public Node(T value) {
    this.value = value;
  }

  public Node(Node prev, Node next, T value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  public Node<T> getPrev() {
    return prev;
  }

  public void setPrev(Node<T> prev) {
    this.prev = prev;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Node{" +
        "prev=" + prev +
        ", next=" + next +
        ", value=" + value +
        '}';
  }

  public static void main(String[] args) {
    Node node = new Node();
    node.next = new Node();

    node.next.setValue(1);

    node.next.next = new Node();

    node.next.next.setValue(2);

    while (node != null) {
      System.out.println(node.getValue());
      node = node.next;
    }
  }
}
