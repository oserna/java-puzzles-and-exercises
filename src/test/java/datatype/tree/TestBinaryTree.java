package datatype.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestBinaryTree {


    /* Let us create following BT
             20
           /    \
         /       \
        8         22
      /  \        \
     4   12       25
        /  \
       10  14
     */

    //Expected: 20 8 4 10 14 25 22
    @Test
    public void testGetTreeBoundaries() {

        Node<Integer> twelve = new Node<>(12);
        twelve.setLeft(new Node<Integer>(10));
        twelve.setRight(new Node<Integer>(14));

        Node<Integer> eight = new Node<>(8);
        eight.setLeft(new Node<Integer>(4));
        eight.setRight(twelve);

        Node<Integer> twentytwo = new Node<>(22);
        twentytwo.setRight(new Node<Integer>(25));

        Node<Integer> twenty = new Node<>(20);
        twenty.setLeft(eight);
        twenty.setRight(twentytwo);

        BinaryTree<Integer> bt = new BinaryTree<>(twenty);

        List<Node<Integer>> list = bt.boundaries();

        List<Integer> expected = Arrays.asList(20, 8, 4, 10, 14, 25, 22);

        checkLists(list,expected);
    }

    private void checkLists(List<Node<Integer>> current, List<Integer> expected) {
        for (int i = 0; i < current.size(); i++) {
            Assert.assertTrue(current.get(i).getValue().equals(expected.get(i)));
        }
    }


}
