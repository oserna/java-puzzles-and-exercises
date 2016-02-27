package tree.flatten;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import tree.Node;


public class TestFlatten {

	@Test
	public void test() {
		Node<Integer> tree = createTree();
		List<Integer> flatten = flatten(tree);
		System.out.println(flatten);
	}
	
	private List<Integer> flatten(Node root){
		
		List<Integer> flatten = new ArrayList<Integer>();
		
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node<Integer> pop = stack.pop();
			if(!pop.isVisited()){
				
				flatten.add(pop.getValue());
				
				pop.setVisited(true);
				
				Node<Integer> right = pop.getRight();
				if(right!=null){					
					stack.push(right);
				}
				Node<Integer> left = pop.getLeft();
				if(left!=null){					
					stack.push(left);
				}
			}
		}
		
		return flatten;
		
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
		
		n1.addVertex(n2);
		n1.addVertex(n5);

		n2.addVertex(n3);
		n2.addVertex(n4);
		
		n5.addVertex(n6);
		
		return n1;
	}
	
}
