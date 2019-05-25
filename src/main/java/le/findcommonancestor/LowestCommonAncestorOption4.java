package le.findcommonancestor;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1) Create a Map<String, String[]> pointing from commits to its parents. The key in the Map is the commit and the value is its parents
 * 2) Once we have the previous Map we create a Set<String> containing the nodes we visit while traverse the datatype.tree up
 * 3) Create a Queue in order to traverse the datatype.tree via BFS from the two commits at the same time
 * 4) The first commit that we cannot add to the Set<String> of traversed commits will be the lowest common ancestor
 * 
 * @author oserna
 */
public class LowestCommonAncestorOption4 implements FindCommonAncestor{
	
	
	public String findCommmonAncestor(String[] commitHashes,String[][] parentsHashes, final String commitA, final String commitB){
    	
    	if(commitA == null || commitB == null) 
            throw new IllegalArgumentException();
    	    	
    	Map<String, String[]> commitToParents = commitToParents(commitHashes, parentsHashes);
    	
    	Set<String> traversed = new HashSet<String>();
    	
    	Queue<String> queue  = new ArrayDeque<String>();
    	queue.add(commitA);
    	queue.add(commitB);
    	
    	while(!queue.isEmpty()){
    		
    		String commit = queue.poll();
    		
    		if(!traversed.add(commit))
    			return commit;
    		
			for (String parent : commitToParents.get(commit)) {					
				queue.add(parent);				
			}
    	}
    	
    	return null;
    }
    
	private Map<String, String []> commitToParents(String[] commits, String[][] parents){
		Map<String, String[]> result  = new HashMap<String, String[]>();
		for (int i = 0; i < commits.length; i++) {
                        if (parents[i] != null) 
			  result.put(commits[i], parents[i]);
                        else
			  result.put(commits[i], new String[0]);
		}
		return result;
	}    

}
