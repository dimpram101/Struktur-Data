package binary_search_tree;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(5);
    bst.insert(6);
    bst.insert(3);
    bst.insert(9);
    bst.insert(4);
    bst.insert(2);
    bst.insert(7);
    bst.insert(10);
    bst.insert(8);
    bst.insert(1);
    bst.show();
    // System.out.println();
    // bst.update(9, 8);
    // bst.show();
    // bst.search(11);
    // bst.show();
  }
}
