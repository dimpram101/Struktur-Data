package praktikum.minggu3;

public class Main {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

    linkedList.add(8);
    linkedList.add(1);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(9);

    System.out.println(linkedList);
    System.out.println(linkedList.findNode(5).getValue());

  }
}
