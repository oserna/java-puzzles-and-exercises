package datatype.tree;

import org.junit.Assert;
import org.junit.Test;


public class TestBST {

        @Test
        public void testSomething() {

                BST.add(6);
                Node tree = BST.tree();
                Assert.assertTrue(tree.getValue() == 6);

                
        }
}
