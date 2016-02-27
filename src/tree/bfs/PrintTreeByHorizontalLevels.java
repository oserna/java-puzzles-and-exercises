package tree.bfs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import tree.utils.TreeUtils;
import tree.utils.TreeUtils.Node;

public class PrintTreeByHorizontalLevels {

	@Test
	public void test() {
		Node bst = TreeUtils.getBST();
		traverse(bst);
	}

	private void traverse(Node bst) {
		
		List<Node> nodesByLayer = new ArrayList<>();
		nodesByLayer.add(bst);
		
		while (!nodesByLayer.isEmpty()) {
			
			System.out.println(nodesByLayer);
			
			List<Node> aux = new ArrayList<>();
			for (Node node : nodesByLayer) {
				
				Node left = node.getLeft();
				if(left != null) aux.add(left);
				
				Node right = node.getRight();
				if(right != null) aux.add(right);
			}
			
			nodesByLayer = aux;
			
		}
		
		// TODO Auto-generated method stub
		
	}

}
