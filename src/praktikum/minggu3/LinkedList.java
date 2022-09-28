package praktikum.minggu3;

public class LinkedList {
  private Node first;
  private Node last;
  private int length;

  public LinkedList() {
    this.first = null;
    this.last = null;
    this.length = 0;
  }

  public int getLength() {
    return this.length;
  }

  public Node getFirst() {
    return this.first;
  }

  public Node getLast() {
    return this.last;
  }

  public Node findNode(int index) {
    Node currentNode;

    if (index == 0) return this.first;

    if (index == length - 1) return this.last;

    currentNode = this.first.getNext();
    for (int i = 1; i < index; i++) {
      currentNode = currentNode.getNext();
    }

    return currentNode;
  }

  public void add(int value) {
    Node newNode = new Node(value);

    if (this.first == null) {
      this.first = this.last = newNode;
    } else {
      newNode.setPrev(this.last);
      this.last.setNext(newNode);
      this.last = newNode;
    }

    this.length++;
  }

  public void swap(int index1, int index2) {
    Node node1;
    Node node2;
    Node tempNode;

    if (length < index1 || index1 < 0 || length < index2 || index2 < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }

    node1 = this.findNode(index1);
    node2 = this.findNode(index2);

    if (node1 == this.first) {
      this.first = node2;
    } else if (node2 == this.first) {
      this.first = node1;
    }

    if (node1 == this.last) {
      this.last = node2;
    } else if (node2 == this.last) {
      this.last = node1;
    }

    tempNode = node1.getNext();
    node1.setNext(node2.getNext());
    node2.setNext(tempNode);

    if (node1.getNext() != null) {
      node1.getNext().setPrev(node1);
    }
    if (node2.getNext() != null) {
      node2.getNext().setPrev(node2);
    }

    tempNode = node1.getPrev();
    node1.setPrev(node2.getPrev());
    node2.setPrev(tempNode);

    if (node1.getPrev() != null) {
      node1.getPrev().setNext(node1);
    }
    if (node2.getPrev() != null) {
      node2.getPrev().setNext(node2);
    }
  }

  @Override
  public String toString() {
    Node currentNode = this.first;
    String value = "";
    for (int i = 0; i < length; i++) {
      value = value + currentNode.getValue() + " ";
      currentNode = currentNode.getNext();
    }
    return value;
  }
}