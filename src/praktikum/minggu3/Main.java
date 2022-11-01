package praktikum.minggu3;

public class Main {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("H");
    list.add("A");
    list.add("L");
    list.add("L");
    list.add("O");
    list.add("T");
    list.add("H");
    list.add("E");
    list.add("R");
    list.add("E");
    list.showAll();

    list.removeByValue("E");

    list.showAll();
  }
}
