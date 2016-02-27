package tree.dfs;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import tree.utils.TreeUtils;
import tree.utils.TreeUtils.Node;

public class LCABinaryTree {

	@Test
	public void testFindCommonAncestorGoingDown() {
		
		Node bst = TreeUtils.getBST();
		Node lca = findCommonAncestorByBST(bst, 4, 14);
		assertTrue(lca.getValue() == 8);
	}
	
	@Test
	public void testFindCommonAncestorGoingUp() {
		
		Node bst = TreeUtils.getBST();
		
		Node nodeA = TreeUtils.getNodeInBST(bst, 4);
		Node nodeB = TreeUtils.getNodeInBST(bst, 14);
		Node lca = findCommonAncestorGoingUp(bst, nodeA, nodeB);
		assertTrue(lca.getValue() == 8);
		
		nodeA = TreeUtils.getNodeInBST(bst, 4);
		nodeB = TreeUtils.getNodeInBST(bst, 25);
		lca = findCommonAncestorGoingUp(bst, nodeA, nodeB);
		assertTrue(lca.getValue() == 20);
		
		nodeA = TreeUtils.getNodeInBST(bst, 27);
		nodeB = TreeUtils.getNodeInBST(bst, 25);
		lca = findCommonAncestorGoingUp(bst, nodeA, nodeB);
		assertTrue(lca.getValue() == 27);
	}
	
	private Node findCommonAncestorByBST(Node root, int a, int b){

		if(root == null)
			return null;
		
		if(root.getValue() == a || root.getValue() == b){
			return root;
		}
		
		Node left = findCommonAncestorByBST(root.getLeft(), a, b);
		Node right = findCommonAncestorByBST(root.getRight(), a, b);
		
		if(left != null && right != null){
			return root;
		}
		
		return left != null ? left : right;
		
	}

	
	private Node findCommonAncestorGoingUp(Node root, Node a, Node b){
		
		Set<Node> nodes = new HashSet<>();
		nodes.add(a);
		nodes.add(b);

		Node parentA = a.getParent();
		Node parentB = b.getParent();
		while(parentA != null || parentB != null){
			if (parentA != null && !nodes.add(parentA)) {
				return parentA;
			}
			if (parentB != null && !nodes.add(parentB)) {
				return parentB;
			}
			parentA = parentA.getParent();
			parentB = parentB.getParent();
		}
		
		return null;
	}
	

}
