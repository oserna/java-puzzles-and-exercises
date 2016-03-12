package datatype.tree.balance;

/**
 * Created by oserna on 6/3/16.
 */
public class BalanceTree {

    public static void main(String[] args) {

        Node<String> k = new Node<>(null, null, "K");
        Node<String> l = new Node<>(null, null, "L");

        Node<String> i = new Node<>(k, null, "I");
        Node<String> j = new Node<>(l, null, "J");
        Node<String> h = new Node<>(null, null, "H");

        Node<String> d = new Node<>(h, i, "D");
        Node<String> e = new Node<>(null, j, "E");
        Node<String> f = new Node<>(null, null, "F");
        Node<String> g = new Node<>(null, null, "G");

        Node<String> b = new Node<>(d, e, "B");
        Node<String> c = new Node<>(f, g, "C");

        Node<String> a = new Node<>(b, c,  "A");

        depth(a);

    }




    private static int depth(Node<String> root){

        if (root == null) {
            return 0;
        } else {
            final int leftDepth = depth(root.getLeft());
            final int rightDepth = depth(root.getRight());

            if (leftDepth > rightDepth) {
                if (leftDepth - rightDepth > 1) {
                    throw new RuntimeException("Node " + root.getValue() + " unbalanced");
                }
                return leftDepth + 1;
            }

            if (rightDepth > leftDepth) {
                if (rightDepth - leftDepth > 1) {
                    throw new RuntimeException("Node " + root.getValue() + " unbalanced");
                }
                return rightDepth + 1;
            }

            return leftDepth + 1;
        }

    }
}
