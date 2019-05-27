package datatype.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;


public class TestBinarySearchTree {

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer v1, Integer v2) {
            return v1 < v2 ? -1 : v1 > v2 ? +1 : 0;
        }
    };



    @Test
    public void testAddJustRoot() {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);
        bst.add(6);
        Assert.assertTrue(bst.tree().getValue().equals(6));
    }

    /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
    @Test
    public void testTraversePreOrder() {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        Node<Integer> node = bst.tree();

        final ArrayDeque<Node<Integer>> nodes = new ArrayDeque<>();
        nodes.addFirst(node);

        while (nodes.size() > 0) {

            Node<Integer> first = nodes.peekFirst();

            if (first.getLeft() != null) {

                nodes.addFirst(first.getLeft());

                continue;
            }

            System.out.println(first.getValue());


            if (first.getRight() != null) {

                nodes.addFirst(first.getRight());

                continue;
            }

            nodes.removeFirst();

        }


    }


}
