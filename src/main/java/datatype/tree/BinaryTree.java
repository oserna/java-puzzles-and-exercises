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

        List<List<Node<T>>> layers = new ArrayList<>();

        Deque<Node<T>> nodes = new ArrayDeque<>();
        nodes.addLast(root);

        while(!nodes.isEmpty()) {

            List<Node<T>> layer = new ArrayList<>();

            for (int i = 0; i < nodes.size(); i++) {

                Node<T> first = nodes.removeFirst();

                Node<T> left = first.getLeft();
                Node<T> right = first.getRight();

                if (left != null) {
                    nodes.addLast(left);
                    layer.add(left);
                }

                if (right != null) {
                    nodes.addLast(right);
                    layer.add(right);
                }

            }

            layers.add(layer);

        }

        for (List<Node<T>> layer : layers) {
            boundaries.add(layer.get(0));
        }

        for (int i = layers.size(); i > 0; i--) {
            List<Node<T>> layer = layers.get(i - 1);
            boundaries.add(layer.get(layer.size()-1));
        }

        return new ArrayList<>(boundaries);
    }
}
