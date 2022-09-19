package test1;

public class Main {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    
    linkedList.add(90);
    linkedList.add(2);
    linkedList.add(45);
    linkedList.add(12);
    linkedList.add(28);
    linkedList.add(50);
    linkedList.add(2);
    linkedList.add(72);
    linkedList.add(1);
    linkedList.add(86);
    linkedList.add(182);
    linkedList.add(43);

    Sorting sort = new Sorting(linkedList);
    System.out.println(linkedList);
    // // System.out.println("Bubble sort : ");
    // sort.bubbleSort();
    // // System.out.println("Selection sort : ");
    // sort.selectionSort();
    sort.insertionSort();
  }
}
