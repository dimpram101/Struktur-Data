package praktikum.linkedlist;

public class Node {
    private String value;
    private Node next;
    private Node prev;

    public Node(String value) {
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

    public String getValue() {
        return this.value;
    }
}
