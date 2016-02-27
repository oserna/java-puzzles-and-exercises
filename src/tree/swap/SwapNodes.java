package tree.swap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class SwapNodes {


	/**
	 * int[][] flatten = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12,13}, {14,15}};
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] flatten = new int[][]{{2, 3}, {4, -1}, {5, -1}, {6, -1}, {7, 8}, {-1,9}, {-1, -1}, {10, 11}, {-1, -1}, {-1, -1}, {-1, -1}};
        		
        System.out.println();
        Node build = build(flatten);
        printTree(build);
        
        System.out.println();
        Node swapped2 = swap(build, 2);
        printTree(swapped2);

        System.out.println();
        Node swapped4 = swap(swapped2, 4);
        printTree(swapped4);
		
	}
	
	
	private static Node swap(Node tree, int swap){
			
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(tree);
		
		tree.visited = true;
		
		while (!stack.isEmpty()) {
			
			Node topOfTheStack = stack.peek();
									 
			Node nextNotVisitedChildNode = getNextNotVisitedChildNode(topOfTheStack);
			if (nextNotVisitedChildNode != null) {				
				visit(nextNotVisitedChildNode, stack, swap);
				stack.push(nextNotVisitedChildNode);
				continue;
			}
			
			stack.pop();
			
		}
		
		return tree;
		
	}
	
	private static Node getNextNotVisitedChildNode(Node node){
		if (node.left != null && !node.left.visited) {
			return node.left;
		}
		if (node.right != null && !node.right.visited) {
			return node.right;
		}
		return null;
	}
	
	
	private static void visit(Node node, Deque<Node> stack, int swap){
		if ((swap-1) == stack.size()) {
			doSwap(node);
		}
		node.visited = true;
	}
	
	
	private static void doSwap(Node node) {
		Node left = node.left;
		Node right = node.right;
		node.left = right;
		node.right = left;
	}

	private static Node build(int [][] tree){
		
		Node root = new Node(1);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		        
        for (int [] pair : tree) {
			    
        	Node polled = queue.poll();
        	
    		polled.left  = pair[0] != -1 ? new Node(pair[0]) : null;
    		polled.right = pair[1] != -1 ? new Node(pair[1]) : null;        		
        	
        	if(polled.left != null){        		
        		polled.left.parent = polled;
        		queue.add(polled.left);
        	}
        	
        	if(polled.right != null){        		
        		polled.right.parent = polled;
        		queue.add(polled.right);
        	}
        	
		}
        	
		return root;

	}
	
	private static void printTree(Node node){
		if (node == null)
					return;
		
		printTree(node.left);
		System.out.print(" "+node.num);
		node.visited = false;
		printTree(node.right);
		
	}
	
	
    static class Node {
		Node right;
		Node left;
		Node parent;
		int num;
		boolean visited;

		public Node(int number) {
			left = null;
			right = null;
			parent = null;
			num = number;
		}

		public String toString() {
			return "" + num + ", L=(" + left + "), R=(" + right + ")";
			//return "" + num;
		}
	}

}
