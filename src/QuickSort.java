public class QuickSort {
  LinkedList list;
  int length;

  public QuickSort(LinkedList list) {
    this.list = list;
    this.length = list.getLength();
  }

  public int partition(int low, int high) {
    Node pivot = this.list.findNode(high);
    Node lowest = this.list.findNode(low);
    
    int i = (low - 1);
    int j = low;

    while(lowest.getNext() != null) {
      if (lowest.getValue() < pivot.getValue()) {
        i++;
        this.list.swap(i, j);
      }
      j++;
      lowest = lowest.getNext();
    }
    
    this.list.swap(i+1, high);
    return (i + 1);
  }

  public void quickSort(int low, int high) {
    if (low < high) {
      int pi = partition(low, high);
      quickSort(low, pi - 1);
      quickSort(pi + 1, high);
    }
  }
}
