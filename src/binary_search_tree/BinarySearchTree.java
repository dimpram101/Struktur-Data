package binary_search_tree;

public class BinarySearchTree {
  private Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public Node getRoot() {
    return this.root;
  }

  public Node insert(int value) {
    boolean nodeExist = false;

    if (this.root == null) {
      this.root = new Node(value);
      return this.root;
    }

    nodeExist = searchValue(value, this.root);
    if (nodeExist) {
      System.out.println(value + " sudah ada!");
      return null;
    }

    insertValue(this.root, value);

    return this.root;
  }

  public Node insertValue(Node root, int value) {
    if (root == null) {
      root = new Node(value);
      return root;
    }

    if (value < root.getValue()) {
      root.setLeft(insertValue(root.getLeft(), value));
    } else if (value > root.getValue()) {
      root.setRight(insertValue(root.getRight(), value));
    }

    return root;
  }

  public void search(int value) {
    if (this.root == null) {
      System.out.println("Tidak ada satupun Node di dalam tree");
      return;
    }

    boolean nodeExist = searchValue(value, this.root);
    if (nodeExist) {
      System.out.println(value + " ada di dalam Tree");
    } else {
      System.out.println(value + " tidak ada di dalam Tree");
    }
  }

  public boolean searchValue(int value, Node root) {
    boolean exist = false;
    if (root == null)
      return exist;

    if (value == root.getValue()) {
      exist = true;
      return exist;
    }

    if (value < root.getValue()) {
      exist = searchValue(value, root.getLeft());
    } else if (value > root.getValue()) {
      exist = searchValue(value, root.getRight());
    }

    return exist;
  }

  public void show() {
    showTree(this.root, 0);
  }

  public void showTree(Node root, int startIndex) {
    if (root == null)
      return;
    showTree(root.getRight(), startIndex + 1);
    if (startIndex != 0) {
      for (int i = 0; i < startIndex - 1; i++) {
        System.out.print("|    ");
      }
      System.out.println("|----" + root.getValue());
    } else {
      System.out.println(root.getValue());
    }
    showTree(root.getLeft(), startIndex + 1);
  }

  public void sort(Node root) {
    if (root != null) {
      sort(root.getLeft());
      System.out.println(root.getValue());
      sort(root.getRight()); 
    }
  }

  public Node updateValue(int value, int newValue, Node root) {
    if (root == null)
      return null;

    if (value == root.getValue()) {
      if (root.getLeft() != null && root.getLeft().getValue() > newValue) {
        return null;        
      } else if (root.getRight() != null && root.getRight().getValue() < newValue) {
        return null;
      }
      root.setValue(newValue);
      return root;
    }

    if (value < root.getValue()) {
       updateValue(value, newValue ,root.getLeft());
    } else if (value > root.getValue()) {
       updateValue(value, newValue ,root.getRight());
    }

    return root;
  }

  public void update(int valueInTree, int newValue) {
    updateValue(valueInTree, newValue, this.root);
  }
}