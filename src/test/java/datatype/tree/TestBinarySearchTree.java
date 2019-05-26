package datatype.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;


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

}
