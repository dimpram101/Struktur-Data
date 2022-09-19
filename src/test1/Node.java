package test1;

public class Node {
  private int value;
  private Node next, prev;

  public Node(int value){
    this.value = value;
    this.next = null;
    this.prev = null;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getNext() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public Node getPrev() {
    return this.prev;
  }

}
