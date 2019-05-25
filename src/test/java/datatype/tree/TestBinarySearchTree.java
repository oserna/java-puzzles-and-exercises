package datatype.tree;

import org.junit.Assert;
import org.junit.Test;


public class TestBinarySearchTree {



    @Test
    public void testAddJustRoot() {

            BinarySearchTree.add(6);
            Node tree = BinarySearchTree.tree();
            Assert.assertTrue(tree.getValue() == 6);

    }

    @Test
    public void testAddLeftNodeToRootNode() {

        BinarySearchTree.add(6);
        Node tree = BinarySearchTree.tree();
        Assert.assertTrue(tree.getValue() == 6);

    }
}
