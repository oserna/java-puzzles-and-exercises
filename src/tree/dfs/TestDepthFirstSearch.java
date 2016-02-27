package tree.dfs;

import org.junit.Test;

import tree.Node;


public class TestDepthFirstSearch {

	@Test
	public void test() {
		DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
		
		System.out.println("-------------------------------------");
		Node<Integer> tree = createTree();
		dfs.dfs(tree);

		System.out.println("-------------------------------------");
		tree = createTree();
		
		dfs.dfs2(tree);
		
	}
	
	private Node<Integer> createTree() {
		
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
		
		n1.setLeft(n2);
		n1.setRight(n3);

		n2.setLeft(n4);
		
		n4.setLeft(n6);
		
		n6.setLeft(n9);
		
		n3.setLeft(n5);
		
		n5.setLeft(n7);
		n5.setRight(n8);
		
		n8.setLeft(n10);
		n8.setRight(n11);
		
		return n1;
	}
	
	}
