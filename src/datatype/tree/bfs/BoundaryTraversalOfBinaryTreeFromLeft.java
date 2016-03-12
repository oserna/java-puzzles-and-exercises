package datatype.tree.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.junit.Test;

import datatype.tree.utils.TreeUtils;
import datatype.tree.utils.TreeUtils.Node;

public class BoundaryTraversalOfBinaryTreeFromLeft {

	@Test
	public void test() {
	
		final Node bst = TreeUtils.getBST();
		
		TreeMap<Integer, List<Node>> map = new TreeMap<>();
		map.put(0, new ArrayList<Node>(){{add(bst);}});
		
		traverse(bst, map);
		
		List<Node> list = new ArrayList<>();
		
		NavigableMap<Integer, List<Node>> descendingMap = map.descendingMap();
		for (Integer level : descendingMap.keySet()) {
			List<Node> listByLevel = descendingMap.get(level);
			list.add(listByLevel.get(0));
		}
		
		list.remove(list.size()-1);
		
		for (Integer level : map.keySet()) {
			List<Node> listByLevel = map.get(level);
			list.add(listByLevel.get(listByLevel.size()-1));
		}
		
		for (Node node : list) {
			System.out.print(" "+node.getValue());
		}
		
		
	}

	private void traverse(Node bst, Map<Integer, List<Node>> map) {
		
		List<Node> nodesByLayer = new ArrayList<>();
		nodesByLayer.add(bst);
		
		int counter = 1;
		while (!nodesByLayer.isEmpty()) {
			
			List<Node> aux = new ArrayList<>();
			for (Node node : nodesByLayer) {
				
				Node left = node.getLeft();
				if(left != null) aux.add(left);
				
				Node right = node.getRight();
				if(right != null) aux.add(right);
			}
			
			if(!aux.isEmpty()){				
				map.put(counter, aux);
			}
			
			nodesByLayer = aux;
			counter++;
		}
		
	}

}
