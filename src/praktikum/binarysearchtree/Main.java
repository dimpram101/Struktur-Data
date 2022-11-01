package praktikum.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(8);
        bst.insert(3);
        bst.insert(9);
        bst.insert(10);
        bst.insert(6);
        bst.insert(35);
        bst.insert(21);
        bst.insert(17);

        bst.show();

        // bst.search(6);
        // bst.searchNode(8);

        // System.out.println();
        // bst.update(9, 8);
        // bst.show();
        // bst.search(11);
        // bst.show();
    }
}