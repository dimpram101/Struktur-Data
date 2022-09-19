package test1;

public class Sorting {
  private LinkedList list;

  public Sorting(LinkedList currentList) {
    this.list = currentList;
  }
  
  public void bubbleSort(){
    int length = this.list.getLength();
    for(int i = 0; i < length - 1; i++){
      for(int j = 0; j < length - 1; j++) {
        Node node = this.list.findNode(j);
        if(node.getValue() > node.getNext().getValue()){
          this.list.swap(node, node.getNext());
        } else {
          continue;
        }
        System.out.println(this.list);
      }
    }
  }

  public void insertionSort() {
    int length = this.list.getLength();
    for (int i = 1; i < length; i++){
      Node removedNode = this.list.remove(i);
      Node prevRemovedNode = removedNode.getPrev();
      int insertIndex = i - 1;
      while (insertIndex >= 0 && prevRemovedNode.getValue() > removedNode.getValue()){
        prevRemovedNode = prevRemovedNode.getPrev();
        insertIndex -= 1;
      }
      this.list.insert(removedNode, insertIndex + 1);
      System.out.println(this.list);
    }
  }

  public void selectionSort(){
    Node toBeSwapped, minimum, nextMinimum;
    int length = this.list.getLength();

    for (int i = 0; i < length; i++ ){
      toBeSwapped = minimum = this.list.findNode(i);
      nextMinimum = minimum.getNext();

      while (nextMinimum != null) {
        if (nextMinimum.getValue() < minimum.getValue()){
          minimum = nextMinimum;
        }
        nextMinimum = nextMinimum.getNext();
      }
      this.list.swap(toBeSwapped, minimum);
      System.out.println(this.list);
    }
  }
}
