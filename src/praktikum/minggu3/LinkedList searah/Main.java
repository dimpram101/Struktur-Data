package praktikum.minggu3;

public class Main {
    public static void main(String[] args) {
        LinkedList newLinkedList = new LinkedList();

        newLinkedList.add("M");
        newLinkedList.add("A");
        newLinkedList.add("K");
        newLinkedList.add("R");
        newLinkedList.add("A");
        newLinkedList.add("B");

        newLinkedList.deleteValue("A");

        newLinkedList.showAll();

    }

}