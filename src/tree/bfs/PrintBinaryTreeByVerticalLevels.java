package tree.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.Test;

public class PrintBinaryTreeByVerticalLevels {
	
	@Test
	public void test() {
		
		int [] array = new int[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> tree = makeBST(null, array);
		
		Map<Integer, List<Node<Integer>>> levels = traverseTree(tree);
		System.out.println(levels);
	}
	
	
	private Map<Integer, List<Node<Integer>>> traverseTree(final Node<Integer> node){
		
		node.vLevel = 0;
	
		Map<Integer, List<Node<Integer>>> levels = new TreeMap<>();
		levels.put(node.vLevel, new ArrayList<Node<Integer>>(){{add(node);}});
		
		Queue<Node<Integer>> queue = new ArrayDeque<>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			
			Node<Integer> poll = queue.poll();
			
			Node<java.lang.Integer> left = poll.left;
			if(left != null){				
				left.vLevel = poll.vLevel-1;
				organize(left, levels);
				queue.add(left);
			}
			
			Node<java.lang.Integer> right = poll.right;
			if (right != null) {				
				right.vLevel = poll.vLevel+1;
				organize(right, levels);
				queue.add(right);
			}
						
		}	
		
		return levels;
	}
	
	void organize(final Node<Integer> node, Map<Integer, List<Node<Integer>>> levels){
		if(levels.containsKey(node.vLevel)){
			levels.get(node.vLevel).add(node);
		}else{
			levels.put(node.vLevel, new ArrayList<Node<Integer>>(){{add(node);}});
		}
	}
	

	static class Node<Integer> {
		public int value;
		public int vLevel;
		public Node<Integer> left;
		public Node<Integer> right;
		public Node(int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return value+"";
		}
	}
	
	
	private static Node<Integer> makeBST(Node<Integer> parent, int [] array){
		
		int m = array.length / 2;
		Node<Integer> node = new Node<Integer>(array[m]);
		if(array.length <= 3){
			if(array.length == 3){
				node.left = new Node<Integer>(array[0]);
				node.right = new Node<Integer>(array[2]);
			}else if(array.length == 2){
				node.left = new Node<Integer>(array[0]);
			}
			return node;
		}
				
		Node<Integer> left =  makeBST(node, Arrays.copyOfRange(array, 0, m));
		Node<Integer> right = makeBST(node, Arrays.copyOfRange(array, m+1, array.length));
		node.left = left;
		node.right = right;
		
		return node;
	}

	
	
}
