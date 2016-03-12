package datatype.tree.dfs;

import static org.junit.Assert.*;

import org.junit.Test;

import datatype.tree.utils.TreeUtils;
import datatype.tree.utils.TreeUtils.Node;

public class DepthOfBinaryTree {

	@Test
	public void testDepth() {
		
		Node bst = TreeUtils.getBST();
		assertTrue(depth(bst) == 4);
		
	}
	
	private int depth(Node node){
		
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
