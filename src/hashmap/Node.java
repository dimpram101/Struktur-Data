package hashmap;

public class Node {
  private int value;
  private String key;
  private Node left,right;

  public Node(String key, int value){
    this.key = key;
    this.value = value;
    this.left = this.right = null;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getKey() {
    return this.key;
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