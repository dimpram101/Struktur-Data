package linkedlist;
public class Sorting {
  private LinkedList list;
  private int length;

  public Sorting(LinkedList currentList) {
    this.list = currentList;
    this.length = currentList.getLength();
  }

  public void bubbleSort() {
    for (int i = 0; i < length - 1; i++) {
      for (int j = 0; j < length - 1; j++) {
        Node node = this.list.findNode(j);
        if (node.getValue() > node.getNext().getValue()) {
          this.list.swap(node, node.getNext());
        } else {
          continue;
        }
        System.out.println(this.list);
      }
    }
  }

  public void insertionSort() {
    for (int i = 1; i < length; i++) {
      Node removedNode = this.list.remove(i);
      Node prevRemovedNode = removedNode.getPrev();
      int insertIndex = i - 1;
      while (insertIndex >= 0 && prevRemovedNode.getValue() > removedNode.getValue()) {
        prevRemovedNode = prevRemovedNode.getPrev();
        insertIndex -= 1;
      }
      this.list.insert(removedNode, insertIndex + 1);
    }
  }

  public void selectionSort() {
    Node toBeSwapped, minimum, nextMinimum;

    for (int i = 0; i < length; i++) {
      toBeSwapped = minimum = this.list.findNode(i);
      nextMinimum = minimum.getNext();

      while (nextMinimum != null) {
        if (nextMinimum.getValue() < minimum.getValue()) {
          minimum = nextMinimum;
        }
        nextMinimum = nextMinimum.getNext();
      }
      this.list.swap(toBeSwapped, minimum);
      System.out.println(this.list);
    }
  }

  // public void shellSort() {
  // int gap = (int)Math.floor(length/2);
  // System.out.println(gap);

  // while (gap > 0) {
  // int subSet = 0;
  // for (int i = gap; i < this.length; i++) {
  // Node temp = this.list.findNode(i);
  // subSet++;

  // for(int j = i; j >= gap && this.list.findNode(j-gap).getValue() >
  // temp.getValue(); j -= gap) {
  // this.list.swap(this.list.findNode(j-gap), temp);
  // }

  // System.out.println("Gap = " + gap + ", subset yang dicheck = " + subSet);
  // System.out.println(this.list + "\n");
  // }
  // gap = (int)Math.floor(gap/2);
  // }
  // }
  public void shellSort() {
    for (int interval = (int) Math.floor(this.length / 2); interval > 0; interval /= 2) {
      if (interval == 1) {
        System.out.println("Setelah insertionSort : ");
        insertionSort();
        break;
      }

      for (int i = (this.length - interval) - 1; i < length; i += 1) {
        for (int j = i; j >= interval; j -= interval) {
          Node node1 = this.list.findNode(j);
          Node node2 = this.list.findNode(j-interval);
          System.out.println("Temp : " + node1.getValue());
          System.out.println("Interval : " + interval);
          if (node2.getValue() > node1.getValue()) {
            System.out.println("Swap : " + node2.getValue() + " and " + node1.getValue());
            this.list.swap(node1, node2);
          } else {
            System.out.println("Swap : " + node2.getValue() + " and " + node1.getValue() + "   X");
          }
          System.out.println(this.list + "\n");
        }
      }
    }
  }
}
