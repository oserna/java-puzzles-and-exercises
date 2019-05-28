package datatype.tree;

public  class Node<T> {

    T value;

    private Node<T> left;
    private Node<T> right;
    private boolean visited;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> node) {
        this.left = node;
    }

    public void setRight(Node<T> node) {
        this.right = node;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}