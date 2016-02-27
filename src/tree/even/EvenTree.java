package tree.even;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description:
 * You are given a tree (a simple connected graph with no cycles). 
 * You have to remove as many edges from the tree as possible to obtain a forest with the condition that :
 *  Each connected component of the forest should contain an even number of vertices.
 * To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.
 * 
 * Challenge:
 * https://www.hackerrank.com/challenges/even-tree
 * 
 * Solutions:
 * http://stackoverflow.com/questions/12043252/obtain-forest-out-of-tree-with-even-number-of-nodes
 * http://stackoverflow.com/questions/15873153/explanation-of-algorithm-for-finding-articulation-points-or-cut-vertices-of-a-gr
 * http://math.stackexchange.com/questions/994677/convert-a-tree-to-a-forest-where-every-component-has-an-even-number-of-vertices
 * https://sisijava.wordpress.com/2014/07/27/hackerrank-even-tree/
 * 
 * @author oserna
 *
 */
public class EvenTree {

	public static void main(String [] args) {
		 
		  int [][] matrix ={{2, 1},
							{3, 1},
							{4, 3},
							{5, 2},
							{6, 1},
							{7, 2},
							{8, 6},
							{9, 8},
							{10,8}};
		  
		   /**
		    * Creates the Map of children pointing their parents
		    * Key
		    */
			Map<Integer, Set<Integer>> adjacents = new TreeMap();
			for (int i = 0; i < matrix.length; i++) {
				final int[] childToParent = matrix[i];
				if (!adjacents.containsKey(childToParent[1])) {
					adjacents.put(childToParent[1], new TreeSet<Integer>() {{
							add(childToParent[0]);
						}});
					continue;
				}
				adjacents.get(childToParent[1]).add(childToParent[0]);
			}

			/**
			 * Total children by branch
			 */
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> childrenCount = new ArrayList<>();
			for (Integer parent : adjacents.keySet()) {
			
				int totalChildren = 0;

				Set<Integer> children = adjacents.get(parent);
				queue.addAll(children);
				totalChildren = totalChildren + children.size();
				
				while (!queue.isEmpty()) {
					Integer child = queue.poll();
					Set<Integer> transitiveChildrens = adjacents.get(child);
					if (transitiveChildrens!=null) {
						queue.addAll(transitiveChildrens);						
						totalChildren = totalChildren + transitiveChildrens.size();
					}
				}
				
				childrenCount.add(totalChildren + 1);
			}
			
			/**
			 * Only if there are even number of children in a branch it is possible to remove the edge and the forest will have even number of edges 
			 */
			int remove = 0;
	        for(int c : childrenCount){
	            if(c % 2 == 0)
	                remove++;
	        }
	        
	        System.out.println("We can remove: "+(remove-1)+" edges");		
	}
	
}
