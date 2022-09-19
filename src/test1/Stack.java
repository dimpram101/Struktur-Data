package test1;

public class Stack {
  private Node first;
  private int length;

  public Stack() {
      this.first = null;
      this.length = 0;
  }

  public Node findNode(int index) {
      Node temp = this.first;

      for(int i = 0; i < index; i++) {
          temp = temp.getNext();
      }
      
      return temp;
  }

  public boolean hasPop() {
      return null != first;
  }

  public void push(int value) {
      Node node = new Node(value);
      node.setNext(this.first);
      this.first = node;
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
          temp = this.findNode(index-1);
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
      for(int i = 0; i < length ; i++) {
          System.out.println("Index: " + i);
          System.out.println("Value: " + currentNode.getValue() + "\n");
          currentNode = currentNode.getNext();
      }
  }

  public static void main(String[] args) {
      Stack stack = new Stack();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      stack.push(6);
      stack.showAll();
      System.out.println("After POP with value : " + stack.pop());
      stack.showAll();
    }
}
