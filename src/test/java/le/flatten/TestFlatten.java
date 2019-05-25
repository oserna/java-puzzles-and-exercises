package le.flatten;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestFlatten {

	@Test
	public void test() {
		Tree<Integer> nodes = Tree.Node.tree(2, 3, 4);
		
        Tree<Integer> root = new Tree.Node<Integer>(Tree.Leaf.leaf(1), nodes, Tree.Leaf.leaf(5));
        
        MyFlattenTree<Integer> myFlattenTreeImpl = new MyFlattenTree<Integer>();
		List<Integer> flattenInOrder = myFlattenTreeImpl.flattenInOrder(root);
		
		Assert.assertEquals(new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}}, flattenInOrder);

	}

}
