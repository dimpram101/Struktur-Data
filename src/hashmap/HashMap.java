package hashmap;

public class HashMap {
  private Node root;

  public HashMap() {
    this.root = null;
  }

  public Node getRoot() {
    return this.root;
  }

  public void insert(String key, int value) {
    if (this.root == null) {
      this.root = new Node(key, value);
      return;
    }
    insertNode(this.root, key, value);
  }

  public Node insertNode(Node root, String key, int value) {
    if (root == null) {
      root = new Node(key, value);
    }
    
    if (key.compareTo(root.getKey()) < 0) {
      root.setLeft(insertNode(root.getLeft(), key, value));
    } else if (key.compareTo(root.getKey()) > 0) {
      root.setRight(insertNode(root.getRight(), key, value));
    }

    return root;
  }
  
  public void show() {
    showTree(this.root, 0);
  }

  private void showTree(Node root, int indent) {
    if (root == null)
      return;
    showTree(root.getRight(), indent + 1);
    if (indent != 0) {
      for (int i = 0; i < indent - 1; i++) {
        System.out.print("|      ");
      }
      System.out.println("|------" + root.getKey() + "(" + root.getValue() + ")");
    } else {
      System.out.println(root.getKey() + "(" + root.getValue() + ")");
    }
    showTree(root.getLeft(), indent + 1);
  }

  public void sort(Node root) {
    if (root != null) {
      sort(root.getLeft());
      System.out.println(root.getKey());
      sort(root.getRight());
    }
  }

}
