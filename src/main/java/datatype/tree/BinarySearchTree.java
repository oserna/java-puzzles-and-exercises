package datatype.tree;

public class BinarySearchTree {

    private static Node head;

    public static void add(int value) {

        if (head == null) {
            head = new Node(value);
            return;
        }

        add(value, head);

    }

    private static void add(int value, Node current){

        if (current.getValue() == value){
                return;
        }

        if (value < current.getValue() ) {
            if(current.getLeft() != null){
              add(value, current.getLeft());
            }

            current.setLeft(new Node(value));
        } else {
            if(current.getRight() != null){
                add(value, current.getRight());
            }

            current.setRight(new Node(value));
        }

    }

    public static Node tree(){
        return head;
    }



}
