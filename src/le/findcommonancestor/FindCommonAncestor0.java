package le.findcommonancestor;

import java.util.*;

public class FindCommonAncestor0 implements FindCommonAncestor
{
    private Map<String, Integer> indexByCommit;

    public String findCommmonAncestor(String[] commits,
            String[][] parents, String commitA, String commitB)
    {
        if (commits == null || parents == null ||
            commitA == null || commitB == null ||
            commits.length != parents.length)
            throw new IllegalArgumentException();

        indexByCommit = new HashMap<String, Integer>();
        for (int i = 0; i < commits.length; i++) {
          indexByCommit.put(commits[i], i);
        }

        BitSet ancestors = new BitSet(commits.length);
        Deque<Integer> ancestorsA = new ArrayDeque<Integer>();
        Deque<Integer> ancestorsB = new ArrayDeque<Integer>();

        ancestorsA.offer(indexOf(commitA));
        ancestorsB.offer(indexOf(commitB));

        while (true) {
          Integer a = ancestorsA.poll();
          Integer b = ancestorsB.poll();
          if (a == null && b == null)
            break;

          if (a != null) {
            if (ancestors.get(a))
              return commits[a];
            ancestors.set(a);
            if (parents[a] !=null) {
              for (String p: parents[a]) {
                ancestorsA.offer(indexOf(p));
              }
            }
          }

          if (b != null) {
            if (ancestors.get(b))
              return commits[b];
            ancestors.set(b);
            if (parents[b] !=null) {
              for (String p: parents[b]) {
                ancestorsB.offer(indexOf(p));
              }
            }
          }
        }
        return null;
    }

    private Integer indexOf(String commit) {
      Integer result = indexByCommit.get(commit);
      if (result == null)
          throw new IllegalArgumentException(commit + " doesn't exist in array of commit hashes");
        return result;
    }
    private static final String[] testCommits = {"G", "F", "E", "D", "C", "B", "A"};
    private static final String[][] testParents = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
    private static final FindCommonAncestor finder = new FindCommonAncestor0();

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
