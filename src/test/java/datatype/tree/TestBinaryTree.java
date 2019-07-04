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

    /*
        Ex 2: the top view of the below binary tree is B A C F:

          A
        /   \
       B     C
         \
          D
           \
            E
             \
              F
     */
    @Test
    public void testTopView(){

        Node<String> a = new Node<>("A");
        a.setRight(new Node<String>("C"));

        Node<String> b = new Node<>("B");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");

        a.setLeft(b);
        b.setRight(d);
        d.setRight(e);
        e.setRight(f);

        BinaryTree<String> bt = new BinaryTree<>(a);

        List<Node<String>> list = bt.topView();

        List<String> expected = Arrays.asList("B", "A", "C", "F");

        checkLists(list,expected);

    }

    private <T> void checkLists(List<Node<T>> current, List<T> expected) {
        for (int i = 0; i < current.size(); i++) {
            Assert.assertTrue(current.get(i).getValue().equals(expected.get(i)));
        }
    }


}
