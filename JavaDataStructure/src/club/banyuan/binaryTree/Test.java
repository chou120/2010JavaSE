package club.banyuan.binaryTree;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/21 2:19 下午
 */
public class Test {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(6, 6);// 插入操作,构造图一所示的二叉树
    tree.insert(3, 3);
    tree.insert(14, 14);
    tree.insert(16, 16);
    tree.insert(10, 10);
    tree.insert(9, 18);
    tree.insert(13, 13);
    tree.insert(11, 11);
    tree.insert(12, 12);
    //
    tree.delete(9);

    tree.inOrder(tree.getRoot());// 中序遍历操作
  }

}
