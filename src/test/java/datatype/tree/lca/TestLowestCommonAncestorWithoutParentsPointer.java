package datatype.tree.lca;

import org.junit.Test;

import datatype.tree.utils.Node;

public class TestLowestCommonAncestorWithoutParentsPointer {

	
	
	
	@Test
	public void test() {
		Node<Integer> createTree2 = createTree2();
		Node<Integer> lowestCommonAncestor = lowestCommonAncestor(createTree2, new Node<Integer>(6), new Node<Integer>(4));
		System.out.println(lowestCommonAncestor);
	}

	public Node<Integer> lowestCommonAncestor(Node<Integer> root, 
												Node<Integer> a, 
													Node<Integer> b) {

		if (root == null) {
	        return null;
	    }
	    
	    if (root.equals(a) || root.equals(b)) { 
	        // if at least one matched, no need to continue
	        // this is the LCA for this root
	        return root;
	    }
	 
	    
	    Node<Integer> l = lowestCommonAncestor(root.getLeft(), a, b);
	    Node<Integer> r = lowestCommonAncestor(root.getRight(), a, b);
	 
	    if (l != null && r != null) {
	    	return root;  // nodes are each on a seaparate branch
	    }
	 
	    // either one node is on one branch, 
	    // or none was found in any of the branches
	    return l != null ? l : r;
		
	}
	
	
	private Node<Integer> createTree2() {

		Node<Integer> n0 = new Node<Integer>(0);
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n8 = new Node<Integer>(8);
		Node<Integer> n9 = new Node<Integer>(9);
		Node<Integer> n10 = new Node<Integer>(10);
		Node<Integer> n11 = new Node<Integer>(11);
		
		n3.addVertex(n5);
		n3.addVertex(n1);

		n2.addVertex(n7);
		n2.addVertex(n4);

		n5.addVertex(n6);
		n5.addVertex(n2);
		
		n1.addVertex(n0);
		n1.addVertex(n8);
				
		return n3;
	}


}
