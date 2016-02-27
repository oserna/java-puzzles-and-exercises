package le.findcommonancestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * given list of git commits in order from latest to first and their corresponding parents
 * if a commit has two parents, it is a merge commit. 
 * Find least common ancestor of two given commits also called merge base, which is an ancestor that is closest to both given commits.
 * @author oserna
 *
 *    {"G",       "F",   "E",   "D",   "C",   "B" , "A"};
      {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

 *
 */
public class MyFindCommonAncestor implements FindCommonAncestor
{

    public String findCommmonAncestor(String[] commits,String[][] parents, String commitA, String commitB){
    	
    	if(commitA == null || commitB == null) 
            throw new IllegalArgumentException();
    	
    	if(commitA.equals(commitB)) return commitA;
    	
    	List<Set<String>> ancestorsA = findAncestors(commits, parents, commitA);
    	if (isContained(ancestorsA, commitB)) return commitB;
    	
    	List<Set<String>> ancestorsB = findAncestors(commits, parents, commitB);
    	if (isContained(ancestorsB, commitA)) return commitA;
    	
    	return findCommonAncestors(ancestorsA, ancestorsB);
    }   
    
    private String findCommonAncestors(List<Set<String>> ancestorsA, List<Set<String>> ancestorsB){
    	for (Set<String> pathA : ancestorsA) {
        	for (Set<String> pathB : ancestorsB) {
        		String commonAncestor = findCommonAncestors(pathA, pathB);
        		if(commonAncestor != null) return commonAncestor; 
			}
		}
    	return null;
    }
    
    private String findCommonAncestors(Set<String> pathA, Set<String> pathB){
    	for (String commit : pathA) {
			if (pathB.contains(commit)) return commit;
		}
    	return null;
    }
    
    private List<Set<String>> findAncestors(String[] commits,String[][] parents, String commit){
    	Visitor visitor = new Visitor();
    	traverse(commits, parents, new String[]{commit}, visitor);
    	return visitor.getPaths();
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
    
    private boolean isContained(List<Set<String>> ancestors, String commit){
    	for (Set<String> set : ancestors) {
			if(set.contains(commit)) return true;		
		}
    	return false;
    }

    
    private static class Visitor{
    	private List<Set<String>> paths = null;
    	public Visitor() {
			this.paths = new ArrayList<>();
		}
    	public void visit(String [] commitPath){
    		LinkedHashSet<String> set = new LinkedHashSet<String>();
    		for (String commit : commitPath) {
				set.add(commit);
			}
    		paths.add(set);
    	}
    	public List<Set<String>> getPaths() {
			return paths;
		}
    }
    
    
        
}
