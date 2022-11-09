package redblack_tree;

public class RedBlackTree {
  private Node root;

  public RedBlackTree() {
    this.root = null;
  }

  public Node getRoot() {
    return this.root;
  }

  public boolean add(int value) {
    if (this.root == null) {
      this.root = new Node(value);
      balance(this.root);
      return true;
    } else {
      return add(this.root, value);
    }
  }

  private boolean add(Node node, int value) {
    if (value > node.getValue()) {
      if (node.getRight() != null)
        return add(node.getRight(), value);
      Node newNode = new Node(value);
      node.setRight(newNode);
      node.getRight().setParent(node);
      balance(node.getRight());
      return true;
    } else if (value < node.getValue()) {
      if (node.getLeft() != null)
        return add(node.getLeft(), value);
      Node newNode = new Node(value);
      node.setLeft(newNode);
      node.getLeft().setParent(node);
      balance(node.getLeft());
      return true;
    }

    return false;
  }

  public void exist(int value) {
    return;
  }

  private void balance(Node node) {
    if (node.getParent() != null && node.getParent().getParent() != null) {
      if (node.getParent() == node.getParent().getParent().getRight()) {
        if (node.getParent().getParent().getLeft() != null && node.getParent().getParent().getLeft().isRed()) {
          node.getParent().getParent().getLeft().setRed(false);
          node.getParent().getParent().setRed(true);
          node.getParent().setRed(false);
          balance(node.getParent().getParent());
        } else {
          if (node == node.getParent().getLeft()) {
            node = node.getParent();
            rightRotate(node);
          }
          node.getParent().setRed(false);
          node.getParent().getParent().setRed(true);
          leftRotate(node.getParent().getParent());
        }
      } else {
        if (node.getParent().getParent().getRight() != null && node.getParent().getParent().getRight().isRed()) {
          node.getParent().getParent().getRight().setRed(false);
          node.getParent().getParent().setRed(true);
          node.getParent().setRed(false);
          balance(node.getParent().getParent());
        } else {
          if (node == node.getParent().getRight()) {
            node = node.getParent();
            leftRotate(node);
          }
          node.getParent().setRed(false);
          node.getParent().getParent().setRed(true);
          rightRotate(node.getParent().getParent());
        }
      }
    }
    this.root.setRed(false);
  }

  public void rightRotate(Node node) {
    if (this.root == node)
      this.root = node.getLeft();
    else if (node == node.getParent().getRight())
      node.getParent().setRight(node.getLeft());
    else
      node.getParent().setLeft(node.getLeft());
    node.getLeft().setParent(node.getParent());
    node.setParent(node.getLeft());
    node.setLeft(node.getLeft().getRight());
    node.getParent().setRight(node);
    if (null != node.getLeft())
      node.getLeft().setParent(node);
  }

  public void leftRotate(Node node) {
    if (this.root == node)
      this.root = node.getRight();
    else if (node == node.getParent().getRight())
      node.getParent().setRight(node.getRight());
    else
      node.getParent().setLeft(node.getRight());
    node.getRight().setParent(node.getParent());
    node.setParent(node.getRight());
    node.setRight(node.getRight().getLeft());
    node.getParent().setLeft(node);
    if (null != node.getRight())
      node.getRight().setParent(node);
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
      System.out.println("|----" + (root.isRed() ? "\u001B[31m" + root.getValue() + "\u001B[0m" : root.getValue()));
    } else {
      System.out.println((root.isRed() ? "\u001B[31m" + root.getValue() + "\u001B[0m" : root.getValue()));
    }
    showTree(root.getLeft(), startIndex + 1);
  }
}
