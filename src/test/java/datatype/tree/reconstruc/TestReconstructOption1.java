package datatype.tree.reconstruc;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import datatype.tree.utils.Node;

public class TestReconstructOption1 {

	/**
	 * 
	[2, 4]
    [1, 2]
    [3, 6]
    [1, 3]
    [2, 5]

	Use it to reconstruct this binary datatype.tree:
 
                 1
              2      3
           4   5  6
	 */
	@Test
	public void test() {
		
		int[][] matrix = new int[][]{{2, 4},{1, 2},{3, 6},{1, 3},{2, 5}	};
		
		Node<Integer> tree = reconstructTree(matrix);
		
		traverse(tree);
	}
	
	private Node reconstructTree(int[][] input) {
	
		TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
		for (final int [] pair : input) {
			if (map.containsKey(pair[0])) {
				map.get(pair[0]).add(pair[1]);
				continue;
			}
			map.put(pair[0], new TreeSet(){{add(pair[1]);}});
		}
		
		Queue<Node<Integer>> queue = new LinkedList<>();
		
		Entry<Integer, Set<Integer>> next = map.entrySet().iterator().next();
		Node<Integer> rootNode = new Node<Integer>(next.getKey());
		queue.add(rootNode);
		
		while(!queue.isEmpty()){
			Node<Integer> polled = queue.poll();
			Set<Integer> set = map.get(polled.getValue());
			if(set != null){				
				for (Integer child : set) {
					Node<Integer> childNode = new Node<Integer>(child);
					polled.getVertices().add(childNode);
					queue.add(childNode);
				}
			}
		}
		
		return rootNode;
	}

	private void traverse(Node<Integer> node){
		System.out.println(node.getValue());
		for(Node<Integer> child : node.getVertices()){
			traverse(child);
		}
	}
}
