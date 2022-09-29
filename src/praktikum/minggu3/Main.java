package praktikum.minggu3;

public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("P");
    list.add("A");
    list.add("S");
    list.add("A");
    list.add("A");

    list.showAll();

    list.insert("L", 2);
    list.showAll();

    list.remove(5);
    list.showAll();

    list.swap(4, 2);
    list.showAll();

    list.remove(2);
    list.showAll();

    list.add("A");
    list.showAll();

    list.removeByValue("L");

    list.add("B"); list.showAll();
    list.add("A"); list.showAll();

    list.add("B"); list.showAll();
    list.add("A"); list.showAll();
    list.add("B"); list.showAll();
    list.add("A"); list.showAll();

    list.removeDuplicat();

    list.showAll();

    list.tailToHead();

    list.showAll();
  }
}
