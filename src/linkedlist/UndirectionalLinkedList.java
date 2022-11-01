package linkedlist;

// package test1;

public class UndirectionalLinkedList {
  public Node first;
  private int length;

  public UndirectionalLinkedList() {
      this.first = null;
      this.length = 0;
  }

  public Node findNode(int index) {
      if (index < length && index >= 0) {
          Node currentNode = this.first;
          for(int i = 0; i < index; i++) {
          currentNode = currentNode.getNext();
          }
          // System.out.print(currentNode.getValue());
          return currentNode;
      } else {
          return null;
      }
  }

  public void add(int value) {
      Node newNode = new Node(value);
      if(this.first == null) {
          this.first = newNode;
      } else {
          Node lastNode = this.findNode(length-1);
          lastNode.setNext(newNode);
      }
      length++;
  }

  public void insert(int value, int index) {
      if (index <= length && index >= 0) {
          if (index == 0) {
              Node node = new Node(value);
              node.setNext(this.first);
              this.first = node;
          } else {
              Node temp = new Node(value);
              Node beforeIndexNode = findNode(index-1);
              Node indexNode = beforeIndexNode.getNext();
  
              beforeIndexNode.setNext(temp);
              beforeIndexNode.getNext().setNext(indexNode);
          }

          length++;
      }
  }

  public void remove(int index) {
      if (index < length && index >= 0) {
          if (index == 0) {
              Node temp = this.first;
              this.first = temp.getNext();
              
          } else {
              Node beforeIndexNode = findNode(index-1);
              Node afterIndexNode = beforeIndexNode.getNext().getNext();
              beforeIndexNode.setNext(afterIndexNode);
          }

          length--;
      }
  }

  public void swap(int index1, int index2) {
      if (index1 < length && index2 < length && index1 >= 0 && index1 >= 0) {
        Node  prevNode1 = null;
        Node  prevNode2 = null;
        Node  pointerNode1 = this.first;
        Node  pointerNode2 = this.first;
        int  i1 = 0;
        int  i2 = 0;
        while (i1 < index1) {
            prevNode1 = pointerNode1;
            pointerNode1 = pointerNode1.getNext();
            i1++;
        }
        while (i2 < index2) {
            prevNode2 = pointerNode2;
            pointerNode2 = pointerNode2.getNext();
            i2++;
        }
        if (pointerNode1 != null && pointerNode2 != null) {
            if (prevNode1 != null) {
                prevNode1.setNext(pointerNode2);
            } else {
                this.first = pointerNode2;
            }
            if (prevNode2 != null) {
                prevNode2.setNext(pointerNode1);
            } else {
                this.first = pointerNode1;
            }
            Node  tempNode = pointerNode1.getNext();
            pointerNode1.setNext(pointerNode2.getNext());
            pointerNode2.setNext(tempNode);
        }
      }
  }

  public int get(int index) {
      if (index < length && index >= 0) {
  
          Node indexNode = findNode(index);
          return indexNode.getValue();
      } else {
          return 0;
      }
  }

  public void showAll() {
    Node currentNode = this.first;
    String value = "";
    for(int i = 0; i < length; i++) {
      value = value + currentNode.getValue() + " ";
      currentNode = currentNode.getNext();
    }
    System.out.println(value);
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

  public static void main(String[] args) {
      UndirectionalLinkedList newLinkedList = new UndirectionalLinkedList();

      newLinkedList.add(1);
      newLinkedList.add(2);
      newLinkedList.add(3);
      newLinkedList.add(4);
      newLinkedList.add(5);

      newLinkedList.showAll();

      newLinkedList.swap(4,0);

      newLinkedList.showAll();

  }
}
