package tree.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.Node;

/**
 * The tree is traversed in depth first
 * 
 * @author oserna
 *
 * @param <T>
 */

public class DepthFirstSearch<T> {
	
	/**
	 * Approach one, the stack size and the depth are the same number.
	 * @param root
	 */
	public void dfs(Node<T> root){
		
		//creates the stack
		Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
		stack.push(root);
		
		//mark as visited the root node
		root.setVisited(true);
		System.out.println(root);
		
		//iterates by the nodes
		while (!stack.isEmpty()) {
			
			//get the top of the satck but don't remove it yet
			Node<T> topOfTheStack = stack.peek();
									 
			//give the first child that hasn't been visited, if is a binary tree usuallu left, and right later
			Node<T> left = topOfTheStack.getLeft();
			if (left != null && !left.isVisited()) {
				left.setVisited(true);
				System.out.println(left);
				stack.push(left);
				continue;
			}
			 
			Node<T> right = topOfTheStack.getRight();
			if (right != null && !right.isVisited()) {
				right.setVisited(true);
				System.out.println(right);
				stack.push(right);
				continue;
			}
			
			//remove the top of the stack
			stack.pop();
			
		}
		
	}

	
	public void dfs2(Node<T> root){
		
		Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
						
			Node<T> pop = stack.pop();
			
			//if top is not marked as visited
			if (!pop.isVisited()) {
				
				//check for the finish condition if exists. If we want to traverse the whole tree it's not necessary
				
				//mark top as visited
				pop.setVisited(true);
				System.out.println(pop);

				//add top's neighbors to the stack
				if(pop.getRight()!=null) stack.push(pop.getRight());
				if(pop.getLeft()!=null) stack.push(pop.getLeft());
			}
			
		}
	}
	
	
}
