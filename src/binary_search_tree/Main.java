package binary_search_tree;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(5);
    bst.insert(10);
    bst.insert(2);
    bst.insert(3);
    bst.insert(1);
    bst.insert(8);
    bst.insert(14);
    bst.insert(54);
    bst.insert(59);
    bst.insert(18);
    // bst.insert(4);
    bst.insert(13);
    bst.insert(17);
    System.out.println("Sebelum update");
    bst.show();
    System.out.println("\nSetelah update");
    // System.out.println("2 -> 4\n54 -> 69\n10 -> 7");
    // bst.update(2, 4);
    // bst.update(54, 69);
    // bst.update(10, 7);
    // bst.update(13, 15);
    bst.show();
  }
}
