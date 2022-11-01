package praktikum.binarysearchtree;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node parent;
    
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
    public void setLeft(Node next) {
        this.left = next;
    }
    
    public void setRight(Node prev) {
        this.right = prev;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }
    
    public Node getParent() {
        return this.parent;
    }

    public int getValue() {
        return this.value;
    }
}