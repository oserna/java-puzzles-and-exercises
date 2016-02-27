package le.findcommonancestor;

import java.util.*;

public class MyFindCommonAncestor_Huy implements FindCommonAncestor
{
    public String findCommmonAncestor(String[] commits, String[][] parents, String commitA, String commitB)
    {
        if (commits == null || parents == null ||
            commitA == null || commitB == null ||
            commits.length != parents.length)
            throw new IllegalArgumentException();

        Ancestors ancestors = new Ancestors(commits, parents);

        Set<Integer> commonAncestors = ancestors.of(commitA);
        commonAncestors.retainAll(ancestors.of(commitB));

        if (commonAncestors.isEmpty())
            throw new IllegalArgumentException("can't find common ancestor of " + commitA + " and " + commitB);

        int min = Collections.min(commonAncestors);

        return commits[min];
    }

    private static class Ancestors {
        private Map<String, Integer> indexByCommit;
        private int[][] parentIndexes;

        public Ancestors(String[] commits,
                         String[][] parents) {

            //creat hash with enough capacity so we don't have to resize
            //hash table during insert
            indexByCommit = new HashMap<String, Integer>(commits.length*2);
            for (int i = 0; i < commits.length; i++) {
              indexByCommit.put(commits[i], i);
            }

            parentIndexes = new int[parents.length][];

            for (int i = 0; i < commits.length - 1; i++) {
              parentIndexes[i] = new int[parents[i].length];
              for (int j = 0; j < parents[i].length; j++)
                parentIndexes[i][j] = indexOf(parents[i][j]);
            }
            //parents of initial commit is empty array
            parentIndexes[commits.length - 1] = new int[0];

        }

        public Set<Integer> of(String commit) {
            Set<Integer> result = new HashSet<Integer>();
            Deque<Integer> pending = new ArrayDeque<Integer>();

            pending.push(indexOf(commit));
            result.add(indexOf(commit));

            while (!pending.isEmpty()) {
              int current = pending.pop();
              for (int parent: parentIndexes[current]) {
                if (result.add(parent))
						      pending.push(parent);
              }
            }

            return result;
        }

        private Integer indexOf(String commit) {
          Integer result = indexByCommit.get(commit);
          if (result == null)
            throw new IllegalArgumentException(commit + " doesn't exist in array of commit hashes");
          return result;
        }
    }

    private static final String[] testCommits = {"G", "F", "E", "D", "C", "B", "A"};
    private static final String[][] testParents = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
    private static final FindCommonAncestor finder = new MyFindCommonAncestor_Huy();

    private static void test(String commit1, String commit2) {
        System.out.println("common ancestor of " + commit1 + " and " + commit2 + " is " +
                         finder.findCommmonAncestor(testCommits, testParents, commit1, commit2));
    }

    public static void main(String[] args) {
        test("D", "F");
        test("D", "G");
        test("D", "D");
    }
}
