package datatype.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestBinarySearchTree {

    @Test
    public void testAddJustRoot() {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new Node<>(6),comparator);
        Assert.assertTrue(bst.tree().getValue().equals(6));

    }

    /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //In order: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    @Test
    public void testTraverseInOrderRecursive() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().inOrderRecursive();

        List<Integer> expected = Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        checkLists(current, expected);

    }

    /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //In order: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    @Test
    public void testTraverseInOrder() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().inOrder();

        List<Integer> expected = Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        checkLists(current, expected);

    }

    /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //Pre order: 7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10
    @Test
    public void testTraversePreOrder() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().preOrder();

        List<Integer> expected = Arrays.asList(7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10);

        checkLists(current, expected);
    }

        /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //Pre order: 7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10
    @Test
    public void testTraversePreOrderRecursive() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().preOrderRecursive();

        List<Integer> expected = Arrays.asList(7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10);

        checkLists(current, expected);
    }

    /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //Post order: 0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7
    @Test
    public void testTraversePostOrder() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().postOrder();

        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7);

        checkLists(current, expected);
    }

    /* Let us create following BST
              7
           /   \
          /     \
         /       \
        1         9
      /  \       / \
     0    3     8  10
        /  \
       2   5
         /  \
        4   6

     */

    //Post order: 0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7
    @Test
    public void testTraversePostOrderRecursive() {

        List<Node<Integer>> current = getIntegerBinarySearchTree().postOrderRecursive();

        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7);

        checkLists(current, expected);
    }

    private BinarySearchTree<Integer> getIntegerBinarySearchTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new Node<Integer>(7), comparator);
        bst.add(1);
        bst.add(9);
        bst.add(0);
        bst.add(3);
        bst.add(8);
        bst.add(10);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(6);
        return bst;
    }

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer v1, Integer v2) {
            return v1 < v2 ? -1 : v1 > v2 ? +1 : 0;
        }
    };

    private void checkLists(List<Node<Integer>> current, List<Integer> expected) {
        for (int i = 0; i < current.size(); i++) {
            Assert.assertTrue(current.get(i).getValue().equals(expected.get(i)));
        }
    }


}
