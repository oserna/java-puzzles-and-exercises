package tree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import tree.utils.TreeUtils;
import tree.utils.TreeUtils.Node;

public class FromSortedArrayToBST {

	@Test
	public void test() {
		
		int [] array = new int []{1, 2, 3, 4, 5, 6};
		
		Node make = make(null, array);
			
	}
	
	
	private Node make(Node parent, int [] array){
		
		int m = array.length / 2;
		Node node = new Node(array[m],parent);
		if(array.length <= 3){
			if(array.length == 3){
				node.setLeft(new Node(array[0], node));
				node.setRight(new Node(array[2], node));
			}else if(array.length == 2){
				node.setLeft(new Node(array[0], node));
			}
			return node;
		}
				
		Node left =  make(node, Arrays.copyOfRange(array, 0, m));
		Node right = make(node, Arrays.copyOfRange(array, m+1, array.length));
		node.setLeft(left);
		node.setRight(right);
		
		return node;
	}

}
