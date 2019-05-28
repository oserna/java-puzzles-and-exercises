package datatype.tree;

import java.util.*;

public class BinarySearchTree<T> {

    private  Node<T> head;
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void add(T value) {

        if (head == null) {
            head = new Node<T>(value);
            return;
        }

        add(value, head);

    }

    private void add(T value, Node<T> current) {

        if (current.getValue() == value) {
            return;
        }

        final int compared = comparator.compare(value, current.getValue());
        if (compared == 0) {

        }

        if (compared < 0) {
            if (current.getLeft() != null) {
                add(value, current.getLeft());
                return;
            }

            current.setLeft(new Node<T>(value));
        } else {
            if (current.getRight() != null) {
                add(value, current.getRight());
                return;
            }

            current.setRight(new Node<T>(value));

        }
    }

    public Node<T> tree(){
        return head;
    }

    public List<Node<T>> preOrder(){

        final List<Node<T>> preOrder = new ArrayList<>();

        final Deque<Node<T>> nodes = new ArrayDeque<>();

        nodes.addFirst(head);

        while (!nodes.isEmpty()){

            final Node<T> first = nodes.peekFirst();

            if (!first.isVisited()){
                first.setVisited(true);
                preOrder.add(first);
            }

            Node<T> left = first.getLeft();
            if (left != null && !left.isVisited()) {
                nodes.addFirst(left);
                continue;
            }

            Node<T> right = first.getRight();
            if (right != null && !right.isVisited()) {
                nodes.addFirst(right);
                continue;
            }

            nodes.removeFirst();
        }

        return preOrder;
    }

    public List<Node<T>> inOrder(){

        List<Node<T>> inOrder = new ArrayList<>();

        final ArrayDeque<Node<T>> nodes = new ArrayDeque<>();

        nodes.addFirst(head);

        while (nodes.size() > 0) {

            Node<T> first = nodes.peekFirst();

            Node<T> left = first.getLeft();
            if ( left != null &&  !left.isVisited()) {

                nodes.addFirst(first.getLeft());

                continue;
            }

            first.setVisited(true);
            nodes.removeFirst();

            inOrder.add(first);

            Node<T> right = first.getRight();
            if (right != null && !right.isVisited()) {

                nodes.addFirst(first.getRight());

                continue;
            }


        }

        return inOrder;

    }

    public List<Node<T>> postOrder() {

        final List<Node<T>> postOrder = new ArrayList<>();

        final Deque<Node<T>> nodes = new ArrayDeque<>();

        nodes.addFirst(head);

        while(!nodes.isEmpty()){

            Node<T> first = nodes.peekFirst();

            Node<T> left = first.getLeft();
            if (left != null && !left.isVisited()){
                nodes.addFirst(left);
                continue;
            }

            Node<T> right = first.getRight();
            if (right != null && !right.isVisited()){
                nodes.addFirst(right);
                continue;
            }

            first.setVisited(true);

            nodes.removeFirst();

            postOrder.add(first);

        }

        return postOrder;
    }

    public List<Node<T>> inOrderRecursive(){
        return traverseInOrder(head, new ArrayList<>());
    }

    public List<Node<T>> preOrderRecursive(){
        return traversePreOrder(head, new ArrayList<>());
    }

    public List<Node<T>> postOrderRecursive(){
        return traversePostOrder(head, new ArrayList<>());
    }

    private List<Node<T>> traversePostOrder(Node<T> node, List<Node<T>> list) {

        Node<T> left = node.getLeft();
        if (left != null && !left.isVisited()) {
            traversePostOrder(left, list);
        }

        Node<T> right = node.getRight();
        if (right != null && !right.isVisited()) {
            traversePostOrder(right, list);
        }

        node.setVisited(true);
        list.add(node);

        return list;

    }

    private List<Node<T>> traverseInOrder (Node<T> node, List<Node<T>> list) {

        Node<T> left = node.getLeft();
        if (left != null && !left.isVisited()) {
            traverseInOrder(left, list);
        }

        node.setVisited(true);
        list.add(node);

        Node<T> right = node.getRight();
        if (right != null && !right.isVisited()) {
            traverseInOrder(right, list);
        }

        return list;
    }

    private List<Node<T>> traversePreOrder (Node<T> node, List<Node<T>> list) {

        if (node.isVisited()) {
            node.setVisited(true);
            list.add(node);
        }

        Node<T> left = node.getLeft();
        if (left != null && !left.isVisited()) {
            traversePreOrder(left, list);
        }

        Node<T> right = node.getRight();
        if (right != null && !right.isVisited()) {
            traversePreOrder(right, list);
        }

        return list;
    }

}
