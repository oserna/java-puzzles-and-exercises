package tree.bfs;

import org.junit.Test;

import tree.Node;


public class TestBreadthFirstSearch {

	@Test
	public void test() {
		Node<String> tree = createTree();
		BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
		bfs.bfsTraverse(tree, new Criteria<Node<String>>(){
			@Override
			public boolean match(Node<String> node) {
				System.out.println(node.getValue());
				return false;
		}});
	}
	
	private Node<Integer> createTree2() {

		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n0 = new Node<Integer>(0);
		Node<Integer> n8 = new Node<Integer>(8);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n4 = new Node<Integer>(4);
		
		n3.addVertex(n5);
		n3.addVertex(n1);

		n5.addVertex(n6);
		n5.addVertex(n2);
		
		n2.addVertex(n7);
		n2.addVertex(n4);
		
		n1.addVertex(n0);
		n1.addVertex(n8);
		
		return n3;
	}
	
	private Node<String> createTree() {

		Node<String> n1 = new Node<String>("A");
		Node<String> n2 = new Node<String>("B");
		Node<String> n3 = new Node<String>("I");
		Node<String> n4 = new Node<String>("E");
		Node<String> n5 = new Node<String>("F");
		Node<String> n6 = new Node<String>("G");
		Node<String> n7 = new Node<String>("C");
		Node<String> n8 = new Node<String>("D");
		Node<String> n9 = new Node<String>("H");
		
		n1.addVertex(n2);
		n1.addVertex(n3);
				
		n2.addVertex(n1);
		n2.addVertex(n5);
				
		n3.addVertex(n1);
		n3.addVertex(n4);
		n3.addVertex(n5);
				
		n4.addVertex(n3);
		n4.addVertex(n5);
		
		n5.addVertex(n3);
		n5.addVertex(n4);
		n5.addVertex(n2);
		n5.addVertex(n6);

		n6.addVertex(n5);
		n6.addVertex(n7);
		n6.addVertex(n9);

		n7.addVertex(n6);
		n7.addVertex(n9);
		n7.addVertex(n8);

		n8.addVertex(n6);

		n9.addVertex(n7);
		n9.addVertex(n6);

		return n1;
		
	}
}
