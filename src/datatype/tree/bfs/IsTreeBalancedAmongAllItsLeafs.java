package datatype.tree.bfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import datatype.tree.utils.TreeUtils;
import datatype.tree.utils.TreeUtils.Node;

public class IsTreeBalancedAmongAllItsLeafs {

	@Test
	public void test() {
		Node bst = TreeUtils.getBST();
		boolean balancedAmongAllLeafs = isBalancedAmongAllLeafs(bst);
		System.out.println(balancedAmongAllLeafs);
	}

	private boolean isBalancedAmongAllLeafs(Node bst) {
		
		int minDepth = Integer.MAX_VALUE;
		int maxDepth = Integer.MIN_VALUE;
		
		List<Node> nodesByLayer = new ArrayList<>();
		nodesByLayer.add(bst);
		
		int depth = 1;
		while (!nodesByLayer.isEmpty()) {
			
			System.out.println(nodesByLayer);
			
			List<Node> aux = new ArrayList<>();
			for (Node node : nodesByLayer) {
				
				Node left = node.getLeft();
				Node right = node.getRight();
				if(left == null && right == null){
					if(depth < minDepth){
						minDepth = depth;
					}
					if(depth > maxDepth){
						maxDepth = depth;
					}
				}
				if(left != null) aux.add(left);
				
				if(right != null) aux.add(right);
			}
			
			nodesByLayer = aux;
			depth++;
		}

		return maxDepth - minDepth <= 1;
		
	}
		
}
