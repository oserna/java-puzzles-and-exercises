package datatype.tree.utils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeUtils {
	
	
	public Node insert (Node t, int toInsert){
	    if (t == null)
	      return new Node(toInsert,null);
	    else {
	      if (toInsert < t.value)
	         t.left  = insert(t.left, toInsert);
	      else
	         t.right = insert(t.right,toInsert);
	      return t;
	    }
	 }
	
	public static Node getBST() {

		Node twenty = new Node(20, null);

		Node eight = new Node(8, twenty);
		Node twentytwo = new Node(22, twenty);
		twenty.setLeft(eight);
		twenty.setRight(twentytwo);

		Node four = new Node(4, eight);
		Node twelve = new Node(12, eight);
		eight.setLeft(four);
		eight.setRight(twelve);

		Node ten = new Node(10, twelve);
		Node fourteen = new Node(14, twelve);
		twelve.setLeft(ten);
		twelve.setRight(fourteen);

		Node twentyseven = new Node(27, twentytwo);
		twentytwo.setRight(twentyseven);

		Node twentyfive = new Node(25, twentyseven);
		twentyseven.setLeft(twentyfive);

		return twenty;
	}
	
	public static Node getNodeInBST(Node node, int number) {

		while (number != node.getValue()) {

			if (number < node.getValue()) {
				node = node.getLeft();
				continue;
			}
			node = node.getRight();
		}

		return node;

	}
	
	public static class Node {
		int depth = 0;
		private int value;
		private Node parent;
		private Node left;
		private Node right;

		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		@Override
		public String toString() {
			return getValue()+"";
		}
		
		public int getDepth() {
			return depth;
		}
		
		public void incrementDepth(){
			
		}

	}

	
	/**
	 * Each row in the datatype.matrix define a relationship between a father (first column) and one of its children (second column).
	 * 
	 * Matrix example:
	 *  
	 *	[ 2 , 4 ] -> [parent, child]
     *	[ 1 , 2 ]
     *	[ 3 , 6 ]
     *	[ 1 , 3 ]
     *	[ 2 , 5 ]
     *
	 * The datatype.matrix above define this binary datatype.tree:
 	 *
     *            1
     *         2      3
     *       4   5  6
     *
     * int[][] datatype.matrix = new int[][]{{2, 4},{1, 2},{3, 6},{1, 3},{2, 5}	};
     *
	 */
	public static Map<Integer,Set<Integer>> fromParentAndChildrenPairsToMap(int [][] input){
	
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
		for (final int [] pair : input) {
			if (map.containsKey(pair[0])) {
				map.get(pair[0]).add(pair[1]);
				continue;
			}
			map.put(pair[0], new TreeSet<Integer>(){{add(pair[1]);}});
		}
		
		return map;

	}
	
	
	/**
	 * Each datatype.matrix row is a pair of siblings in the datatype.tree.
	 *   
	 * Matrix example:
	 * 
	 *   [  2 ,  3 ] -> [ sibling 1, sibling2 ]
	 *   [  4 ,  5 ]
	 *   [  6 ,  7 ]
	 *   [  8 ,  9 ]
	 *   [ 10 ,  11 ]
	 *   [ 12 ,  13 ]
	 *   [ 14 ,  15 ]
	 * 
	 *    			    1    
	 *   		   /         \  
	 *  		  2           3 
   	 *			 / \        /    \ 
     *	 		4   5      6      7
     *         / \ / \    / \    / \
     *        8  9 10 11 12 13  14 15
	 * 
	 * int[][] datatype.matrix = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15}};
	 */
	public static Map<Integer,Set<Integer>> fromSiblingPairsToMap(int [][] input){
		
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
		
		Queue<Integer> queue = new LinkedList<Integer>();

		for (final int[] row : input) {
			
			Integer polled = queue.poll();
			
			if(polled != null){				
				map.put(polled, new TreeSet<Integer>(){{
					add(row[0]);
					add(row[1]);
				}});
			}
			
			queue.add(row[0]);
			queue.add(row[1]);
								
		}
		
		return map;
			
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15}};
		Map<Integer, Set<Integer>> fromSiblingPairsToMap = fromSiblingPairsToMap(matrix);
		System.out.println(fromSiblingPairsToMap);
	}

}
