package Implement.Tree.SplayTree;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parent;

    public Node(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getGrandParent() {
        return parent != null ? parent.getParent() : null;
    }

    public boolean isLeftChild() {
        return parent != null && this == parent.getLeftChild();
    }

    public boolean isRightChild() {
        return parent != null && this == parent.getRightChild();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
