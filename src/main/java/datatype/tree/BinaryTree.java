package datatype.tree;

import java.util.*;

public class BinaryTree<T> {

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    protected Node<T> root;

    public Node<T> tree(){
        return root;
    }


    /* Let us create following BT
           20
         /   \
        8    22
      /  \    \
     4   12   25
        /  \
       10  14
     */

    //Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
    //Expected: 20 8 4 10 14 25 22

    public List<Node<T>> boundaries() {

        Set<Node<T>> boundaries = new LinkedHashSet<>();
        boundaries.add(root);

        Deque<Node<T>> nodes = new ArrayDeque<>();

        Node<T> node = root;
        while( (node = node.getLeft()) != null ) {
            nodes.addLast(node);
        }

        boundaries.addAll(nodes);

        nodes.addLast(root);
        while(!nodes.isEmpty()) {

            Node<T> first = nodes.peekFirst();

            Node<T> left = first.getLeft();
            if(left != null && !left.isVisited()) {
                nodes.addFirst(left);
                continue;
            }

            Node<T> right = first.getRight();
            if(right != null && !right.isVisited()) {
                nodes.addFirst(right);
                continue;
            }

            first.setVisited(true);

            if (left == null && right == null) {
                boundaries.add(first);
            }

            nodes.removeFirst();

        }


        node = root;
        while( (node = node.getRight()) != null ) {
               nodes.addFirst(node);
        }

        boundaries.addAll(nodes);

        return new ArrayList<>(boundaries);
    }
}
