// package test1;

// public class UndirectionalLinkedList {
//   public Node first;
//   private int length;

//   public UndirectionalLinkedList() {
//       this.first = null;
//       this.length = 0;
//   }

//   public Node findNode(int index) {
//       if (index < length && index >= 0) {
//           Node currentNode = this.first;
//           for(int i = 0; i < index; i++) {
//           currentNode = currentNode.getNext();
//           }
//           // System.out.print(currentNode.getValue());
//           return currentNode;
//       } else {
//           return null;
//       }
//   }

//   public void add(int value) {
//       Node newNode = new Node(value);
//       if(this.first == null) {
//           this.first = newNode;
//       } else {
//           Node lastNode = this.findNode(length-1);
//           lastNode.setNext(newNode);
//       }
//       length++;
//   }

//   public void insert(int value, int index) {
//       if (index < length && index >= 0) {
//           if (index == 0) {
//               Node node = new Node(value);
//               node.setNext(this.first);
//               this.first = node;
//           } else {
//               Node temp = new Node(value);
//               Node beforeIndexNode = findNode(index-1);
//               Node indexNode = beforeIndexNode.getNext();
  
//               beforeIndexNode.setNext(temp);
//               beforeIndexNode.getNext().setNext(indexNode);
//           }

//           length++;
//       }
//   }

//   public void remove(int index) {
//       if (index < length && index >= 0) {
//           if (index == 0) {
//               Node temp = this.first;
//               this.first = temp.getNext();
              
//           } else {
//               Node beforeIndexNode = findNode(index-1);
//               Node afterIndexNode = beforeIndexNode.getNext().getNext();
//               beforeIndexNode.setNext(afterIndexNode);
//           }

//           length--;
//       }
//   }

//   public void swap(int index1, int index2) {
//       if (index1 < length && index2 < length && index1 >= 0 && index1 >= 0) {
//           Node firstNode = findNode(index1);
//           Node secondNode = findNode(index2);
  
//           insert(secondNode.getValue(), index1);
//           remove(index1+1);
  
//           insert(firstNode.getValue(), index2);
//           remove(index2+1);
//       }
//   }

//   public int get(int index) {
//       if (index < length && index >= 0) {
  
//           Node indexNode = findNode(index);
//           return indexNode.getValue();
//       } else {
//           return 0;
//       }
//   }

//   public void showAll() {
//       Node currentNode = this.first;
//       for (int i = 0; i < length; i++) {
//           System.out.println("Index : " + i);
//           System.out.println("Value : " + currentNode.getValue());
//           System.out.println("NextNode : " + currentNode.getNext());
//           System.out.println("\n");
//           currentNode = currentNode.getNext();
//       }
//   }

//   public static void main(String[] args) {
//       UndirectionalLinkedList newLinkedList = new UndirectionalLinkedList();

//       newLinkedList.add(1);
//       newLinkedList.add(2);
//       newLinkedList.add(3);
//       newLinkedList.add(4);
//       newLinkedList.add(5);

//       newLinkedList.showAll();

//       newLinkedList.swap(4,0);

//       newLinkedList.showAll();

//   }
// }
