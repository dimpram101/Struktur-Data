package praktikum.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean insert(int value) {
        if(this.root == null) {
            this.root = new Node(value);
            return true;
        }

        if(searchValue(this.root, value)) {
            System.out.println(value + " sudah ada!");
            return false;
        }

        insertValue(this.root, value);

        return true;
    }

    public Node insertValue(Node parent, int value) {
        if(parent == null) {
            parent = new Node(value);
            return parent;
        }
        else if(value < parent.getValue()) {
            Node childLeft = insertValue(parent.getLeft(), value);
            parent.setLeft(childLeft);
            childLeft.setParent(parent);
        }
        else if(value > parent.getValue()) {
            Node childRight = insertValue(parent.getRight(), value);
            parent.setRight(childRight);
            childRight.setParent(parent);
        }

        return parent;
    }

    public void search(int value) {
        if(this.root == null) {
            System.out.println("Tidak ada satupun Node di dalam tree");
            return;
        }
        else if(searchValue(this.root, value)) {
            System.out.println(value + " ada di dalam Tree");
        } 
        else {
            System.out.println(value + " tidak ada di dalam Tree");
        }
    }

    public boolean searchValue(Node parent, int value) {
        if(parent == null) {
            return false;
        }
        else if(value == parent.getValue()) {
            return true;
        }
        else if(value < parent.getValue()) {
            return searchValue(parent.getLeft(), value);
        }
        else if(value > parent.getValue()) {
            return searchValue(parent.getRight(), value);
        }

        return false;
    }

    public void searchNode(int value) {
        if(this.root == null) {
            System.out.println("Tidak ada satupun Node di dalam tree");
            return;
        }
        Node node = searchNodeByValue(this.root, value);
        if(node != null) {
            if(node.getParent() != null) {
                System.out.println(value + " ada di dalam Tree" + ", Parent Nodenya adalah " + node.getParent().getValue());
            }
            else {
                System.out.println("Node adalah root");
            }
        } 
        else {
            System.out.println(value + " tidak ada di dalam Tree");
        }
    }

    public Node searchNodeByValue(Node parent, int value) {
        if(parent == null) {
            return null;
        }
        else if(value == parent.getValue()) {
            return parent;
        }
        else if(value < parent.getValue()) {
            return searchNodeByValue(parent.getLeft(), value);
        }
        else if(value > parent.getValue()) {
            return searchNodeByValue(parent.getRight(), value);
        }

        return parent;
    }

    public void show() {
        showTree(this.root, 1);
    }

    public void showTree(Node parent, int depth) {
        if(parent == null) {
            return;
        }
        showTree(parent.getRight(), depth + 1);
        if(depth != 0) {
            for(int i = 0; i < depth - 1; i++) {
                System.out.print("|    ");
            }
            System.out.println("|----" + parent.getValue());
        }
        else {
            System.out.println(parent.getValue());
        }
        showTree(parent.getLeft(), depth + 1);
    }

    public void sort(Node parent) {
        if (parent != null) {
            sort(parent.getLeft());
            System.out.println(parent.getValue());
            sort(parent.getRight()); 
        }
    }

    public void update(int valueInTree, int newValue) {
        updateValue(valueInTree, newValue, this.root);
    }

    public Node updateValue(int valueInTree, int newValue, Node parent) {
        if(parent == null)
            return null;

        if(valueInTree == parent.getValue()) {
            if(parent.getLeft() != null && parent.getLeft().getValue() > newValue) {
                return null;        
            } 
            else if(parent.getRight() != null && parent.getRight().getValue() < newValue) {
                return null;
            }
            parent.setValue(newValue);
            return parent;
        }

        if(valueInTree < parent.getValue()) {
            updateValue(valueInTree, newValue ,parent.getLeft());
        } 
        else if(valueInTree > parent.getValue()) {
            updateValue(valueInTree, newValue, parent.getRight());
        }

        return root;
    }
}
