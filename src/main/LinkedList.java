package main;
public class LinkedList {
  private Node first;
  private Node last;
  private int length = 0;

  public LinkedList(){
    this.first = null;
    this.last = null;
  }

  public int getLength(){
    return this.length;
  }

  public Node getFirst(){
    return this.first;
  }

  public Node getLast(){
    return this.last;
  }

  public Node findNode(int index) {
    Node currentNode;

    if (index == 0 ) { 
      return this.first;
    }

    if (index == length-1) {
      return this.last;
    }

    currentNode = this.first;
    for (int i = 0; i < index; i++) {
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
    length++;
  }

  public void insert(int value, int index) {
    if(index > length) {
      throw new Error("Index input is bigger than the length that this LinkedList has!");
    }

    Node temp = new Node(value);

    if(index == 0){
      if(length == 0) {
        this.first = this.last = temp;
      } else {
        this.first.setPrev(temp);
        temp.setNext(this.first);
        this.first = temp;
      }
    } else {
      Node currentNode = this.findNode(index);
      Node currentPrevNode = currentNode.getPrev();
      temp.setPrev(currentPrevNode);
      temp.setNext(currentNode);
      currentPrevNode.setNext(temp);
      currentNode.setPrev(temp);
    }
    length++;
  }

  public void insert(Node node, int index) {
    if(index > length) {
      throw new Error("Index input is bigger than the length that this LinkedList has!");
    }

    if(index == 0){
      if(length == 0) {
        this.first = this.last = node;
      } else {
        this.first.setPrev(node);
        node.setNext(this.first);
        this.first = node;
      }
    } else if (index == this.length) {
      this.last.setNext(node);
      node.setPrev(this.last);
      this.last = node;
    } else {
      Node currentNode = this.findNode(index);
      Node currentPrevNode = currentNode.getPrev();
      node.setPrev(currentPrevNode);
      node.setNext(currentNode);
      currentPrevNode.setNext(node);
      currentNode.setPrev(node);
    }
    length++;
  }

  public Node remove(int index) {    
    if (index > this.length || index < 0) {
      throw new Error("Index invalid");
    }
    Node removedNode = this.findNode(index);
    Node currentNode;
    if(index == 0) {
      this.first = this.first.getNext();
      this.first.setPrev(null);
    } else if (index == this.length - 1) {
      this.last = this.last.getPrev();
      this.last.setNext(null); 
    } else {
      currentNode = this.findNode(index);  
      if ( currentNode.getNext() != null){
        currentNode.getPrev().setNext(currentNode.getNext());
        Node prevNode = currentNode.getPrev();
        Node nextNode = currentNode.getNext();
        nextNode.setPrev(prevNode);
      } else {
        currentNode.getPrev().setNext(null);
        // currentNode.setPrev(currentNode.getPrev());
        this.last = currentNode.getPrev();
      }
    }
    length--;
    return removedNode;
  }

  public Node remove(Node node) {    
    if(node == this.first) {
      this.first = this.first.getNext();
      this.first.setPrev(null);
    } else if (node == this.last) {
      this.last = this.last.getPrev();
      this.last.setNext(null);
    } else { 
      if ( node.getNext() != null){
        node.getPrev().setNext(node.getNext());
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        nextNode.setPrev(prevNode);
      } else {
        node.getPrev().setNext(null);
        // node.setPrev(node.getPrev());
        this.last = node.getPrev();
      }
    }
    length--;
    return node;
  }

  public void swap(Node node1, Node node2) {
    if(node1 == this.first) {
      this.first = node2;
    } else if (node2 == this.first) {
      this.first = node1;
    }

    if(node1 == this.last) {
      this.last = node2;
    } else if (node2 == this.last) {
      this.last = node1;
    }

    Node tempNode = node1.getNext();
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

  public void swap(int index1, int index2) {
    if(length < index1 || index1 < 0 || length < index2 || index2 < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }

    Node node1 = this.findNode(index1);
    Node node2 = this.findNode(index2);

    if(node1 == this.first) {
      this.first = node2;
    } else if (node2 == this.first) {
      this.first = node1;
    }

    if(node1 == this.last) {
      this.last = node2;
    } else if (node2 == this.last) {
      this.last = node1;
    }

    Node tempNode = node1.getNext();
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

  public void showAll(){
    Node currentNode = this.first;
    for(int i = 0; i < length; i++) {
      System.out.println("Index : " + i);
      System.out.println("Value : " + currentNode.getValue());
      System.out.println("Prev : " + currentNode.getPrev());
      System.out.println("Next : " + currentNode.getNext());
      System.out.println("\n");
      currentNode = currentNode.getNext();
    }
  }

  public void showPrev(){
    Node currentNode = this.last;
    for(int i = this.length; i > 0; i--) {
      System.out.println("Index : " + i);
      System.out.println("Value : " + currentNode.getValue());
      System.out.println("Prev : " + currentNode.getPrev());
      System.out.println("Next : " + currentNode.getNext());
      System.out.println("\n");
      currentNode = currentNode.getPrev();
    }
  }

  @Override
  public String toString(){
    Node currentNode = this.first;
    String value = "";
    for(int i = 0; i < length; i++) {
      value = value + currentNode.getValue() + " ";
      currentNode = currentNode.getNext();
    }
    return value;
  }
}

