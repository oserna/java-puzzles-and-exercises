package le.findcommonancestor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * REQUEST:
 * 
 * Given list of git commits in order from latest to first and their corresponding parents
 * if a commit has two parents, it is a merge commit. 
 * Find least common ancestor of two given commits also called merge base, which is an ancestor that is closest to both given commits.
 * 
 * SOLUTION:
 * For each Node, recursively traverse the tree upwards until you hit the root. 
 * At each parent node, insert the node into a list. 
 * This should give you list_a and list_b. 
 * Iterate over the shortest list, comparing elements from each list. 
 * When you find one that doesn't match, the previous entry is your largest parent element
 * 
 * @author oserna
 *
 *    {"G",       "F",   "E",   "D",   "C",   "B" , "A"};
      {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

 *
 */
public class MyFindCommonAncestor_v2 implements FindCommonAncestor
{

    public String findCommmonAncestor(String[] commits,String[][] parents, String commitA, String commitB){
    	
    	if(commitA == null || commitB == null) 
            throw new IllegalArgumentException();
    	
    	if(commitA.equals(commitB)) return commitA;
    	
    	if(isParent(commits, parents, commitA, commitB)) return commitB;
    	if(isParent(commits, parents, commitB, commitA)) return commitA;
    	
    	Set<String> ancestorsA = findAncestors(commits, parents, commitA);
    	Set<String> ancestorsB = findAncestors(commits, parents, commitB);
    	
    	return findCommonAncestors(ancestorsA, ancestorsB);
    }


	private boolean isParent(String[] commits, String[][] parents, String commitChild, String commitParent) {
		String[] parentsA = getParents(commits, parents, commitChild);
    	for (int i = 0; i < parentsA.length; i++) {
			String string = parentsA[i];
			if (string.equals(commitParent)) {
				return true;
			}
		}
    	return false;
	}   
    

    private String findCommonAncestors(Set<String> ancestorsA, Set<String> ancestorsB) {
    	Set<String> longer = ancestorsA;
    	Set<String> lesser = ancestorsB;
    	if (ancestorsA.size() < ancestorsB.size()) {
    		longer = ancestorsB;
			lesser = ancestorsA;
		}
    	for (String commit : lesser) {
			if (longer.contains(commit)) {
				return commit;
			}
		}
    	return null;
    }


	private Set<String> findAncestors(String[] commits,String[][] parents, String commit){
    	Visitor visitor = new Visitor();
    	traverse(commits, parents, new String[]{commit}, visitor);
    	return visitor.getPathToRoot();
    }

    
	private void traverse(String[] commits, String[][] parents, String [] commitPath, Visitor visitor) {
		String[] parentsCommits = getParents(commits, parents, commitPath[commitPath.length-1]);
		if(parentsCommits != null){			
			for (String parentCommit : parentsCommits) {
				String[] newPath = Arrays.copyOf(commitPath, commitPath.length+1);
				newPath[newPath.length - 1] = parentCommit;
				traverse(commits,parents,newPath, visitor);
			}
		}else{
			visitor.visit(commitPath);
		}
	}    
    
    private String [] getParents(String[] commits,String[][] parents,String commit){
    	int commitPosition = Arrays.asList(commits).indexOf(commit);
    	String [] commitParent = parents[commitPosition];
    	return commitParent;
    }
    
    
    private static class Visitor{
    	private Set<String> pathToRoot = null;
    	public void visit(String [] commitPath){
    		if(pathToRoot==null){
    			pathToRoot =  new LinkedHashSet<String>(Arrays.asList(commitPath));
    		}else{
    			if (commitPath.length < pathToRoot.size()) {
					pathToRoot = new LinkedHashSet<String>(Arrays.asList(commitPath));;
				}
    		}
    	}
    	public Set<String> getPathToRoot() {
			return pathToRoot;
		}
    }
    
    
        
}
