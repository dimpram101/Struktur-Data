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

  public void showTree(Node root, int indent) {
    if (root == null)
      return;
    showTree(root.getRight(), indent + 1);
    if (indent != 0) {
      for (int i = 0; i < indent - 1; i++) {
        System.out.print("|    ");
      }
      System.out.println("|----" + root.getValue());
    } else {
      System.out.println(root.getValue());
    }
    showTree(root.getLeft(), indent + 1);
  }

  public void sort(Node root) {
    if (root != null) {
      sort(root.getLeft());
      System.out.println(root.getValue());
      sort(root.getRight());
    }
  }

  public void update(int valueInTree, int newValue) {
    if (searchValue(newValue, this.root)) {
      System.out.println(newValue + " sudah ada di dalam Tree!");
      return;
    }

    if (!updateValue(valueInTree, newValue, this.root)) {
      System.out.println("gagal memperbaharui");
      return;
    }

    // balance(this.root);
  }

  public boolean updateValue(int value, int newValue, Node root) {
    boolean status = false;
    if (root == null) {
      return status;
    }
  
    Node newNode = new Node(newValue);
    Node tempLeft, tempRight;

    if (root.getRight() != null) {
      if (value == root.getRight().getValue() && newValue > root.getValue()) {
        tempLeft = root.getRight().getLeft();
        tempRight = root.getRight().getRight();
        root.setRight(newNode);
        newNode.setLeft(tempLeft);
        newNode.setRight(tempRight);
        balance(newValue, this.root);
        status = true;
        return status;
      }
    }

    if (root.getLeft() != null) {
      if (value == root.getLeft().getValue() && newValue < root.getValue()) {
        tempLeft = root.getLeft().getLeft();
        tempRight = root.getLeft().getRight();
        root.setLeft(newNode);
        newNode.setLeft(tempLeft);
        newNode.setRight(tempRight);
        balance(newValue, this.root);
        status = true;
        return status;
      } 
    }

    if(value < root.getValue()) {
      status = updateValue(value, newValue, root.getLeft());
    } else if(value > root.getValue()) {
      status = updateValue(value, newValue, root.getRight());
    }

    return status;
  }
  
  public void balance(int value, Node root) {
    if (root == null) {
      return;
    }

    if (value == root.getValue()) {
      if (root.getRight() != null) {
        if (root.getValue() > root.getRight().getValue()) {
          int temp = root.getValue();
          root.setValue(root.getRight().getValue());
          root.getRight().setValue(temp);
        }
      } 

      if (root.getLeft() != null) {
        if (root.getValue() < root.getLeft().getValue()) {
          int temp = root.getValue();
          root.setValue(root.getLeft().getValue());
          root.getLeft().setValue(temp);
        }
      }
    }

    if (value < root.getValue()) {
      balance(value, root.getLeft());
    } else if (value > root.getValue()) {
      balance(value, root.getRight());
    }
  }

  public boolean delete(int value) {
    if(!searchValue(value, this.root)) {
      System.out.println(value + " tidak ada di dalam Tree");
      return false;
    }

    deleteNode(value, this.root);
    return true;
  }

  public Node deleteNode(int value, Node node) {
    if (node == null) {
      return null;
    }

    Node temp;
    if (value == node.getRight().getValue()) {
      temp = node.getRight();
      node.setRight(temp.getRight());
      insertNode(temp.getLeft(), this.root);
      return temp;
    } else if (value == node.getLeft().getValue()) {
      temp = node.getLeft();
      if (temp.getRight() != null) {
        node.setLeft(temp.getRight());
      } else {
        node.setLeft(null);
      }
      insertNode(temp.getLeft(), this.root);
      return temp;
    }

    if (value > node.getValue()) {
      deleteNode(value, node.getRight());
    } else if (value < node.getValue()) {
      deleteNode(value, node.getLeft());
    }

    return node;
  }

  // public void balance(Node node, Node root) {
  //   if (root == null) {
  //     return;
  //   }

  //   if (node.getValue() == root.getValue()) {
  //     if (root.getRight() != null) {
  //       if (root.getValue() > root.getRight().getValue()) {
  //         int temp = root.getValue();
  //         root.setValue(root.getRight().getValue());
  //         root.getRight().setValue(temp);
  //       }
  //     } 

  //     if (root.getLeft() != null) {
  //       if (root.getValue() < root.getLeft().getValue()) {
  //         int temp = root.getValue();
  //         root.setValue(root.getLeft().getValue());
  //         root.getLeft().setValue(temp);
  //       }
  //     }
  //   }

  //   if (node.getValue() < root.getValue()) {
  //     balance(node, root.getLeft());
  //   } else if (node.getValue() > root.getValue()) {
  //     balance(node, root.getRight());
  //   }
  // }

  

  public Node insertNode(Node node, Node root) {
    if (root == null) {
      root = node;
      return root;
    }
    if (node.getValue() < root.getValue()) {
      root.setLeft(insertNode(node, root.getLeft()));
    } else if (node.getValue() > root.getValue()) {
      root.setRight(insertNode(node, root.getRight()));
    }

    return root;
  }
}