package linkedlist;

// package test1;

public class Queue {
  private Node first;
  private int length = 0;

  public Queue() {
    this.first = null;
  }

  public boolean hasPop() {
    return null != first;
  }

  public Node findNode(int index) {
    Node temp = this.first;

    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }

    return temp;
  }

  public void push(int value) {
    Node newNode = new Node(value);
    if (this.first == null) {
      this.first = newNode;
    } else {
      Node lastNode = this.findNode(length - 1);
      lastNode.setNext(newNode);
    }
    length++;
  }

  public int pop() {
    if (hasPop()) {
      Node temp = this.first;
      this.first = temp.getNext();

      length--;
      return temp.getValue();
    } else {
      return 0;
    }
  }

  public int pop(int index) {
    if (index <= this.length && hasPop()) {

      Node temp;
      temp = this.findNode(index - 1);
      int output = temp.getNext().getValue();

      temp.setNext(temp.getNext().getNext());
      length--;

      return output;
    } else {
      return 0;
    }
  }

  public void showAll() {
    Node currentNode = this.first;
    String value = "";
    for (int i = 0; i < length; i++) {
      value = value + currentNode.getValue() + " ";
      currentNode = currentNode.getNext();
    }
    System.out.println(value);
  }  
}
