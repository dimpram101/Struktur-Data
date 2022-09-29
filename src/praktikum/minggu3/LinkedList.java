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

    if (index == 0) {
      return this.first;
    }

    if (index == length - 1) {
      return this.last;
    }

    currentNode = this.first;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }

    return currentNode;
  }

  public Node findNodeByValue(String value) {
    Node currentNode;

    currentNode = this.first;
    for (int i = 0; i < this.length; i++) {
      if (!(currentNode.getValue()).equals(value)) {
        currentNode = currentNode.getNext();
      } else {
        break;
      }
    }

    return currentNode;
  }

  public void add(String value) {
    Node newNode = new Node(value);

    if (this.first == null) {
      this.first = this.last = newNode;
    } else {
      this.last.setNext(newNode);
      this.last = newNode;
    }

    this.length++;
  }

  public void swap(int index1, int index2) {
    Node node1, node2, prevNode1, prevNode2;

    if (length < index1 || index1 < 0 || length < index2 || index2 < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }

    node1 = this.findNode(index1);
    node2 = this.findNode(index2);
    prevNode1 = this.findNode(index1-1);
    prevNode2 = this.findNode(index2-1);

    if (node1 == this.first) this.first = node2;
    else if (node2 == this.first) this.first = node1;
    
    if (node1 == this.last) this.last = node2;
    else if (node2 == this.last) this.last = node1;

    node1.setNext(node2.getNext());
    prevNode2.setNext(node1);

    node2.setNext(node1.getNext());
    prevNode1.setNext(node2);
  }

  public void insert(String value, int index) {
    Node temp = new Node(value);

    Node currentNode;

    if (index > this.length) {
      throw new Error("Index input is bigger than the length that this LinkedList has!");
    }

    if (index == 0) {
      if (this.length == 0) {
        this.first = this.last = temp;
      } else {
        temp.setNext(this.first);
        this.first = temp;
      }
    } else {
      currentNode = this.findNode(index);
      Node prevNode = this.findNode(index-1);
      temp.setNext(currentNode);
      prevNode.setNext(temp);
    }
    this.length++;
  }

  public void remove(int index) {
    if (index > this.length) {
      throw new Error("Index input is bigger than the length that LinkedList has");
    }

    if (index == 0) {
      this.first = this.first.getNext();
    } else {
      Node currentNode = this.findNode(index);
      Node prevNode = this.findNode(index-1);

      if (currentNode.getNext() != null) {
        prevNode.setNext(currentNode.getNext());
      } else {
        prevNode.setNext(null);
        this.last = prevNode;
      }
    }

    length--;
  }

  // public void remove(int index) {
  //   if (index > this.length) {
  //     throw new Error("Index input is bigger than the length that LinkedList has");
  //   }

  //   Node currentNode;

  //   if (index == 0) {
  //     this.first = this.first.getNext();
  //   } else {
  //     currentNode = this.findNode(index);

  //     if (currentNode.getNext() != null) {
  //       currentNode.getPrev().setNext(currentNode.getNext());
  //       Node prevNode = currentNode.getPrev();
  //       Node nextNode = currentNode.getNext();
  //       nextNode.setPrev(prevNode);
  //     }

  //     else {
  //       currentNode.getPrev().setNext(null);
  //       this.last = currentNode.getPrev();
  //     }
  //   }

  //   length--;
  // }

  public void removeByValue(String value) {
    Node currentNode = this.findNodeByValue(value);

    if (currentNode.getNext() != null) {
      currentNode.getPrev().setNext(currentNode.getNext());
      Node prevNode = currentNode.getPrev();
      Node nextNode = currentNode.getNext();
      nextNode.setPrev(prevNode);
    }

    else {
      currentNode.getPrev().setNext(null);
      this.last = currentNode.getPrev();
    }

    length--;
  }

  public void removeByNode(Node node) {
    if (node.getNext() != null) {
      node.getPrev().setNext(node.getNext());
      Node prevNode = node.getPrev();
      Node nextNode = node.getNext();
      nextNode.setPrev(prevNode);
    }

    else {
      node.getPrev().setNext(null);
      this.last = node.getPrev();
    }

    length--;
  }

  public void removeDuplicat() {
    Node currentNode = this.first;
    Node compareNode = currentNode.getNext();

    for (int i = 0; i < length; i++) {
      compareNode = currentNode.getNext();
      for (int j = i + 1; j < length; j++) {
        if (currentNode.getValue().equals(compareNode.getValue())) {
          removeByNode(compareNode);
          j--;
        }
        compareNode = compareNode.getNext();
      }
      currentNode = currentNode.getNext();
    }
  }

  public void tailToHead() {
    int j = length - 1;

    for (int i = 0; i < Math.floor(length / 2); i++) {
      swap(i, j);
      j--;
    }
  }

  public void showAll() {
    Node currentNode = this.first;
    for (int i = 0; i < length; i++) {
      System.out.print(currentNode.getValue() + " ");
      currentNode = currentNode.getNext();
    }
    System.out.print("\n");
  }
}