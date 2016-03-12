package datatype.tree.dfs;

import static org.junit.Assert.*;

import org.junit.Test;

import datatype.tree.utils.TreeUtils;
import datatype.tree.utils.TreeUtils.Node;

public class IsBalancedBinaryTree {

	/**
	 * En este caso estar balanceado es que la diferencia entre 
	 * el subarbol izqdo y el dcho sea 0
	 */
	@Test
	public void testIsBalancedBST() {
		Node bst = TreeUtils.getBST();
		int leftDepth = depth(bst.getLeft());
		int rightDepth = depth(bst.getRight());
		assertTrue(leftDepth == rightDepth);
		
		Node nodeInBST = TreeUtils.getNodeInBST(bst, 25);
 		Node tw1 = new Node(21, nodeInBST);
		nodeInBST.setLeft(tw1);

		leftDepth = depth(bst.getLeft());
		rightDepth = depth(bst.getRight());
		assertFalse(leftDepth == rightDepth);

		
	}
	
	//traverse the datatype.tree with a POST ORDER modification
	int depth(Node node){
		
		if(node == null)
			return 0;
		
		int leftDepth = depth(node.getLeft());
		
		int rightDepth = depth(node.getRight());
		
		if(leftDepth > rightDepth){
			return leftDepth + 1;
		}
		
		return rightDepth + 1;
	}
	
}
