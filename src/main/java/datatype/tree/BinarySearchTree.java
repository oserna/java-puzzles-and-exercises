package datatype.tree;

import java.util.Comparator;

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



}
