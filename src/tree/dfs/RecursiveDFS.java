package tree.dfs;

import tree.utils.TreeUtils;
import tree.utils.TreeUtils.Node;


public class RecursiveDFS {
	
	public static void main(String[] args) {
		recursive(TreeUtils.getBST());		
	}
	
	static void recursive(Node node){
		
		if(node == null)
			return;	

		//PRE-ORDER -> System.out.print(node.getValue()+" ");
		
		recursive(node.getLeft());		

		//IN-ORDER -> System.out.print(node.getValue()+" ");

		recursive(node.getRight());
		
		//POST-ORDER -> System.out.print(node.getValue()+" ");
		
	}
	
}
