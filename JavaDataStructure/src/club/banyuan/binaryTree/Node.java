package club.banyuan.binaryTree;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 2:11 下午
 */
public class Node {
  /**
   * a、找到 key 值为 10 的节点的直接中序后继节点（即其右子树中值最小的节点 11），并删除此直接中序后继节点。
   * b、将此后继节点的 key、value 值赋给待删除节点的 key，value值。
   */
   int key; //找到指定的节点
   int value; // value  节点值
   Node leftChild; //左子节点
   Node rightChild;//右子节点

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
    this.leftChild = null;
    this.rightChild = null;
  }

  public Node(int key, int value, Node leftChild, Node rightChild) {
    super();
    this.key = key;
    this.value = value;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public Node() {

  }

  @Override
  public String toString() {
    return "Node [key=" + this.key + ", value=" + this.value + ", leftChild=" + this.leftChild + ", rightChild=" + this.rightChild + "]";
  }

  public int getKey() {
    return this.key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeftChild() {
    return this.leftChild;
  }

  public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  public Node getRightChild() {
    return this.rightChild;
  }

  public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }


}
