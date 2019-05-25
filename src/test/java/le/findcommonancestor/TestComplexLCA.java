package le.findcommonancestor;

import org.junit.Assert;
import org.junit.Test;

public class TestComplexLCA {


	/**
	 * 	A---->B---->C---->D---->G---->J
	 *  	  \			 	   /     /
	 *			E------------>F	    /
	 *			 \ 				   /
	 * 			  H-------------->I
	 */
	@Test
	public void testCommitsNewTreeNotNested() {
		
		String[] testCommits =    {"J",	      "I",   "H",   "G",       "F",   "E",   "D",   "C",   "B", "A"};
		String[][] testParents = {{"G","I"}, {"H"}, {"E"}, {"F","D"}, {"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		
		FindCommonAncestor finder = new LowestCommonAncestorOption4();
		
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "D", "F")) ; 
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "D", "E")) ; 
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "E", "C")) ; 
		Assert.assertEquals("E", finder.findCommmonAncestor(testCommits, testParents, "F", "H")) ; 
		Assert.assertEquals("E", finder.findCommmonAncestor(testCommits, testParents, "F", "I")) ; 		
		Assert.assertEquals("E", finder.findCommmonAncestor(testCommits, testParents, "I", "G")) ; 
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "I", "D")) ; 
		
	}
	
	
	/**
	 * 	A---->B---->C---->D---->G---->J
	 *  	  \			 	   /     /
	 *			E------------>F	    /
	 *			 \ 				   /
	 * 			  H-------------->I
	 */
	@Test
	public void testCommitsNewTreeNested() {
		
		String[] testCommits =    {"J",	      "I",   "H",   "G",       "F",   "E",   "D",   "C",   "B", "A"};
		String[][] testParents = {{"G","I"}, {"H"}, {"E"}, {"F","D"}, {"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		
		FindCommonAncestor finder = new LowestCommonAncestorOption4();
		
		
		Assert.assertEquals("A", finder.findCommmonAncestor(testCommits, testParents, "B", "A")) ; 
		Assert.assertEquals("D", finder.findCommmonAncestor(testCommits, testParents, "G", "D")) ; 
		Assert.assertEquals("F", finder.findCommmonAncestor(testCommits, testParents, "G", "F")) ; 
		Assert.assertEquals("E", finder.findCommmonAncestor(testCommits, testParents, "E", "H")) ; 
		
		Assert.assertEquals("F", finder.findCommmonAncestor(testCommits, testParents, "J", "F")) ; 
		Assert.assertEquals("I", finder.findCommmonAncestor(testCommits, testParents, "J", "I")) ; 
		Assert.assertEquals("I", finder.findCommmonAncestor(testCommits, testParents, "I", "J")) ; 
		Assert.assertEquals("G", finder.findCommmonAncestor(testCommits, testParents, "J", "G")) ; 
		
	}
	
	
	/**
	 * 	A---->B---->C---->D---->G
	 *  	  \			 	   /    
	 *			E------------>F	
	 */	
	@Test
	public void testCommitsNotNested() {
		
		String[] testCommits =    {"G",      "F",   "E",   "D",   "C",   "B", "A"};
		String[][] testParents = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		
		FindCommonAncestor finder = new LowestCommonAncestorOption4();
		
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "D", "F")) ; //B
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "D", "E")) ; //B
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "E", "C")) ; //B
		Assert.assertEquals("A", finder.findCommmonAncestor(testCommits, testParents, "B", "A")) ; //A
		
	}
	
	/**
	 * 	A---->B---->C---->D---->G
	 *  	  \			 	   /    
	 *			E------------>F	
	 */	
	@Test
	public void testOneIsTheCommonAncestor(){
		String[] testCommits =    {"G",      "F",   "E",   "D",   "C",   "B", "A"};
		String[][] testParents = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		
		FindCommonAncestor finder = new LowestCommonAncestorOption4();
		Assert.assertEquals("B", finder.findCommmonAncestor(testCommits, testParents, "B", "D")) ; //B
		
	}
	

	/**
	 * 	A---->B---->C---->D---->G
	 *  	  \			 	   /    
	 *			E------------>F	
	 */	
	@Test
	public void testOneIsTheCommonAncestorWithMerge(){
		String[] testCommits =    {"G",      "F",   "E",   "D",   "C",   "B", "A"};
		String[][] testParents = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
	
		FindCommonAncestor finder = new LowestCommonAncestorOption4();
		Assert.assertEquals("D", finder.findCommmonAncestor(testCommits, testParents, "G", "D")) ; //B
		
	}
	


}
