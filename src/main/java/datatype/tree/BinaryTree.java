package datatype.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree<T> {

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    protected Node<T> root;

    public Node<T> tree() {
        return root;
    }


    /* Let us create following BT
           20
         /   \
        8    22
      /  \    \
     4   12   25
        /  \
       10  14
     */

    //Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
    //Expected: 20 8 4 10 14 25 22

    public List<Node<T>> boundaries()   {

        Set<Node<T>> boundaries = new LinkedHashSet<>();
        boundaries.add(root);

        Node<T> node = root;
        while ((node = node.getLeft()) != null) {
            boundaries.add(node);
        }

        Deque<Node<T>> nodes = new ArrayDeque<>();
        nodes.addLast(root);

        while (!nodes.isEmpty()) {

            Node<T> first = nodes.peekFirst();

            Node<T> left = first.getLeft();
            if (left != null && !left.isVisited()) {
                nodes.addFirst(left);
                continue;
            }

            Node<T> right = first.getRight();
            if (right != null && !right.isVisited()) {
                nodes.addFirst(right);
                continue;
            }

            first.setVisited(true);

            if (left == null && right == null) {
                boundaries.add(first);
            }

            nodes.removeFirst();
        }

        node = root;
        while ((node = node.getRight()) != null) {
            nodes.addFirst(node);
        }

        boundaries.addAll(nodes);

        return new ArrayList<>(boundaries);
    }

    /*
    Ex 1: the top view of the below binary tree is 4 2 1 3 7

                 1
               /  \
             2      3
           /  \    / \
          4    5  6   7

    Ex 2: the top view of the below binary tree is B A C F:

          A
        /   \
       B     C
         \
          D
           \
            E
             \
              F
     */
    public List<Node<T>> topView() {

        //helper class that aggregates a node with its position related to a fictitious central axis
        class Tuple<X,Y,Z> {

            private final X x;
            private final Y y;
            private final Z z;

            public Tuple(X x, Y y, Z z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }

            public X getX() {return x;}

            public Y getY() {return y; }

            public Z getZ() {return z;}
        }

        //root tuple and first top node
        Tuple<Node<T>, Integer, Integer> rootTuple = new Tuple<>(root, 0, 0);

        //data structure to keep the highest tuples per width
        SortedMap<Integer, Tuple<Node<T>,Integer,Integer>> topTuples = new TreeMap<>(Integer::compare);

        topTuples.put(0, rootTuple);

        //data structure to help traverse the tree DFS in order
        Deque<Tuple<Node<T>, Integer, Integer>> tuples = new ArrayDeque<>();

        tuples.add(rootTuple);

        //traverse the tree looking for the min and max width related to a fictitious central axis
        int min = 0;
        int max = 0;
        int currentWidth = 0;
        int currentDepth = 0;

        while (!tuples.isEmpty()) {

            Tuple<Node<T>, Integer, Integer> tuple = tuples.peekFirst();
            currentWidth = tuple.getY();
            currentDepth = tuple.getZ();

            if (currentWidth < min) min = currentWidth;

            if (currentWidth > max) max = currentWidth;

            Node<T> left = tuple.getX().getLeft();
            if (left != null && !left.isVisited()) {
                tuples.addFirst(new Tuple<>(left, --currentWidth, ++currentDepth));
                continue;
            }

            tuple.getX().setVisited(true);

            Tuple<Node<T>, Integer, Integer> tupleToRemove = tuples.removeFirst();

            if (!topTuples.containsKey(tupleToRemove.getY())){
                topTuples.put(tupleToRemove.getY(), tupleToRemove);
            } else {
                if(topTuples.get(tupleToRemove.getY()).getZ() > tupleToRemove.getZ()) {
                    topTuples.put(tupleToRemove.getY(), tupleToRemove);
                }
            }

            Node<T> right = tuple.getX().getRight();
            if (right != null && !right.isVisited()) {
                tuples.addFirst(new Tuple<>(right, ++currentWidth, ++currentDepth));
                continue;
            }
        }

        return topTuples.values().stream()
                .map(Tuple::getX)
                .collect(Collectors.toList());
    }

}
