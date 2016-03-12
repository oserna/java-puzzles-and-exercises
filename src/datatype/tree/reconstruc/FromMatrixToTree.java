package datatype.tree.reconstruc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

import datatype.tree.Node;


/**
 * The idea is:
 * 
 * 1) create a map with parents as keys and a list for each parent children: 
 * 		Parent -> [Child, Child]
 * 
 * 2) locate the root node: in order to do that we define a Set containing all the children so the parent that won´t be in that Set is the root node
 * 
 * 3) compose the tree using a Queue 
 * 
 * 4) traverse the tree in order to see that is OK
 *  
 * @author oserna
 *
 */
public class FromMatrixToTree {

	@Test
	public void test() {
		
		int[][] matrix = new int[][]{{2, 4},{1, 2},{3, 6},{1, 3},{2, 5}	};
		
		Node<Integer> tree = reconstructTree(matrix);
		
		traverse(tree);
		
	}

	private Node<Integer> reconstructTree(int[][] matrix) {
		
		Set<Integer> childrens = new HashSet<>();
		Map<Integer,List<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < matrix.length; i++) {
			int[] js = matrix[i];
			if (map.containsKey(js[0])) {
				List<Integer> list = map.get(js[0]);
				list.add(js[1]);
				childrens.add(js[1]);
			}else{
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(js[1]);
				
				map.put(js[0], arrayList);
				
				childrens.add(js[1]);
			}
		}
		
		Node<Integer> root = null;
		for (Integer father : map.keySet()) {
			if (!childrens.contains(father)){
				root = new Node<Integer>(father);
			}
		}
		
		Queue<Node<Integer>> queue = new ArrayDeque<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			Node<Integer> current = queue.poll();

			Node<Integer> left = null;			
			Node<Integer> right = null;

			if(map.containsKey(current.getValue())){
				List<Integer> children = map.get(current.getValue());

				left = new Node<Integer>(children.get(0));
				current.setLeft(left);

				if (children.size() > 1) {
					right = new Node<Integer>(children.get(1));
					current.setRight(right);
				}
			}
			
			if (left != null) {
				queue.add(left);
			}
			
			if (right != null) {
				queue.add(right);
			}
			
		}
		
		return root;
	}
	
	
	public void traverse(Node<Integer> root){
		if (root == null) {
			return;
		} else {
			
			traverse(root.getLeft());
			
			System.out.println(root.getValue());
			
			traverse(root.getRight());
		}
		
	}
	
}
