package datatype.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


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
    public void testTraverseInOrder() {


        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        List<Node<Integer>> inOrder = bst.preOrder();

        List<Integer> expected = Arrays.asList(20,30,40,50,60, 70,80);

        for (int i = 0; i < inOrder.size(); i++) {
            Assert.assertTrue(inOrder.get(i).getValue().equals(expected.get(i)));
        }

    }

}
