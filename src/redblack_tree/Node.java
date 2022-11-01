package redblack_tree;

public class Node {
  private int value;
  private Node parent;
  private Node left, right;
  private boolean isRed;

  public Node(int value) {
    this.value = value;
    this.parent = null;
    this.left = this.right = null;
  }

  public int getValue() {
    return this.value;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public Node getParent() {
    return this.parent;
  }

  public void setLeft(Node node) {
    this.left = node;
  }

  public Node getLeft() {
    return this.left;
  }

  public void setRight(Node node) {
    this.right = node;
  }

  public Node getRight() {
    return this.right;
  }

  public void setIsRed(boolean value) {
    this.isRed = value;
  }

  public boolean isRed() {
    return this.isRed;
  }

}
