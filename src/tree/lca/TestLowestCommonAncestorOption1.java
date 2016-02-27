package tree.lca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestLowestCommonAncestorOption1 {
	
	/**
	 * As we trace the two paths from both nodes up to the root, eventually it will merge into one single path. 
	 * The LCA is the exact first intersection node where both paths merged into a single path. 
	 * An easy solution is to use a hash table which records visited nodes as we trace both paths up to the root. 
	 * Once we reached the first node which is already marked as visited, we immediately return that node as the LCA.
	 * 
	 * 	  				A
	 * 					|
	 * 					B
	 * 				  /   \
	 *  	  		 C	   E
	 *  	 	     |     |
	 *  			 D	   F
	 *  			  \   /
	 *  				G
	 * 
	 */
	@Test
	public void testNormal() {
		
		String[] commits =    {"J",	      "I",   "H",   "G",       "F",   "E",   "D",   "C",   "B", "A"};
		String[][] parents = {{"G","I"}, {"H"}, {"E"}, {"F","D"}, {"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

		Assert.assertEquals("B", findCommmonAncestor(commits, parents, "D", "F")) ; //B
		Assert.assertEquals("B", findCommmonAncestor(commits, parents, "D", "E")) ; //B
		Assert.assertEquals("B", findCommmonAncestor(commits, parents, "E", "C")) ; //B
		Assert.assertEquals("A", findCommmonAncestor(commits, parents, "A", "B")) ; //A
		Assert.assertEquals("F", findCommmonAncestor(commits, parents, "G", "F")) ; //F
		Assert.assertEquals("E", findCommmonAncestor(commits, parents, "E", "H")) ; //E
		Assert.assertEquals("D", findCommmonAncestor(commits, parents, "G", "D")) ; //D
		Assert.assertEquals("E", findCommmonAncestor(commits, parents, "G", "E")) ; //E

	}

	/**
	                              F ----------- G
                                 /               \
                    A --- B --- C --- D --- E --- H --- L
                           \                           /
                            I -------- J--------------K 	 
	 */
	@Test
	public void testFail() {
		
		String[] commits =    {"L",        "K",   "J",  "I",  "H",        "G",  "F",  "E",  "D",   "C",   "B",  "A"};
		String[][] parents = {{"H", "K"}, {"J"}, {"I"},{"B"},{"E", "G"}, {"F"},{"C"},{"D"},{"C"}, {"B"}, {"A"}, null};

		Assert.assertEquals("B", findCommmonAncestor(commits, parents, "H", "K")) ; //B

	}
	
    private String findCommmonAncestor(String[] commits,String[][] parents, final String commitA, final String commitB){
    	return findCommmonAncestor(commits, parents, new HashSet<String>(){{
    		add(commitA);
    		add(commitB);
    	}});
    }
    
    private String findCommmonAncestor(String[] commits,String[][] parents, HashSet<String> currentParents){
    	
    	Map<String, Integer> visited = new HashMap<>();
        	
    	while(!currentParents.isEmpty()){

    		HashSet<String> nextParents = new HashSet<String>();

    		if (currentParents.size()==1) {
				return currentParents.iterator().next();
			}
    		
    		for (String parent : currentParents) {
    			
    			if(visited.containsKey(parent)){
    				int occurences = visited.get(parent) + 1;
    				if (occurences >= currentParents.size()) {
    					return parent;
    				}
    				visited.put(parent, visited.get(parent) + 1); 
    			}else{
    				visited.put(parent, 1);     				
    			}
    				
    			//get the new parents
				nextParents.addAll(getParents(commits, parents, parent));
			}

    		currentParents = nextParents;
    	}
    	return null;
    }
    
	
    private List<String> getParents(String[] commits,String[][] parents,String commit){
    	List<String> nextParents = new ArrayList<String>();
    	if (commit != null) {
    		int commitPosition = Arrays.asList(commits).indexOf(commit);
    		String [] commitParents = parents[commitPosition];
    		if(commitParents != null){
	    		for (String parent : commitParents) {
					if (parent != null) {
						nextParents.add(parent);
					}
				}
    		}
		}
    	return nextParents;
    }

}
