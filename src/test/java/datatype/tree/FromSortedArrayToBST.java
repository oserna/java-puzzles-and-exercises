package datatype.tree;

import java.util.Arrays;

import org.junit.Test;

public class FromSortedArrayToBST {

	@Test
	public void test() {
		
		int [] array = new int []{1, 2, 3, 4, 5, 6};
		
//		datatype.tree.utils.Node make = make(null, array);
			
	}

	//TODO solve
	
//	private datatype.tree.utils.Node make(datatype.tree.utils.Node parent, int [] array){
//
//		int m = array.length / 2;
//		datatype.tree.utils.Node node = new datatype.tree.utils.Node(array[m],parent);
//		if(array.length <= 3){
//			if(array.length == 3){
//				node.setLeft(new datatype.tree.utils.Node(array[0], node));
//				node.setRight(new datatype.tree.utils.Node(array[2], node));
//			}else if(array.length == 2){
//				node.setLeft(new datatype.tree.utils.Node(array[0], node));
//			}
//			return node;
//		}
//
//		datatype.tree.utils.Node left =  make(node, Arrays.copyOfRange(array, 0, m));
//		Node right = make(node, Arrays.copyOfRange(array, m+1, array.length));
//		node.setLeft(left);
//		node.setRight(right);
//
//		return node;
//	}

}
