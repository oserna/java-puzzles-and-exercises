package tree.pathbetweennodes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;



public class PathBetweenNodes {
	

	public void path(Node from, Node to){
	
		Set<Node> path = new HashSet<>();
		
		// creates the queue
		Queue<Node> queue = new ArrayDeque<>();

		// put the origin Node<T> on the queue
		queue.add(to);

		while (!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			node.visited = true;
			
			if (!node.right.visited) {
				queue.add(node.right);
			}
			if (!node.left.visited) {
				queue.add(node.left);
			}
			
		}
		
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
