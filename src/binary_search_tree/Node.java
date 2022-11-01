package binary_search_tree;

public class Node {
  private int value;
  private Node left,right;

  public Node(int value){
    this.value = value;
    this.left = this.right = null;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
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
}
