package tree.lca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import tree.Node;

public class TestLowestCommonAncestorOption2 {
	
	/**
	 * Add all parents (up to root) of commit A into HashSet
	 * Traverse from commit B up to root and check in each step if the previous calculated HashSet contains the current commit 
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
	public void test() {
		
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
	
    public String findCommmonAncestor(String[] commits,String[][] parents, final String commitA, final String commitB){
    	
    	Set<String> ancestorsA = collectCommmonAncestors(commits, parents, commitA);
    	return findCommmonAncestor(commits, parents, ancestorsA, commitB);
    }
    
    /**
     * BFS
     * @param commits
     * @param parents
     * @param visited
     * @param commit
     * @return
     */
    
    private String findCommmonAncestor(String[] commits,String[][] parents, Set<String> visited, final String commit){
    	
    	Set<String> pathToRoot = new LinkedHashSet<>();
  	
		// creates the queue and put the first commit on it
		Queue<String> queue = new LinkedList<String>(){{
			add(commit);
		}};

		while (!queue.isEmpty()) {

			// dequeue the current commit
			String current = queue.poll();

			// set current as visited
			pathToRoot.add(current);
			
			if(visited.contains(current)){
				return current;
			}
			
			for (String parent : getParents(commits, parents, current)) {
				if (pathToRoot.contains(parent))
					continue;
				queue.add(parent);
			}

		}

		// There is no Node<T> who match with the current criteria
		return null;

    }
    
    
    private Set<String> collectCommmonAncestors(String[] commits,String[][] parents, final String commit){
    	
    	Set<String> visited = new LinkedHashSet<String>();
    	List<String> currentParents = new ArrayList<String>(){{add(commit);}}; 
    	while(!currentParents.isEmpty()){
    		List<String> nextParents = new ArrayList<String>();
    		for (String parent : currentParents) {				
    			visited.add(parent);
    			String[] nextParentArray = getParents(commits, parents, parent);
    			if (nextParentArray != null) {					
    				nextParents.addAll(Arrays.asList(nextParentArray));
				}
			}
    		currentParents = nextParents;
    	}
    	return visited;
    }
    	
    private String [] getParents(String[] commits,String[][] parents,String commit){
    	if (commit != null) {
    		int commitPosition = Arrays.asList(commits).indexOf(commit);
    		String [] commitParents = parents[commitPosition];
    		if (commitParents != null && commitParents.length>0) {
				return  commitParents;
			}
		}
    	return null;
    }
    
}
