package main;
public class Main {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

    // linkedList.add(56);
    linkedList.add(2);
    // linkedList.add(10);
    // linkedList.add(24);
    // linkedList.add(45);
    // linkedList.add(89);
    // linkedList.add(5);
    // linkedList.add(1);
    // linkedList.add(192);
    // linkedList.add(12);
    // linkedList.add(19);
    // linkedList.add(18);
    // linkedList.add(92);
    // linkedList.add(792);
    // linkedList.add(122);
    // linkedList.add(812);
    // linkedList.add(92);
    // linkedList.add(72);
    // linkedList.add(81);
    // linkedList.add(52);

    // System.out.println(linkedList.getLength());
    // QuickSort sort = new QuickSort(linkedList);
    // sort.quickSort(0, linkedList.getLength()-1);
    Sorting sort = new Sorting(linkedList);
    sort.insertionSort();
    System.out.println(linkedList);
  }
}
