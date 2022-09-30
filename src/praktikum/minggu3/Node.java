package praktikum.minggu3;

public class Node {
    private int value;
    private Node next;
    private Node prev;

    public Node(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public int getValue() {
        return this.value;
    }
}