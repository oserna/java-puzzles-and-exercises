package le.findcommonancestor;

import org.junit.Assert;
import org.junit.Test;

public class TestSimpleLCA {

	@Test
	public void testFindCommonAncestor() {
		
		String[] commitHashes = {"G", "F", "E", "D", "C", "B", "A"};
		String[][] parentHashes ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}; 
				
		FindCommonAncestor findCommonAncestor = new LowestCommonAncestorOption4();
				
		Assert.assertEquals("B", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "D", "F"));
		Assert.assertEquals("B", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "E", "B"));
		Assert.assertEquals("A", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "A", "B"));
		Assert.assertEquals("D", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "G", "D"));
		Assert.assertEquals("E", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "G", "E"));
		Assert.assertEquals("A", findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, "A", "A"));
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFindCommonAncestorWithNullTree() {
		String[] commitHashes = {"G", "F", "E", "D", "C", "B", "A"};
		String[][] parentHashes ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}; 
				
		FindCommonAncestor findCommonAncestor = new LowestCommonAncestorOption4();
		findCommonAncestor.findCommmonAncestor(commitHashes, parentHashes, null, "A");
	}
	

}
